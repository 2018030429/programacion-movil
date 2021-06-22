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
  private final ArrayList<String> _listData = new ArrayList<String>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this._recyclerView = findViewById(R.id.recyclerId);
    this._recyclerView.setLayoutManager(
      // new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
      new GridLayoutManager(this, 2)
    );

    this._listData.addAll(Arrays.asList(getResources().getStringArray(R.array.namesArray)));
    MyAdapter adapter = new MyAdapter(this._listData);

    adapter.setOnClickListener(v -> {
      int position = this._recyclerView.getChildAdapterPosition(v);
      String item = this._listData.get(position);
      Toast.makeText(
        MainActivity.this, "You Clicked on "+ item, Toast.LENGTH_SHORT
      ).show();
    });

    this._recyclerView.setAdapter(adapter);
  }
}