package com.upsin.baby;

import android.app.Application;

import com.upsin.baby.model.ItemsDB;

import java.util.ArrayList;

public class MyApplication extends Application {

  private static ArrayList<Item> _itemList;
  private MyAdapter _adapter;
  private ItemsDB _itemsDB;

  public static ArrayList<Item> getItemList() {
    return _itemList;
  }

  public MyAdapter get_adapter() {
    return _adapter;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    this._itemsDB = new ItemsDB(getApplicationContext());
    _itemList = this._itemsDB.getAllItems();
    this._adapter = new MyAdapter(_itemList);
  }
}
