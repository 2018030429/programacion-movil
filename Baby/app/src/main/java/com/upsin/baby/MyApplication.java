package com.upsin.baby;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {

  private ArrayList<Item> _itemList;
  private MyAdapter _adapter;

  public ArrayList<Item> get_itemList() {
    return _itemList;
  }

  public MyAdapter get_adapter() {
    return _adapter;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    this._itemList = Item.getAllItems();
    this._adapter = new MyAdapter(this._itemList);
  }
}
