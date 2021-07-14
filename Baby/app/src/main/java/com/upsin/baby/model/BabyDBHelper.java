package com.upsin.baby.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BabyDBHelper extends SQLiteOpenHelper {

  private static final String TEXT_TYPE = " TEXT";
  private static final String INTEGER_TYPE = " INTEGER";
  private static final String COMMA_SEP = ", ";
  private static final String SQL_CREATE_ITEM =
    "CREATE TABLE " + TableDefine.BabyTable.TABLE_NAME + " (" +
      TableDefine.BabyTable.COLUMN_NAME_ID + " INTEGER PRIMARY KEY, " +
      TableDefine.BabyTable.COLUMN_NAME_TITLE       + TEXT_TYPE + COMMA_SEP +
      TableDefine.BabyTable.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
      TableDefine.BabyTable.COLUMN_NAME_PRICE       + INTEGER_TYPE + COMMA_SEP +
      TableDefine.BabyTable.COLUMN_NAME_PHOTO       + TEXT_TYPE + COMMA_SEP +
      TableDefine.BabyTable.COLUMN_NAME_INVOICE     + TEXT_TYPE +
    ") ";
  private static final String SQL_DELETE_ITEM =
    "DROP TABLE IF EXISTS " + TableDefine.BabyTable.TABLE_NAME;
  private static final String DATABASE_NAME = "baby_system.db";
  private static final int DATABASE_VERSION = 1;

  public BabyDBHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(SQL_CREATE_ITEM);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(SQL_DELETE_ITEM);
    this.onCreate(db);
  }
}
