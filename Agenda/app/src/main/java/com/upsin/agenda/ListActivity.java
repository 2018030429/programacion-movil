package com.upsin.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

  public TableLayout tableList;
  public ArrayList<Contact> contacts;
  private Button _btnNew;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);

    this.initializeComponents();

    this._btnNew.setOnClickListener(v -> {
      setResult(Activity.RESULT_CANCELED);
      finish();
    });
    this.loadContacts();
  }

  private void initializeComponents() {
    this.tableList = findViewById(R.id.tableList);

    Bundle bundleObject = getIntent().getExtras();
    this.contacts = (ArrayList<Contact>) bundleObject.getSerializable("contacts");

    this._btnNew = findViewById(R.id.btnNew);
  }

  public void loadContacts() {
    for (int x=0; x<this.contacts.size(); x++) {
      Contact contact = new Contact(contacts.get(x));
      TableRow nRow = new TableRow(ListActivity.this);

      TextView nText = new TextView(ListActivity.this);
      nText.setText(contact.get_name());

      nText.setTextSize(TypedValue.COMPLEX_UNIT_PT, 6);
      nText.setTextColor((contact.is_favorite())? Color.BLUE : Color.BLACK);
      nRow.addView(nText);

      Button nButton = new Button(ListActivity.this);
      nButton.setText(R.string.action_show);
      nButton.setTextSize(TypedValue.COMPLEX_UNIT_PT, 6);
      nButton.setTextColor(Color.BLACK);

      nButton.setOnClickListener(v -> {
        Contact c = (Contact) v.getTag(R.string.contact_g);
        Intent intent = new Intent();
        Bundle objectBundle = new Bundle();

        objectBundle.putSerializable("contact", c);
        objectBundle.putInt("index", Integer.parseInt(v.getTag(R.string.contact_g_index).toString()));
        intent.putExtras(objectBundle);
        setResult(RESULT_OK, intent);
        finish();
      });

      nButton.setTag(R.string.contact_g, contact);
      nButton.setTag(R.string.contact_g_index, x);
      nRow.addView(nButton);
      this.tableList.addView(nRow);
    }
  }

}