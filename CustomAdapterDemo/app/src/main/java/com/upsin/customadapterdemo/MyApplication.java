package com.upsin.customadapterdemo;

import android.app.Application;
import android.util.Log;

import com.upsin.customadapterdemo.modelo.StudentsDB;

import java.util.ArrayList;

public class MyApplication extends Application {

  private static ArrayList<Student> _studentList;
  private MyAdapter _adapter;
  private StudentsDB _studentsDB;

  public static ArrayList<Student> getStudents() {
    return _studentList;
  }

  public MyAdapter getAdapter() {
    return this._adapter;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    this._studentsDB = new StudentsDB(getApplicationContext());
    _studentList = this._studentsDB.getAllStudents();
    this._adapter = new MyAdapter(_studentList, this);

  }
}
