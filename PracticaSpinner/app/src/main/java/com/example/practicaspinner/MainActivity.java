package com.example.practicaspinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

  private TextInputEditText txtAmount;
  private Spinner currencySpinner;
  private TextView lblConvertedAmount;
  private Button btnConvert;
  private Button btnClean;
  private Button btnClose;

  private int selectedCurrency;

  @SuppressLint("SetTextI18n")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    txtAmount = findViewById(R.id.txtAmount);
    currencySpinner = findViewById(R.id.currencies);
    lblConvertedAmount = findViewById(R.id.lblConvertedAmount);
    btnConvert = findViewById(R.id.btnConvert);
    btnClean = findViewById(R.id.btnClean);
    btnClose = findViewById(R.id.btnClose);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
      MainActivity.this, R.layout.support_simple_spinner_dropdown_item,
      getResources().getStringArray(R.array.Currencies)
    );

    currencySpinner.setAdapter(adapter);
    currencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCurrency = position;
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {
        selectedCurrency = 0;
      }
    });

    btnConvert.setOnClickListener(v -> {
      if (txtAmount.getText().toString().matches("")) {
        Toast.makeText(this, "Please, introduce an amount", Toast.LENGTH_SHORT).show();
      } else {
        double amount = Double.parseDouble(txtAmount.getText().toString());
        String convertedAmount = this.calculateCurrency(amount, this.selectedCurrency);
        lblConvertedAmount.setText("Total: " + convertedAmount);
      }
    });

    btnClean.setOnClickListener(v -> {
      lblConvertedAmount.setText("Total: ");
      currencySpinner.setSelection(0);
      txtAmount.setText("");
    });

    btnClose.setOnClickListener(v -> {
      AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
      dlg.setTitle(R.string.title);
      dlg.setMessage(R.string.message)
        .setCancelable(false)
        .setPositiveButton("OK", (dialog, which) -> finish())
        .setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
      AlertDialog alertDialog = dlg.create();
      alertDialog.show();
    });

  }

  private String calculateCurrency(double amount, int currencyIndex) {
    switch (currencyIndex) {
      case 0:
        return Math.round((amount / 19.880)*100.0)/100.0 + " USD";
      case 1:
        return Math.round((amount / 24.307)*100.0)/100.0 + " EUR";
      case 2:
        return Math.round((amount / 16.478)*100.0)/100.0 + " CAD";
      case 3:
        return Math.round((amount / 28.206)*100.0)/100.0 + " GBP";
      default:
        return amount + " MXN";
    }
  }

}
