package com.upsin.customadapterdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.upsin.customadapterdemo.modelo.StudentsDB;

public class StudentRegistration extends AppCompatActivity {

  private Button _btnSave, _btnBack, _btnDelete;
  private Student _student;
  private EditText _txtName, _txtEnrollment, _txtCareer;
  private TextView _txtViewId;
  private ImageView _studentImg;
  private Button _btnImage;
  private int _position;
  private Uri selectedImgUri;
  private StudentsDB _studentDB;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_student_registration);

    this._studentDB = new StudentsDB(getApplicationContext());

    this.initializeComponents();

    if (this._position >= 0) {
      this.fillStudent();
    }

    this._btnSave.setOnClickListener(v -> {
      if (this._student == null) {
        this._student = new Student();
        this.setBasicInfo();

        if (this.areInputsEmpty()) {
          Toast.makeText(
            getApplicationContext(), "There are empty values", Toast.LENGTH_SHORT
          ).show();
          this._txtEnrollment.requestFocus();
          this._student = null;
        } else {
          long index = this._studentDB.insertStudent(this._student);
          this._student.set_id(index);
          MyApplication.getStudents().add(this._student);
          setResult(Activity.RESULT_OK);
          finish();
        }
      }

      if (this._position >= 0) {
        this.setBasicInfo();

        this._studentDB.updateStudent(this._student);

        MyApplication.getStudents().get(this._position).set_enrollment(this._student.get_enrollment());
        MyApplication.getStudents().get(this._position).set_name(this._student.get_name());
        MyApplication.getStudents().get(this._position).set_career(this._student.get_career());
        MyApplication.getStudents().get(this._position).set_img(this._student.get_img());

        Toast.makeText(
          getApplicationContext(), "Modified successfully", Toast.LENGTH_SHORT
        ).show();
        finish();
      }
    });

    this._btnBack.setOnClickListener(v -> {
      setResult(Activity.RESULT_CANCELED);
      finish();
    });

    this._btnDelete.setOnClickListener(v -> {
      if (this._position >= 0) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Remove Student");
        dialog.setMessage("Ara you sure to delete this student?");
        dialog.setNegativeButton("Cancel", null);
        dialog.setPositiveButton("Delete", (d,w) -> {
          MyApplication.getStudents().remove(_position);
          this._studentDB.deleteStudent(this._student.get_id());
          Toast.makeText(
            getApplicationContext(), "Student deleted successfully", Toast.LENGTH_SHORT
          ).show();
          finish();
        });
        AlertDialog dlg = dialog.create();
        dlg.show();
      } else {
        Toast.makeText(
          getApplicationContext(), "This is not possible now", Toast.LENGTH_SHORT
        ).show();
      }
    });

    this._btnImage.setOnClickListener(v -> {
      Intent intent = new Intent();
      intent.setType("image/*");
      intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
      intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
      intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
      startActivityForResult(Intent.createChooser(intent, "Chose app"), 0);
    });
  }

  private void initializeComponents() {
    this._btnSave = findViewById(R.id.btnSave);
    this._btnBack = findViewById(R.id.btnBack);
    this._btnDelete = findViewById(R.id.btnDelete);
    this._txtEnrollment = findViewById(R.id.txtEnrollment);
    this._txtName = findViewById(R.id.txtName);
    this._txtCareer = findViewById(R.id.txtCareer);
    this._studentImg = findViewById(R.id.imageStudent);
    this._btnImage = findViewById(R.id.btnChoseImage);
    this._txtViewId = findViewById(R.id.txtViewId);

    Bundle bundleObject = getIntent().getExtras();
    this._student = (Student) bundleObject.getSerializable("student");
    this._position = bundleObject.getInt("position", this._position);
  }

  private void fillStudent() {
    this._txtViewId.setText(String.valueOf(this._student.get_id()));
    this._txtEnrollment.setText(this._student.get_enrollment());
    this._txtName.setText(this._student.get_name());
    this._txtCareer.setText(this._student.get_career());
    this._studentImg.setImageURI(Uri.parse(this._student.get_img()));
  }

  private void setBasicInfo() {
    this._student.set_career(this._txtCareer.getText().toString());
    this._student.set_enrollment(this._txtEnrollment.getText().toString());
    this._student.set_name(this._txtName.getText().toString());
    this._student.set_img(this.getProfileImg());
  }

  private boolean areInputsEmpty() {
    return this.isInputEmpty(this._txtName) ||
      this.isInputEmpty(this._txtEnrollment) ||
      this.isInputEmpty(this._txtCareer);
  }

  private boolean isInputEmpty(EditText editText) {
    return editText.getText().toString().isEmpty();
  }

  private String getProfileImg() {
    if (this.selectedImgUri == null && this._student.get_img() == null)
      return Uri.parse("android.resource://com.upsin.customadapterdemo/"+R.drawable.profile).toString();
    if (this.selectedImgUri == null) return this._student.get_img();
    return this.selectedImgUri.toString();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode != RESULT_CANCELED) {
      this.selectedImgUri = data.getData();
      if (selectedImgUri != null) {
        this._studentImg.setImageURI(selectedImgUri);
      }
    }
  }
}