package com.upsin.customadapterdemo;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

  private long _id;
  private String _career;
  private String _name;
  private String _img;
  private String _enrollment;

  public Student(String name, String img, String enrollment, String career) {
    this._id = 0;
    this._name = name;
    this._img = img;
    this._career = career;
    this._enrollment = enrollment;
  }

  public Student() {}

  public long get_id() {
    return _id;
  }

  public void set_id(long _id) {
    this._id = _id;
  }

  public String get_career() {
    return _career;
  }

  public void set_career(String _career) { this._career = _career;  }

  public String get_name() {
    return _name;
  }

  public void set_name(String _name) {
    this._name = _name;
  }

  public String get_img() {
    return _img;
  }

  public void set_img(String _img) {
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
      "GOMEZ CAMARENA JOSE RICARDO",
      Uri.parse("android.resource://com.upsin.customadapterdemo/"+R.drawable.a02).toString(),
      "2017030274",
      "Ing. En Tec. Info."
    ));
    studentsList.add(new Student(
      "PEÑA SOLIS DIEGO ARMANDO",
      Uri.parse("android.resource://com.upsin.customadapterdemo/"+R.drawable.a03).toString(),
      "2017030432",
      "Ing. En Tec. Info."
    ));
    studentsList.add(new Student(
      "GARCIA SILVA ADRIAN",
      Uri.parse("android.resource://com.upsin.customadapterdemo/"+R.drawable.a04).toString(),
      "2018030098",
      "Ing. En Tec. Info."
    ));
    studentsList.add(new Student(
      "GARCIA RODRIGUEZ JESUS EFRAIN",
      Uri.parse("android.resource://com.upsin.customadapterdemo/"+R.drawable.a05).toString(),
      "2018030099",
      "Ing. En Tec. Info."
    ));
    studentsList.add(new Student(
      "LIZARRAGA CAMACHO JESUS ARMANDO",
      Uri.parse("android.resource://com.upsin.customadapterdemo/"+R.drawable.a06).toString(),
      "2018030103",
      "Ing. En Tec. Info."
    ));
    studentsList.add(new Student(
      "GARCIA GOMEZ JUAN ANTONIO",
      Uri.parse("android.resource://com.upsin.customadapterdemo/"+R.drawable.a07).toString(),
      "2018030108",
      "Ing. En Tec. Info."
    ));
    studentsList.add(new Student(
      "LIZARRAGA LUNA JUAN FRANCISCO",
      Uri.parse("android.resource://com.upsin.customadapterdemo/"+R.drawable.a08).toString(),
      "2018030119",
      "Ing. En Tec. Info."
    ));
    studentsList.add(new Student(
      "OSUNA HIGUERA ALEJANDRO",
      Uri.parse("android.resource://com.upsin.customadapterdemo/"+R.drawable.a09).toString(),
      "2018030121",
      "Ing. En Tec. Info."
    ));
    studentsList.add(new Student(
      "MARIN GALINDO KIMBERLY VANESSA",
      Uri.parse("android.resource://com.upsin.customadapterdemo/"+R.drawable.a10).toString(),
      "2018030133",
      "Ing. En Tec. Info."
    ));
    studentsList.add(new Student(
      "PERAZA SAINZ ANGEL ADRIAN",
      Uri.parse("android.resource://com.upsin.customadapterdemo/"+R.drawable.a01).toString(),
      "2018030155",
      "Ing. En Tec. Info."
    ));

    return studentsList;
  }

}
