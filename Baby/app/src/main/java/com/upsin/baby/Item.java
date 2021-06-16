package com.upsin.baby;

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
}
