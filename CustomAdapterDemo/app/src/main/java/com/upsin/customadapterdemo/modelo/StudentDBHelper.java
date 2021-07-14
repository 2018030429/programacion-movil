package com.upsin.customadapterdemo.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDBHelper extends SQLiteOpenHelper {

  private static final String TEXT_TYPE = " TEXT";
  private static final String INTEGER_TYPE = " INTEGER";
  private static final String COMMA_SEP = " ,";
  private static final String SQL_CREATE_STUDENT =
    "CREATE TABLE " + TableDefine.Students.TABLE_NAME +
      " (" + TableDefine.Students.COLUMN_NAME_ID + " INTEGER PRIMARY KEY, " +
        TableDefine.Students.COLUMN_NAME_ENROLLMENT + TEXT_TYPE + COMMA_SEP +
        TableDefine.Students.COLUMN_NAME_NAME       + TEXT_TYPE + COMMA_SEP +
        TableDefine.Students.COLUMN_NAME_CAREER     + TEXT_TYPE + COMMA_SEP +
        TableDefine.Students.COLUMN_NAME_PHOTO      + INTEGER_TYPE + COMMA_SEP +
      ") ";
  private static final String SQL_DELETE_STUDENT =
    "DROP TABLE IF EXISTS " + TableDefine.Students.TABLE_NAME;
  private static final String DATABASE_NAME = "student_system.db";
  private static final int DATABASE_VERSION = 1;

  public StudentDBHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(SQL_CREATE_STUDENT);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(SQL_DELETE_STUDENT);
    this.onCreate(db);
  }
}
