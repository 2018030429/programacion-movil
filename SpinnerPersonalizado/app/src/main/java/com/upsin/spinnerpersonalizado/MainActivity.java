package com.upsin.spinnerpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  Spinner spinner;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ArrayList<ItemData> list = new ArrayList<>();

    list.add(
      new ItemData(
        getString(R.string.itemPhrases),
        getString(R.string.msgPhrases),
        R.drawable.categorias
      )
    );

    list.add(
      new ItemData(
        getString(R.string.itemGratitude),
        getString(R.string.msgGratitude),
        R.drawable.agradecimiento
      )
    );

    list.add(
      new ItemData(
        getString(R.string.itemLove),
        getString(R.string.msgLove),
        R.drawable.amor
      )
    );

    list.add(
      new ItemData(
        getString(R.string.itemNewYear),
        getString(R.string.msgNewYear),
        R.drawable.nuevo
      )
    );

    list.add(
      new ItemData(
        getString(R.string.itemSongs),
        getString(R.string.msgSongs),
        R.drawable.canciones
      )
    );

    spinner = findViewById(R.id.spinner1);
    SpinnerAdapter adapter = new SpinnerAdapter(
      this,
      R.layout.spinner_layout,
      R.id.lblCategory,
      list
    );
    spinner.setAdapter(adapter);
    spinner.setOnItemSelectedListener(
      new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          Toast.makeText(
            parent.getContext(),
            getString(R.string.msgSelected) + " " +
                ((ItemData) parent.getItemAtPosition(position)).getCategory(),
            Toast.LENGTH_SHORT
          ).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
      }
    );

  }
}