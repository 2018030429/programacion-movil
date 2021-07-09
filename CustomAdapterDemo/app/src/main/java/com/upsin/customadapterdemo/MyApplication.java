package com.upsin.customadapterdemo;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class MyApplication extends Application {

  private static ArrayList<Student> _studentList;
  private MyAdapter _adapter;

  public static ArrayList<Student> getStudents() {
    return _studentList;
  }

  public MyAdapter getAdapter() {
    return this._adapter;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    this._studentList = Student.fillStudents();
    this._adapter = new MyAdapter(this._studentList, this);
    Log.d("", "onCreate: ArrayList size: " + this._studentList.size());
  }
}
