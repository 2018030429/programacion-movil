package com.upsin.baby;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {

  private String _image;
  private String _header;
  private String _description;

  public Item(String image, String header, String description) {
    this._image = image;
    this._header = header;
    this._description = description;
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

  public static ArrayList<Item> getAllItems() {
    ArrayList<Item> itemList = new ArrayList<>();

    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_1).toString(),
      "Capa", "Capa azul marino"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_2).toString(),
      "Babero", "Babero Super Bowl"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_3).toString(),
      "Pijama", "Pijama de dinosaurios blanca"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_4).toString(),
      "Pijama", "Pijama de dinosaurios azul"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_5).toString(),
      "Pijama", "Pijama 4 de julio"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_6).toString(),
      "Pijama", "Pijama de gatitos"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_7).toString(),
      "Pijama", "Pijama 4 de julio"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_8).toString(),
      "Calcetas", "Calcetas de colores"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_9).toString(),
      "Traje", "Traje de vaquero"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_10).toString(),
      "Joggers", "Joggers azules"  ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_11).toString(),
      "Gorro", "Gorro blanco y gris"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_12).toString(),
      "Mameluco", "Mameluco Pride"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_13).toString(),
      "Pijama", "Pijama Halloween"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_14).toString(),
      "Gorro", "Gorro de osito"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_15).toString(),
      "Mameluco", "Mameluco Super Bowl"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_16).toString(),
      "Traje", "Traje NYC"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_17).toString(),
      "Traje", "Traje MLB"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_18).toString(),
      "Traje", "Traje de cumpleaños"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_19).toString(),
      "Sandalias", "Sandalias azules"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_20).toString(),
      "Tennis", "Tennis celestes"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_21).toString(),
      "Lentes", "Lentes de sol color naranja"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_22).toString(),
      "Sandalias", "Sandalias Vintage"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_23).toString(),
      "Chanclas", "Chanclas Pride"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_24).toString(),
      "Mameluco", "Mameluco Howard"
    ));
    itemList.add(new Item(
      Uri.parse("android.resource://com.upsin.baby/"+R.drawable.babyitem_25).toString(),
      "Mameluco", "Mameluco temático"
    ));

    return itemList;
  }

}
