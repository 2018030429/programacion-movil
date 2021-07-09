package com.upsin.agenda;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  public final ArrayList<Contact> contacts = new ArrayList<>();
  public EditText edtName;
  public EditText edtFirstPhone;
  public EditText edtSecondPhone;
  public EditText edtAddress;
  public EditText edtNotes;
  public CheckBox cbFavorite;
  public Contact saveContact;
  public int savedIndex;

  private Button _btnSave;
  private Button _btnClean;
  private Button _btnToList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.initializeComponents();

    this._btnSave.setOnClickListener(v -> {
      if (this.areInputsIncomplete()) {
        Toast.makeText(
          MainActivity.this, R.string.ErrorMessage, Toast.LENGTH_SHORT
        ).show();
      } else {
        this.createNewContact();
      }
    });

    this._btnToList.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, ListActivity.class);
      Bundle bundleObject = new Bundle();
      bundleObject.putSerializable("contacts", this.contacts);
      intent.putExtras(bundleObject);
      startActivityForResult(intent, 0);
    });

    this._btnClean.setOnClickListener(v -> this.cleanUp());

  }

  protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);
    if (intent != null) {
      Bundle objectBundle = intent.getExtras();

      this.saveContact = (Contact) objectBundle.getSerializable("contact");
      this.savedIndex = objectBundle.getInt("index");

      this.edtName.setText(saveContact.get_name());
      this.edtFirstPhone.setText(saveContact.get_firstPhone());
      this.edtSecondPhone.setText(saveContact.get_secondPhone());
      this.edtAddress.setText(saveContact.get_address());
      this.edtNotes.setText(saveContact.get_notes());
      this.cbFavorite.setChecked(saveContact.is_favorite());
    } else {
      this.cleanUp();
    }
  }

  private void initializeComponents() {
    this.edtName = findViewById(R.id.edtName);
    this.edtFirstPhone = findViewById(R.id.edtPhone1);
    this.edtSecondPhone = findViewById(R.id.edtPhone2);
    this.edtAddress = findViewById(R.id.edtAddress);
    this.edtNotes = findViewById(R.id.edtNotes);
    this.cbFavorite = findViewById(R.id.cbFavorite);
    this._btnSave = findViewById(R.id.btnSave);
    this._btnClean = findViewById(R.id.btnClean);
    this._btnToList = findViewById(R.id.btnToList);
  }

  private boolean areInputsIncomplete() {
    return this.isInputEmpty(this.edtName) ||
      this.isInputEmpty(this.edtAddress) ||
      this.isInputEmpty(this.edtFirstPhone);
  }

  private boolean isInputEmpty(EditText edt) {
    return edt.getText().toString().isEmpty();
  }

  private void createNewContact() {
    Contact newContact = new Contact();
    int index = this.contacts.size();

    if (this.saveContact != null) {
      this.contacts.remove(this.savedIndex);
      newContact = saveContact;
      index = savedIndex;
    }

    newContact.set_name(this.edtName.getText().toString());
    newContact.set_firstPhone(this.edtFirstPhone.getText().toString());
    newContact.set_secondPhone(this.edtSecondPhone.getText().toString());
    newContact.set_address(this.edtAddress.getText().toString());
    newContact.set_notes(this.edtNotes.getText().toString());
    newContact.set_favorite(this.cbFavorite.isChecked());

    this.contacts.add(index, newContact);
    Toast.makeText(
      MainActivity.this, R.string.message, Toast.LENGTH_SHORT
    ).show();

    this.saveContact = null;
    this.cleanUp();
  }

  private void cleanUp() {
    this.saveContact = null;
    this.edtName.setText("");
    this.edtFirstPhone.setText("");
    this.edtSecondPhone.setText("");
    this.edtAddress.setText("");
    this.edtNotes.setText("");
    this.cbFavorite.setChecked(false);
  }

}