package com.upsin.customadapterdemo.modelo;

import com.upsin.customadapterdemo.Student;

public interface Persistence {

  public void openDataBase();
  public void closeDataBase();
  public long insertStudent(Student student);
  public long updateStudent(Student student);
  public int deleteStudent(int id);

}
