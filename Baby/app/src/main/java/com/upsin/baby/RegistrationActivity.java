package com.upsin.baby;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

  private EditText _txtFormName, _txtFormDescription, _txtFormPrice;
  private Button _btnSave, _btnBack, _btnDelete, _btnChosePhoto;
  private ImageView _ImgViewForm;
  private TextView _txtFormSrc;

  private Item _itemHolder;
  private int _position;
  private Uri _chosenUri;

  @Override
  @RequiresApi(api = Build.VERSION_CODES.KITKAT)
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_registration);

    this.initializeComponents();

    if (this._position >= 0) this.getProductDataToForm();

    this._btnBack.setOnClickListener(v -> {
      setResult(Activity.RESULT_CANCELED);
      finish();
    });

    this._btnDelete.setOnClickListener(v -> {
      if (this._position >= 0) {
        this.createDeleteAlertDialog();
      } else {
        this.createToast("This is not possible now");
      }
    });

    this._btnChosePhoto.setOnClickListener(v -> this.chosePhoto());

    this._btnSave.setOnClickListener(v -> this.saveProduct());
  }

  private void initializeComponents() {
    this._txtFormName = findViewById(R.id.txtFormName);
    this._txtFormDescription = findViewById(R.id.txtFormDescription);
    this._txtFormPrice = findViewById(R.id.txtFormPrice);
    this._btnSave = findViewById(R.id.btnFormSave);
    this._btnBack = findViewById(R.id.btnFormBack);
    this._btnDelete = findViewById(R.id.btnFormDelete);
    this._btnChosePhoto = findViewById(R.id.btnFormPhoto);
    this._ImgViewForm = findViewById(R.id.ImgViewForm);
    this._txtFormSrc = findViewById(R.id.lblFormSrc);

    Bundle bundle = getIntent().getExtras();
    this._itemHolder = (Item) bundle.getSerializable("item");
    this._position = bundle.getInt("position", this._position);
  }

  private void getProductDataToForm() {
    this._txtFormName.setText(this._itemHolder.getHeader());
    this._txtFormDescription.setText(this._itemHolder.getDescription());
    this._txtFormPrice.setText(String.valueOf(this._itemHolder.getPrice()));
    this._ImgViewForm.setImageURI(Uri.parse(this._itemHolder.getImage()));
  }

  @RequiresApi(api = Build.VERSION_CODES.KITKAT)
  private void chosePhoto() {
    Intent intent = new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
    startActivityForResult(Intent.createChooser(intent, "Choose a pic"), 0);
  }

  private void createDeleteAlertDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Remove Product");
    builder.setMessage("Are you sure to delete this product?");
    builder.setNegativeButton("Cancel", null);
    builder.setPositiveButton("Delete", (d,w) -> {
      MyApplication.getItemList().remove(this._position);
      this.createToast("Product deleted successfully");
      finish();
    });
    AlertDialog dialog = builder.create();
    dialog.show();
  }

  private void saveProduct() {
    if (this._itemHolder == null) {
      this._itemHolder = new Item();

      if (this.areInputsEmpty()) {
        this.createToast("There are empty values");
        this._txtFormName.requestFocus();
        this._itemHolder = null;
      } else {
        this.setInfoProduct();
        MyApplication.getItemList().add(this._itemHolder);
        setResult(Activity.RESULT_OK);
        finish();
      }

    }

    if (this._position >= 0) {
      this.setInfoProduct();

      MyApplication.getItemList().get(this._position).setHeader(this._itemHolder.getHeader());
      MyApplication.getItemList().get(this._position).setDescription(this._itemHolder.getDescription());
      MyApplication.getItemList().get(this._position).setPrice(this._itemHolder.getPrice());
      MyApplication.getItemList().get(this._position).setImage(this._itemHolder.getImage());

      this.createToast("Product modified successfully");
    }
  }

  private boolean areInputsEmpty() {
    return this.isInputEmpty(this._txtFormName) ||
      this.isInputEmpty(this._txtFormDescription) ||
      this.isInputEmpty(this._txtFormPrice);
  }

  private boolean isInputEmpty(EditText edt) {
    return edt.getText().toString().isEmpty();
  }

  private void setInfoProduct() {
    this._itemHolder.setHeader(this._txtFormName.getText().toString());
    this._itemHolder.setDescription(this._txtFormDescription.getText().toString());
    this._itemHolder.setPrice(Float.parseFloat(this._txtFormPrice.getText().toString()));
    this._itemHolder.setImage(this.getProductImg());
  }

  private String getProductImg() {
    return (this._chosenUri == null)
      ? Uri.parse(
          "android.resource://com.upsin.baby/"+R.drawable.ic_baseline_child_friendly_24
        ).toString()
      : this._chosenUri.toString();
  }

  private void createToast(String message) {
    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode != RESULT_CANCELED) {
      this._chosenUri = data.getData();
      if (this._chosenUri != null) {
        this._ImgViewForm.setImageURI(this._chosenUri);
        this._txtFormSrc.setText(this._chosenUri.toString());
      }
    }

  }
}