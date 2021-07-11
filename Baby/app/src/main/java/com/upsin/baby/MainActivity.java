package com.upsin.baby;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

  private RecyclerView _recyclerView;
  private RecyclerView.LayoutManager _layoutManager;
  private FloatingActionButton _btnNewProduct;
  private MyApplication app;

  private Item _holderItem = null;
  private int _position = -1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.initializeComponents();

    this._btnNewProduct.setOnClickListener(v -> {
      this._holderItem = null;
      this.createActivityForResult(0);
    });

    app.get_adapter().setOnClickListener(v -> {
      this._position = this._recyclerView.getChildAdapterPosition(v);
      this._holderItem = app.get_itemList().get(this._position);
      this.createActivityForResult(1);
    });
  }

  private void createActivityForResult(int requestCode) {
    Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
    Bundle bundleObject = new Bundle();

    bundleObject.putSerializable("item", this._holderItem);
    bundleObject.putInt("position", this._position);
    intent.putExtras(bundleObject);

    startActivityForResult(intent, requestCode);
  }

  private void initializeComponents() {
    this.app = (MyApplication) getApplication();
    this._recyclerView = findViewById(R.id.recyclerId);
    this._recyclerView.setAdapter(app.get_adapter());

    this._layoutManager = new LinearLayoutManager(this);
    this._recyclerView.setLayoutManager(this._layoutManager);

    this._btnNewProduct = findViewById(R.id.btnNewProduct);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    Objects.requireNonNull(this._recyclerView.getAdapter()).notifyDataSetChanged();
    this._position = -1;
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