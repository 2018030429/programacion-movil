package com.upsin.baby.model;

import com.upsin.baby.Item;

public interface Persistence {

  public void openDataBase();
  public void closeDataBase();
  public long insertItem(Item item);
  public long updateItem(Item item);
  public void deleteItem(long id);

}
