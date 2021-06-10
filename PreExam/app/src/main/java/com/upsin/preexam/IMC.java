package com.upsin.preexam;

public class IMC {

  private final double _height;
  private final double _weight;

  public IMC(double height, double weight) {
    this._height = height;
    this._weight = weight;
  }

  public double calculateIMC() {
    return (this._weight / (this._height * this._height));
  }

}
