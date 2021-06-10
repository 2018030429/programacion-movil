package com.upsin.cotizacion;

import java.util.Random;

public class Cotizacion {

  private int folio;
  private String descripcion;
  private float valorAuto;
  private float porEnganche;
  private int plazos;

  public int generarFolio(){
    Random r = new Random();
    return Math.abs(r.nextInt()%1000);
  }

  public Cotizacion(){
    this.setFolio(this.generarFolio());
    this.setDescripcion("");
    this.setValorAuto(0.0f);
    this.setPorEnganche(0.0f);
    this.setPlazos(0);
  }

  public Cotizacion(int folio,String descripcion ,float valorAuto,float porEnganche,int plazos){
    this.setFolio(this.generarFolio());
    this.setDescripcion(descripcion);
    this.setValorAuto(valorAuto);
    this.setPorEnganche(porEnganche);
    this.setPlazos(plazos);
  }

  public int getFolio() {return folio;}
  public void setFolio(int folio) { this.folio = folio;}
  public String getDescripcion() {return descripcion;}
  public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
  public float getValorAuto() {return valorAuto; }
  public void setValorAuto(float valorAuto) {this.valorAuto = valorAuto;}
  public float getPorEnganche() { return porEnganche;}
  public void setPorEnganche(float porEnganche) { this.porEnganche = porEnganche; }
  public int getPlazos() {return plazos; }
  public void setPlazos(int plazos) { this.plazos = plazos;}
  public float calcularEnganche()
  {return this.valorAuto * (this.porEnganche/100); }
  public float calcularPagoMensual() {
    return ((this.valorAuto - this.calcularEnganche()) / this.plazos);
  }

}
