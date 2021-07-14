package com.upsin.baby.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.upsin.baby.Item;

import java.util.ArrayList;

public class ItemsDB implements Persistence, Projection {

  private final Context _context;
  private final BabyDBHelper _helper;
  private SQLiteDatabase _db;

  public ItemsDB(Context context, BabyDBHelper helper) {
    this._context = context;
    this._helper = helper;
  }

  public ItemsDB(Context context) {
    this._context = context;
    this._helper = new BabyDBHelper(this._context);
  }

  @Override
  public void openDataBase() {
    this._db = this._helper.getWritableDatabase();
  }

  @Override
  public void closeDataBase() {
    this._helper.close();
  }

  @Override
  public long insertItem(Item item) {
    ContentValues values = new ContentValues();
    this.putItemValues(values, item);

    this.openDataBase();
    long response = this._db.insert(TableDefine.BabyTable.TABLE_NAME, null, values);
    this.closeDataBase();
    return response;
  }

  @Override
  public long updateItem(Item item) {
    ContentValues values = new ContentValues();
    this.putItemValues(values, item);

    this.openDataBase();
    long response = this._db.update(
      TableDefine.BabyTable.TABLE_NAME,
      values,
      TableDefine.BabyTable.COLUMN_NAME_ID + "=" + item.getId(),
      null
    );
    this.closeDataBase();
    return response;
  }

  @Override
  public void deleteItem(long id) {
    this.openDataBase();
    this._db.delete(
      TableDefine.BabyTable.TABLE_NAME,
      TableDefine.BabyTable.COLUMN_NAME_ID + "= ?",
      new String[] { String.valueOf(id) }
    );
    this.closeDataBase();
  }

  @Override
  public Item getItem(String invoice) {
    this._db = this._helper.getReadableDatabase();
    Cursor cursor = this._db.query(
      TableDefine.BabyTable.TABLE_NAME,
      TableDefine.BabyTable.RECORD,
      TableDefine.BabyTable.COLUMN_NAME_ID + "= ?",
      new String[] { invoice },
      null, null, null
    );
    return this.readItem(cursor);
  }

  @Override
  public ArrayList<Item> getAllItems() {
    this._db = this._helper.getReadableDatabase();
    Cursor cursor = this._db.query(
      TableDefine.BabyTable.TABLE_NAME,
      TableDefine.BabyTable.RECORD,
      null, null, null, null, null
    );

    ArrayList<Item> items = new ArrayList<>();
    cursor.moveToFirst();

    while (!cursor.isAfterLast()) {
      Item _item = this.readItem(cursor);
      items.add(_item);
      cursor.moveToNext();
    }

    cursor.close();
    return items;
  }

  @Override
  public Item readItem(Cursor cursor) {
    Item item = new Item();
    item.setId(cursor.getInt(0));
    item.setHeader(cursor.getString(1));
    item.setDescription(cursor.getString(2));
    item.setInvoice(cursor.getString(3));
    item.setPrice(cursor.getLong(4));
    item.setImage(cursor.getString(5));
    return item;
  }

  private void putItemValues(ContentValues values, Item item) {
    values.put(TableDefine.BabyTable.COLUMN_NAME_TITLE, item.getHeader());
    values.put(TableDefine.BabyTable.COLUMN_NAME_DESCRIPTION, item.getDescription());
    values.put(TableDefine.BabyTable.COLUMN_NAME_INVOICE, item.getInvoice());
    values.put(TableDefine.BabyTable.COLUMN_NAME_PRICE, item.getPrice());
    values.put(TableDefine.BabyTable.COLUMN_NAME_PHOTO, item.getImage());
  }
}
