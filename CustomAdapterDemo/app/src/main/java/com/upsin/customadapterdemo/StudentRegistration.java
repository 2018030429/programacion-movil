package com.upsin.customadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class StudentRegistration extends AppCompatActivity {

  private Button _btnSave, _btnBack;
  private Student _student;
  private EditText _txtName, _txtEnrollment, _txtCareer;
  private ImageView _studentImg;
  private String _career = "Ing. En Tec. Info.";
  private Button _btnImage;
  private int _position;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_student_registration);

    this.initializeComponents();

    if (this._position >= 0) {
      this.fillStudent();
    }

    this._btnSave.setOnClickListener(v -> {

      System.out.println(this._position);
      System.out.println(this._student == null);

      if (this._student == null) {
        this._student = new Student();
        this.setBasicInfo();
        this._student.set_img(R.drawable.profile);

        if (this.areInputsEmpty()) {
          Toast.makeText(
            getApplicationContext(), "There are empty values", Toast.LENGTH_SHORT
          ).show();
          this._txtEnrollment.requestFocus();
          this._student = null;
        } else {
          MyApplication.getStudents().add(this._student);
          setResult(Activity.RESULT_OK);
          finish();
        }
      }

      if (this._position >= 0) {
        this.setBasicInfo();

        MyApplication.getStudents().get(this._position).set_enrollment(this._student.get_enrollment());
        MyApplication.getStudents().get(this._position).set_name(this._student.get_name());
        MyApplication.getStudents().get(this._position).set_career(this._student.get_career());

        Toast.makeText(
          getApplicationContext(), "Modified successfully", Toast.LENGTH_SHORT
        ).show();
      }

    });

    this._btnBack.setOnClickListener(v -> {
      setResult(Activity.RESULT_CANCELED);
      finish();
    });

  }

  private void initializeComponents() {
    this._btnSave = findViewById(R.id.btnSave);
    this._btnBack = findViewById(R.id.btnBack);
    this._txtEnrollment = findViewById(R.id.txtEnrollment);
    this._txtName = findViewById(R.id.txtName);
    this._txtCareer = findViewById(R.id.txtCareer);
    this._studentImg = findViewById(R.id.imageStudent);
    this._btnImage = findViewById(R.id.btnChoseImage);

    Bundle bundleObject = getIntent().getExtras();
    this._student = (Student) bundleObject.getSerializable("student");
    this._position = bundleObject.getInt("position", this._position);
  }

  private void fillStudent() {
    this._txtEnrollment.setText(this._student.get_enrollment());
    this._txtName.setText(this._student.get_name());
    this._txtCareer.setText(this._student.get_career());
    this._studentImg.setImageResource(this._student.get_img());
  }

  private void setBasicInfo() {
    this._student.set_career(this._txtCareer.getText().toString());
    this._student.set_enrollment(this._txtEnrollment.getText().toString());
    this._student.set_name(this._txtName.getText().toString());
  }

  private boolean areInputsEmpty() {
    return this.isInputEmpty(this._txtName) ||
      this.isInputEmpty(this._txtEnrollment) ||
      this.isInputEmpty(this._txtCareer);
  }

  private boolean isInputEmpty(EditText editText) {
    return editText.getText().toString().isEmpty();
  }

}