package com.upsin.customadapterdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

  private RecyclerView _recyclerView;
  private RecyclerView.LayoutManager _layoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    MyApplication app = (MyApplication) getApplication();
    this._recyclerView = findViewById(R.id.recyclerId);
    this._recyclerView.setAdapter(app.getAdapter());

    this._layoutManager = new LinearLayoutManager(this);
    this._recyclerView.setLayoutManager(_layoutManager);

    app.getAdapter().setOnClickListener(v -> {
      int position = this._recyclerView.getChildAdapterPosition(v);
      String studentName = app.getStudents().get(position).get_name();
      Toast.makeText(
        MainActivity.this,
        "You clicked on " + studentName,
        Toast.LENGTH_SHORT
      ).show();
    });
  }
}