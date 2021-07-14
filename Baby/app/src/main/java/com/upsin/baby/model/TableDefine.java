package com.upsin.baby.model;

import android.provider.BaseColumns;

public class TableDefine {
  public static abstract class BabyTable implements BaseColumns {

    public static final String TABLE_NAME = "items";
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_DESCRIPTION = "description";
    public static final String COLUMN_NAME_PRICE = "price";
    public static final String COLUMN_NAME_PHOTO = "photo";
    public static final String COLUMN_NAME_INVOICE = "invoice";
    public static String[] RECORD = new String[] {
      BabyTable.COLUMN_NAME_ID,
      BabyTable.COLUMN_NAME_TITLE,
      BabyTable.COLUMN_NAME_DESCRIPTION,
      BabyTable.COLUMN_NAME_PRICE,
      BabyTable.COLUMN_NAME_PHOTO,
      BabyTable.COLUMN_NAME_INVOICE
    };

  }
}
