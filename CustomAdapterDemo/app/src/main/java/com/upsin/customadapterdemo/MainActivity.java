package com.upsin.customadapterdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

  private RecyclerView _recyclerView;
  private RecyclerView.LayoutManager _layoutManager;
  private FloatingActionButton _floatingBtnAdd;
  private MyApplication app;

  private Student _student;
  private int _position = -1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.app = (MyApplication) getApplication();
    this._recyclerView = findViewById(R.id.recyclerId);
    this._recyclerView.setAdapter(app.getAdapter());

    this._floatingBtnAdd = findViewById(R.id.addNewStudent);

    this._layoutManager = new LinearLayoutManager(this);
    this._recyclerView.setLayoutManager(_layoutManager);

    this._floatingBtnAdd.setOnClickListener(v -> {
      this._student = null;
      Intent intent = new Intent(MainActivity.this, StudentRegistration.class);
      Bundle bundleObject = new Bundle();
      bundleObject.putSerializable("student", this._student);
      bundleObject.putInt("position", this._position);
      intent.putExtras(bundleObject);

      startActivityForResult(intent, 0);
    });

    app.getAdapter().setOnClickListener(v -> {
      this._position = this._recyclerView.getChildAdapterPosition(v);
      this._student = MyApplication.getStudents().get(this._position);

      Intent intent = new Intent(MainActivity.this, StudentRegistration.class);
      Bundle bundleObject = new Bundle();
      bundleObject.putSerializable("student", this._student);
      intent.putExtra("position", this._position);
      intent.putExtras(bundleObject);

      startActivityForResult(intent, 1);
    });
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    Objects.requireNonNull(this._recyclerView.getAdapter()).notifyDataSetChanged();
    this._position = -1;
  }
}