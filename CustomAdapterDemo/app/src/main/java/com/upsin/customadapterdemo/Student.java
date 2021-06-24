package com.upsin.customadapterdemo;

import java.util.ArrayList;

public class Student {

  private static final String _career = "Ing. En Tec. Info.";
  private String _name;
  private int _img;
  private String _enrollment;

  public Student(String name, int img, String enrollment) {
    this._name = name;
    this._img = img;
    this._enrollment = enrollment;
  }

  public static String get_career() {
    return _career;
  }

  public String get_name() {
    return _name;
  }

  public void set_name(String _name) {
    this._name = _name;
  }

  public int get_img() {
    return _img;
  }

  public void set_img(int _img) {
    this._img = _img;
  }

  public String get_enrollment() {
    return _enrollment;
  }

  public void set_enrollment(String _enrollment) {
    this._enrollment = _enrollment;
  }

  public static ArrayList<Student> fillStudents() {
    ArrayList<Student> studentsList = new ArrayList<>();

    studentsList.add(new Student(
      "GOMEZ CAMARENA JOSE RICARDO", R.drawable.a02, "2017030274")
    );
    studentsList.add(new Student(
      "PEÑA SOLIS DIEGO ARMANDO", R.drawable.a03, "2017030432")
    );
    studentsList.add(new Student(
      "GARCIA SILVA ADRIAN", R.drawable.a04, "2018030098")
    );
    studentsList.add(new Student(
      "GARCIA RODRIGUEZ JESUS EFRAIN", R.drawable.a05, "2018030099")
    );
    studentsList.add(new Student(
      "LIZARRAGA CAMACHO JESUS ARMANDO", R.drawable.a06, "2018030103")
    );
    studentsList.add(new Student(
      "GARCIA GOMEZ JUAN ANTONIO", R.drawable.a07, "2018030108")
    );
    studentsList.add(new Student(
      "LIZARRAGA LUNA JUAN FRANCISCO", R.drawable.a08, "2018030119")
    );
    studentsList.add(new Student(
      "OSUNA HIGUERA ALEJANDRO", R.drawable.a09, "2018030121")
    );
    studentsList.add(new Student(
      "MARIN GALINDO KIMBERLY VANESSA", R.drawable.a10, "2018030133")
    );
    studentsList.add(new Student(
      "PERAZA SAINZ ANGEL ADRIAN", R.drawable.a01, "2018030155")
    );

    return studentsList;
  }

}
