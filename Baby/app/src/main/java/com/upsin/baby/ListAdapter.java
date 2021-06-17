package com.upsin.baby;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Item> {

  private final int groupId;
  private Activity context;
  private ArrayList<Item> list;
  private ArrayList<Item> initialData;
  private final LayoutInflater inflater;

  public ListAdapter(Activity _context, int _groupId, int _id, ArrayList<Item> _list) {
    super(_context, _id, _list);
    this.list = _list;
    this.inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.groupId = _groupId;
    this.setInitialData(this.list);
  }

  public View getView(int position, View convertView, ViewGroup parent) {
    View view = inflater.inflate(groupId, parent, false);

    ImageView image = view.findViewById(R.id.imgItem);
    image.setImageResource(list.get(position).getImage());

    TextView lblHeader = view.findViewById(R.id.lblHeader);
    lblHeader.setText(list.get(position).getHeader());

    TextView lblDescription = view.findViewById(R.id.lblDescription);
    lblDescription.setText(list.get(position).getDescription());

    switch (position) {
      case 0: view.setBackgroundColor(Color.parseColor("#FFB5E8")); break;
      case 1: view.setBackgroundColor(Color.parseColor("#B28DFF"));break;
      case 2: view.setBackgroundColor(Color.parseColor("#DCD3FF"));break;
      case 3: view.setBackgroundColor(Color.parseColor("#AFF8DB"));break;
      case 4: view.setBackgroundColor(Color.parseColor("#BFFCC6"));break;
      case 5: view.setBackgroundColor(Color.parseColor("#FFC9DE"));break;
      case 6: view.setBackgroundColor(Color.parseColor("#FF9CEE"));break;
      case 7: view.setBackgroundColor(Color.parseColor("#C5A3FF"));break;
      case 8: view.setBackgroundColor(Color.parseColor("#A79AFF"));break;
      case 9: view.setBackgroundColor(Color.parseColor("#C4FAF8"));break;
      case 10: view.setBackgroundColor(Color.parseColor("#DBFFD6"));break;
      case 11: view.setBackgroundColor(Color.parseColor("#FFABAB"));break;
      case 12: view.setBackgroundColor(Color.parseColor("#FFCCF9"));break;
      case 13: view.setBackgroundColor(Color.parseColor("#D5AAFF"));break;
      case 14: view.setBackgroundColor(Color.parseColor("#B5B9FF"));break;
      case 15: view.setBackgroundColor(Color.parseColor("#85E3FF"));break;
      case 16: view.setBackgroundColor(Color.parseColor("#F3FFE3"));break;
      case 17: view.setBackgroundColor(Color.parseColor("#FFBEBC"));break;
      case 18: view.setBackgroundColor(Color.parseColor("#FCC2FF"));break;
      case 19: view.setBackgroundColor(Color.parseColor("#ECD4FF"));break;
      case 20: view.setBackgroundColor(Color.parseColor("#97A2FF"));break;
      case 21: view.setBackgroundColor(Color.parseColor("#ACE7FF"));break;
      case 22: view.setBackgroundColor(Color.parseColor("#E7FFAC"));break;
      case 23: view.setBackgroundColor(Color.parseColor("#FFCBC1"));break;
      case 24: view.setBackgroundColor(Color.parseColor("#F6A6FF"));break;
      case 25: view.setBackgroundColor(Color.parseColor("#FBE4FF"));break;
    }

    return view;
  }

  private void setInitialData(ArrayList<Item> _list) {
    this.initialData = new ArrayList<>();
    this.initialData.addAll(_list);
  }

  public void filter(String search) {
    this.list.clear();

    if (search.isEmpty()) {
      this.list.addAll(this.initialData);
    }

    for (Item item : this.initialData) {
      if (item.getHeader().contains(search)) {
        this.list.add(item);
      }
    }
  }

}
