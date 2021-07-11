package com.upsin.baby;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {

  private EditText _txtFormName, _txtFormDescription, _txtFormPrice;
  private Button _btnSave, _btnBack, _btnDelete, _btnChosePhoto;
  private ImageView _ImgViewForm;
  private TextView _txtFormSrc;

  private Item _itemHolder;
  private int _position;
  private Uri _chosenUri;

  @Override
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
      // TODO: make the delete code
    });

    this._btnChosePhoto.setOnClickListener(v -> {
      // TODO: make the chose photo code
    });

    this._btnSave.setOnClickListener(v -> {
      // TODO: make the save code
    });
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
    //this._txtFormPrice.setText(this._itemHolder.);
    this._ImgViewForm.setImageURI(Uri.parse(this._itemHolder.toString()));
  }

}