package com.upsin.baby;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Item {

  private final int _image;
  private final String _header;
  private final String _description;

  public Item(int image, String header, String description) {
    this._image = image;
    this._header = header;
    this._description = description;
  }

  public int getImage() {
    return _image;
  }

  public String getDescription() {
    return _description;
  }

  public String getHeader() {
    return _header;
  }

  public static ArrayList<Item> getAllItems() {
    ArrayList<Item> itemList = new ArrayList<>();

    itemList.add(new Item(R.drawable.babyitem_1, "Capa", "Capa azul marino"));
    itemList.add(new Item(R.drawable.babyitem_2, "Babero", "Babero Super Bowl"));
    itemList.add(new Item(R.drawable.babyitem_3, "Pijama", "Pijama de dinosaurios blanca"));
    itemList.add(new Item(R.drawable.babyitem_4, "Pijama", "Pijama de dinosaurios azul"));
    itemList.add(new Item(R.drawable.babyitem_5, "Pijama", "Pijama 4 de julio"));
    itemList.add(new Item(R.drawable.babyitem_6, "Pijama", "Pijama de gatitos"));
    itemList.add(new Item(R.drawable.babyitem_7, "Pijama", "Pijama 4 de julio"));
    itemList.add(new Item(R.drawable.babyitem_8, "Calcetas", "Calcetas de colores"));
    itemList.add(new Item(R.drawable.babyitem_9, "Traje", "Traje de vaquero"));
    itemList.add(new Item(R.drawable.babyitem_10, "Joggers", "Joggers azules"));
    itemList.add(new Item(R.drawable.babyitem_11, "Gorro", "Gorro blanco y gris"));
    itemList.add(new Item(R.drawable.babyitem_12, "Mameluco", "Mameluco Pride"));
    itemList.add(new Item(R.drawable.babyitem_13, "Pijama", "Pijama Halloween"));
    itemList.add(new Item(R.drawable.babyitem_14, "Gorro", "Gorro de osito"));
    itemList.add(new Item(R.drawable.babyitem_15, "Mameluco", "Mameluco Super Bowl"));
    itemList.add(new Item(R.drawable.babyitem_16, "Traje", "Traje NYC"));
    itemList.add(new Item(R.drawable.babyitem_17, "Traje", "Traje MLB"));
    itemList.add(new Item(R.drawable.babyitem_18, "Traje", "Traje de cumpleaños"));
    itemList.add(new Item(R.drawable.babyitem_19, "Sandalias", "Sandalias azules"));
    itemList.add(new Item(R.drawable.babyitem_20, "Tennis", "Tennis celestes"));
    itemList.add(new Item(R.drawable.babyitem_21, "Lentes", "Lentes de sol color naranja"));
    itemList.add(new Item(R.drawable.babyitem_22, "Sandalias", "Sandalias Vintage"));
    itemList.add(new Item(R.drawable.babyitem_23, "Chanclas", "Chanclas Pride"));
    itemList.add(new Item(R.drawable.babyitem_24, "Mameluco", "Mameluco Howard"));
    itemList.add(new Item(R.drawable.babyitem_25, "Mameluco", "Mameluco temático"));

    return itemList;
  }

}
