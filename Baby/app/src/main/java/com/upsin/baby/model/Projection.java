package com.upsin.baby.model;

import android.database.Cursor;
import com.upsin.baby.Item;
import java.util.ArrayList;

public interface Projection {

  public Item getItem(String invoice);
  public ArrayList<Item> getAllItems();
  public Item readItem(Cursor cursor);

}
