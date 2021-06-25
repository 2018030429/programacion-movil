package com.upsin.baby;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

  private RecyclerView _recyclerView;
  private RecyclerView.LayoutManager _layoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    MyApplication app = (MyApplication) getApplication();
    this._recyclerView = findViewById(R.id.recyclerId);
    this._recyclerView.setAdapter(app.get_adapter());

    this._layoutManager = new LinearLayoutManager(this);
    this._recyclerView.setLayoutManager(this._layoutManager);

    app.get_adapter().setOnClickListener(v -> {
      int position = this._recyclerView.getChildAdapterPosition(v);
      String displayItem = app.get_itemList().get(position).getHeader();

      Toast.makeText(
        MainActivity.this,
        "You Clicked: " + displayItem,
        Toast.LENGTH_SHORT
      ).show();
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.menu_search, menu);

    MenuItem menuItem = menu.findItem(R.id.menu_search);
    SearchView search = (SearchView) menuItem.getActionView();

    search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        return false;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        ((MyAdapter) MainActivity.this._recyclerView.getAdapter()).getFilter().filter(newText);
        return false;
      }
    });

    return true;
  }
}