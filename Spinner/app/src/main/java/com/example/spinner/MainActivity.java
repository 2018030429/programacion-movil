package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private Spinner spinner;
  private TextView lblCountry;
  private ListView lstCountries;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // spinner = findViewById(R.id.spnCountries);
    lblCountry = findViewById(R.id.lblCountry);
    lstCountries = findViewById(R.id.lstCountries);

    // Creating the Adapter
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
      MainActivity.this, R.layout.support_simple_spinner_dropdown_item,
      getResources().getStringArray(R.array.countries)
    );

    // spinner.setAdapter(adapter);
    lstCountries.setAdapter(adapter);

    /*
    * @param parent -> Spinner reference
    * @param view -> Parent view reference
    * @param position -> Object position
    * @param id -> Reference
    * */
    /*
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String country = parent.getItemAtPosition(position).toString();
        lblCountry.setText(country);
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });
    */

    lstCountries.setOnItemClickListener((parent, view, position, id) -> {
      String country = parent.getItemAtPosition(position).toString();
      lblCountry.setText(country);
    });

  }
}
