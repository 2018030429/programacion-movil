package com.upsin.preexam;

public class Convert {

  private final double _grades;

  public Convert(double grades) {
    this._grades = grades;
  }

  public double toFahrenheit() {
    return ((9/5f) * this._grades) + 32;
  }

  public double toCelsius() {
    return (this._grades - 32) * (5/9f);
  }

}
