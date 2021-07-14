package com.upsin.customadapterdemo.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.upsin.customadapterdemo.Student;

import java.util.ArrayList;

public class StudentsDB implements Persistence, Projection {

  private final Context _context;
  private final StudentDBHelper _helper;
  private SQLiteDatabase _db;

  public StudentsDB(Context context, StudentDBHelper helper) {
    this._context = context;
    this._helper = helper;
  }

  public StudentsDB(Context context) {
    this._context = context;
    this._helper = new StudentDBHelper(this._context);
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
  public long insertStudent(Student student) {
    ContentValues values = new ContentValues();
    this.putStudentValues(values, student);

    this.openDataBase();
    long response = this._db.insert(TableDefine.Students.TABLE_NAME, null, values);
    this.closeDataBase();
    return response;
  }

  @Override
  public long updateStudent(Student student) {
    ContentValues values = new ContentValues();
    this.putStudentValues(values, student);

    this.openDataBase();
    long response = this._db.update(
      TableDefine.Students.TABLE_NAME,
      values,
      TableDefine.Students.COLUMN_NAME_ID + "=" + student.get_id(),
      null);
    this.closeDataBase();
    return response;
  }

  @Override
  public void deleteStudent(long id) {
    this.openDataBase();
    this._db.delete(
      TableDefine.Students.TABLE_NAME,
      TableDefine.Students.COLUMN_NAME_ID + "= ?",
      new String[] { String.valueOf(id) }
    );
    this.closeDataBase();
  }

  @Override
  public Student getStudent(String enrollment) {
    this._db = this._helper.getReadableDatabase();
    Cursor cursor = this._db.query(
      TableDefine.Students.TABLE_NAME,
      TableDefine.Students.RECORD,
      TableDefine.Students.COLUMN_NAME_ID + "= ?",
      new String[] { enrollment },
      null, null, null
    );
    return this.readStudent(cursor);
  }

  @Override
  public ArrayList<Student> getAllStudents() {
    this._db = this._helper.getReadableDatabase();
    Cursor cursor = this._db.query(
      TableDefine.Students.TABLE_NAME,
      TableDefine.Students.RECORD,
      null, null, null, null, null
    );

    ArrayList<Student> students = new ArrayList<>();
    cursor.moveToFirst();

    while (!cursor.isAfterLast()) {
      Student _student = this.readStudent(cursor);
      students.add(_student);
      cursor.moveToNext();
    }

    cursor.close();
    return students;
  }

  @Override
  public Student readStudent(Cursor cursor) {
    Student student = new Student();
    student.set_id(cursor.getInt(0));
    student.set_enrollment(cursor.getString(1));
    student.set_name(cursor.getString(2));
    student.set_career(cursor.getString(3));
    student.set_img(cursor.getString(4));
    return student;
  }

  private void putStudentValues(ContentValues values, Student student) {
    values.put(TableDefine.Students.COLUMN_NAME_ENROLLMENT, student.get_enrollment());
    values.put(TableDefine.Students.COLUMN_NAME_NAME, student.get_name());
    values.put(TableDefine.Students.COLUMN_NAME_CAREER, student.get_career());
    values.put(TableDefine.Students.COLUMN_NAME_PHOTO, student.get_img());
  }
}
