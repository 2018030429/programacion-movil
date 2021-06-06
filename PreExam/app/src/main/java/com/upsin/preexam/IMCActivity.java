package com.upsin.preexam;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IMCActivity extends AppCompatActivity {

  private TextView _txtName;
  private EditText _inHeightM;
  private EditText _inHeightCM;
  private EditText _inWeight;
  private TextView _txtIMCResult;
  private Button _btnCalculate;
  private Button _btnClean;
  private Button _btnBack;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_imc);

    this.initializeComponents();

    this._btnCalculate.setOnClickListener(v -> {
      if (this.areParamsValid()) {
        this._txtIMCResult.setText(String.format("%.2f",this.calculateIMC()));
      } else {
        Toast.makeText(this, "One or some params are invalid", Toast.LENGTH_SHORT).show();
      }
    });

    this._btnClean.setOnClickListener(v -> this.cleanInputs());

    this._btnBack.setOnClickListener(v -> finish());
  }

  private void initializeComponents() {
    Bundle inputs = getIntent().getExtras();
    this._txtName = findViewById(R.id.txtName);
    this._txtName.setText("Welcome: " + inputs.getString("user"));
    this._txtIMCResult = findViewById(R.id.txtIMCResult);

    this._inHeightM = findViewById(R.id.inHeightM);
    this._inHeightCM = findViewById(R.id.inHeightCm);
    this._inWeight = findViewById(R.id.inWeight);

    this._btnCalculate = findViewById(R.id.btnCalculateIMC);
    this._btnClean = findViewById(R.id.btnCleanIMC);
    this._btnBack = findViewById(R.id.btnBackIMC);
  }

  private boolean isValueValid(EditText editText) {
    String stringify = editText.getText().toString().trim();
    return stringify.matches("\\d+");
  }

  private boolean areParamsValid() {
    return this.isValueValid(this._inHeightM)
      && this.isValueValid(this._inHeightCM)
      && this.isValueValid(this._inWeight)
      && this.getHeight() > 0;
  }

  private double getHeight() {
    return Double.parseDouble(this._inHeightM.getText().toString())
      + (Double.parseDouble(this._inHeightCM.getText().toString()) / 100);
  }

  private double getWeight() {
    return Double.parseDouble(this._inWeight.getText().toString());
  }

  private double calculateIMC() {
    double height = this.getHeight();
    double weight = this.getWeight();
    return weight / (height * height);
  }

  private void cleanInputs() {
    this._inHeightM.setText("");
    this._inHeightCM.setText("");
    this._inWeight.setText("");
    this._txtIMCResult.setText("00.00");
  }

}
