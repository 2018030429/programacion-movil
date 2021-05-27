package com.upsin.searchview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

  private ListView lst;
  private SearchView srcList;
  private ArrayAdapter<String> adapter;
  private ArrayList<String> arrayList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    this.initializeComponent();

    lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(
          MainActivity.this,
          "::"+parent.getItemAtPosition(position).toString()+"::",
          Toast.LENGTH_LONG
        ).show();

      }
    });
  }

  private void initializeComponent() {
    lst = (ListView) findViewById(R.id.lstStudents);
    srcList = (SearchView) findViewById(R.id.menu_search);
    arrayList = new ArrayList<String>();

    // Initializing array with data
    arrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.names_array)));
    adapter = new ArrayAdapter<String>(
      MainActivity.this,
      R.layout.support_simple_spinner_dropdown_item,
      arrayList
    );
    lst.setAdapter(adapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.menuitems, menu);

    MenuItem menuItem = menu.findItem(R.id.menu_search);
    SearchView searchView = (SearchView) menuItem.getActionView();

    // Search methods
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        return false;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
      }
    });

    return super.onCreateOptionsMenu(menu);
  }

  // Item events. Sort and close


  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {

    switch (item.getItemId()) {
      case R.id.sort:
        Collections.sort(arrayList);
        return true;

      case R.id.close:
        this.finish();
        return true;
    }

    return super.onOptionsItemSelected(item);
  }
}