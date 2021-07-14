package com.upsin.customadapterdemo.modelo;

import android.provider.BaseColumns;

public class TableDefine {

  public TableDefine() {}

  public static abstract class Students implements BaseColumns {

    public static final String TABLE_NAME = "students";
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_ENROLLMENT = "enrollment";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_CAREER = "career";
    public static final String COLUMN_NAME_PHOTO = "photo";
    public static String[] RECORD = new String[] {
      Students.COLUMN_NAME_ID,
      Students.COLUMN_NAME_ENROLLMENT,
      Students.COLUMN_NAME_NAME,
      Students.COLUMN_NAME_CAREER,
      COLUMN_NAME_PHOTO
    };


  }

}
