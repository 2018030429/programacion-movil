package com.upsin.spinnerpersonalizado;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<ItemData> {

  int groupId;
  Activity Context;
  ArrayList<ItemData> list;
  LayoutInflater inflater;

  public SpinnerAdapter(Activity Context, int groupId, int id, ArrayList<ItemData> list) {
    super(Context, id, list);
    this.list = list;
    inflater = (LayoutInflater) Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.groupId = groupId;
  }

  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = inflater.inflate(groupId, parent, false);
    ImageView image = itemView.findViewById(R.id.imgCategory);
    image.setImageResource(list.get(position).getImageId());

    TextView txtCategory = itemView.findViewById(R.id.lblCategory);
    txtCategory.setText(list.get(position).getCategory());

    TextView txtDescription = itemView.findViewById(R.id.lblDescription);
    txtDescription.setText(list.get(position).getDescription());

    return itemView;
  }

  public View getDropDownView(int position, View convertView, ViewGroup parent) {
    return getView(position, convertView, parent);
  }

}
