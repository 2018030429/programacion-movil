package com.upsin.preexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private EditText _name;
  private EditText _age;
  private Button _btnIMC;
  private Button _btnConverter;
  private Button _btnClose;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.initializeComponents();

    this._btnIMC.setOnClickListener(v -> {
      if (this.areInputsValid()) {
        Toast.makeText(this, "Todo Gud", Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(this, "The name or age are invalid.", Toast.LENGTH_SHORT).show();
      }
    });

    this._btnConverter.setOnClickListener(v -> {
      if (this.areInputsValid()) {
        Toast.makeText(this, "Todo Gud", Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(this, "The name or age are invalid.", Toast.LENGTH_SHORT).show();
      }
    });

    this._btnClose.setOnClickListener(v -> {
      AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
      dlg.setTitle("Exit");
      dlg.setMessage("Are you sure to close the app?")
        .setCancelable(false)
        .setPositiveButton("OK", (dialog, which) -> finish())
        .setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
      AlertDialog alertDialog = dlg.create();
      alertDialog.show();
    });
  }

  private void initializeComponents() {
    this._name = findViewById(R.id.inName);
    this._age = findViewById(R.id.inAge);
    this._btnIMC = findViewById(R.id.btnImc);
    this._btnConverter = findViewById(R.id.btnConverter);
    this._btnClose = findViewById(R.id.btnClose);
  }

  private boolean isNameNotEmpty() {
    return !this._name.getText().toString().trim().isEmpty();
  }

  private boolean isAgeValid() {
    String ageStringify = this._age.getText().toString().trim();
    return ageStringify.matches("\\d+");
  }

  private boolean areInputsValid() {
    return this.isNameNotEmpty() && this.isAgeValid();
  }

}