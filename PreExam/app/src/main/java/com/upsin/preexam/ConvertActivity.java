package com.upsin.preexam;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConvertActivity extends AppCompatActivity {

  private TextView _txtName;
  private EditText _inGrades;
  private RadioButton _rdToFahrenheit;
  private RadioButton _rdToCelsius;
  private TextView _txtResultConvert;
  private Button _btnConvert;
  private Button _btnClean;
  private Button _btnBack;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_converter);

    this.initializeComponents();

    this._btnConvert.setOnClickListener(v -> {
      if (this.isGradeValid()) {
        if (this._rdToFahrenheit.isChecked()) {
          this.toFahrenheit();
        }
        if (this._rdToCelsius.isChecked()){
          this.toCelsius();
        }
      } else {
        Toast.makeText(this, "Please introduce a valid grade", Toast.LENGTH_SHORT).show();
      }
    });

    this._btnClean.setOnClickListener(v -> this.cleanInputs());

    this._btnBack.setOnClickListener(v -> finish());

  }

  private void initializeComponents() {
    Bundle inputs = getIntent().getExtras();
    this._txtName = findViewById(R.id.txtNameConverter);
    this._txtName.setText("Welcome: " + inputs.getString("user"));
    this._txtResultConvert = findViewById(R.id.txtConvertResult);

    this._inGrades = findViewById(R.id.inGrades);

    this._rdToFahrenheit = findViewById(R.id.rdToFahrenheit);
    this._rdToFahrenheit.setSelected(true);

    this._rdToCelsius = findViewById(R.id.rdToCelsius);

    this._btnConvert = findViewById(R.id.btnCalculate);
    this._btnClean = findViewById(R.id.btnClean);
    this._btnBack = findViewById(R.id.btnBack);
  }

  private boolean isGradeValid() {
    String stringify = this._inGrades.getText().toString().trim();
    return stringify.matches("\\d+(?:\\.\\d+)?");
  }

  private double parseGrades() {
    System.out.println(
      Double.parseDouble(this._inGrades.getText().toString())
    );
    return Double.parseDouble(this._inGrades.getText().toString());
  }

  private void toFahrenheit() {
    System.out.println(
      "C -> F"
    );
    double C = this.parseGrades();
    double toFa = ((9/5f) * C) + 32;
    this._txtResultConvert.setText(String.format("%.2f", toFa));
  }

  private void toCelsius() {
    System.out.println(
      "F -> C"
    );
    double F = this.parseGrades();
    double toCel = (F - 32) * (5/9f);
    this._txtResultConvert.setText(String.format("%.2f", toCel));
  }

  private void cleanInputs() {
    this._inGrades.setText("");
    this._txtResultConvert.setText("00.00");
  }

}
