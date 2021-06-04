package com.upsin.spinnerpersonalizado;

public class ItemData {

  private String _txtCategory;
  private String _txtDescription;
  private Integer _imageId;

  public ItemData(String category, String description, Integer imageId) {
    this._txtCategory = category;
    this._txtDescription = description;
    this._imageId = imageId;
  }

  public String getCategory() {
    return this._txtCategory;
  }

  public void setCategory(String newCategory) {
    this._txtCategory = newCategory;
  }

  public String getDescription() {
    return this._txtDescription;
  }

  public void setDescription(String newDescription) {
    this._txtDescription = newDescription;
  }

  public Integer getImageId() {
    return this._imageId;
  }

  public void setImageId(Integer newImageId) {
    this._imageId = newImageId;
  }

}
