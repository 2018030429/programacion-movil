package com.upsin.agenda;

import java.io.Serializable;

public class Contact implements Serializable {

  private long _id;
  private String _name;
  private String _firstPhone;
  private String _secondPhone;
  private String _address;
  private String _notes;
  private boolean _favorite;

  public Contact () {
    this._id = 0;
    this._name = "";
    this._firstPhone = "";
    this._secondPhone = "";
    this._address = "";
    this._notes = "";
    this._favorite = false;
  }

  public Contact (Contact contact) {
    this._id = contact._id;
    this._name = contact._name;
    this._firstPhone = contact._firstPhone;
    this._secondPhone = contact._secondPhone;
    this._address = contact._address;
    this._notes = contact._notes;
    this._favorite = contact._favorite;
  }

  public long get_id() {
    return _id;
  }

  public void set_id(long _id) {
    this._id = _id;
  }

  public String get_name() {
    return _name;
  }

  public void set_name(String _name) {
    this._name = _name;
  }

  public String get_firstPhone() {
    return _firstPhone;
  }

  public void set_firstPhone(String _firstPhone) {
    this._firstPhone = _firstPhone;
  }

  public String get_secondPhone() {
    return _secondPhone;
  }

  public void set_secondPhone(String _secondPhone) {
    this._secondPhone = _secondPhone;
  }

  public String get_address() {
    return _address;
  }

  public void set_address(String _address) {
    this._address = _address;
  }

  public String get_notes() {
    return _notes;
  }

  public void set_notes(String _notes) {
    this._notes = _notes;
  }

  public boolean is_favorite() {
    return _favorite;
  }

  public void set_favorite(boolean _favorite) {
    this._favorite = _favorite;
  }
}
