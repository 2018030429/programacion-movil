package com.upsin.customadapterdemo.modelo;

import android.database.Cursor;

import com.upsin.customadapterdemo.Student;

import java.util.ArrayList;

public interface Projection {

  public Student getStudent(String enrollment);
  public ArrayList<Student> getAllStudents();
  public Student readStudent(Cursor cursor);

}
