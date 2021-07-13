package com.upsin.baby;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {

  private String _image;
  private String _header;
  private String _description;
  private double _price;

  public Item(String image, String header, String description, double price) {
    this._image = image;
    this._header = header;
    this._description = description;
    this._price = price;
  }

  public Item() {
    this._image = "";
    this._header = "";
    this._description = "";
    this._price = 0.0;
  }

  public String getImage() {
    return _image;
  }

  public String getDescription() {
    return _description;
  }

  public String getHeader() {
    return _header;
  }

  public void setImage(String _image) {
    this._image = _image;
  }

  public void setDescription(String _description) {
    this._description = _description;
  }

  public void setHeader(String _header) {
    this._header = _header;
  }

  public double getPrice() {
    return _price;
  }

  public void setPrice(double _price) {
    this._price = _price;
  }

  public static ArrayList<Item> getAllItems() {
    ArrayList<Item> itemList = new ArrayList<>();

    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_1).toString(),
      "Capa", "Capa azul marino", 10.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_2).toString(),
      "Babero", "Babero Super Bowl", 5.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_3).toString(),
      "Pijama", "Pijama de dinosaurios blanca", 14.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_4).toString(),
      "Pijama", "Pijama de dinosaurios azul", 14.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_5).toString(),
      "Pijama", "Pijama 4 de julio", 15.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_6).toString(),
      "Pijama", "Pijama de gatitos", 14.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_7).toString(),
      "Pijama", "Pijama 4 de julio", 15.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_8).toString(),
      "Calcetas", "Calcetas de colores", 3.5
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_9).toString(),
      "Traje", "Traje de vaquero", 19.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_10).toString(),
      "Joggers", "Joggers azules", 14.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_11).toString(),
      "Gorro", "Gorro blanco y gris", 4.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_12).toString(),
      "Mameluco", "Mameluco Pride", 6.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_13).toString(),
      "Pijama", "Pijama Halloween", 14.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_14).toString(),
      "Gorro", "Gorro de osito", 4.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_15).toString(),
      "Mameluco", "Mameluco Super Bowl", 6.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_16).toString(),
      "Traje", "Traje NYC", 19.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_17).toString(),
      "Traje", "Traje MLB", 19.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_18).toString(),
      "Traje", "Traje de cumpleaños", 19.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_19).toString(),
      "Sandalias", "Sandalias azules", 5.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_20).toString(),
      "Tennis", "Tennis celestes", 14.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_21).toString(),
      "Lentes", "Lentes de sol color naranja", 12.5
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_22).toString(),
      "Sandalias", "Sandalias Vintage", 9.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_23).toString(),
      "Chanclas", "Chanclas Pride", 9.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_24).toString(),
      "Mameluco", "Mameluco Howard", 6.99
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_25).toString(),
      "Mameluco", "Mameluco temático", 7.99
    ));

    return itemList;
  }

}
