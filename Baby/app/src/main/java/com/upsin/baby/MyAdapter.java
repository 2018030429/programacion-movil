package com.upsin.baby;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> implements Filterable, View.OnClickListener {

  private List<Item> _itemList;
  private List<Item> _itemListFull;
  private View.OnClickListener _listener;
  private Map<Integer, Integer> _mapColors = new HashMap<>();

  public class ItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView _image;
    private TextView _txtHeader;
    private TextView _txtDescription;
    private RelativeLayout relativeLayout;

    ItemViewHolder(View itemView) {
      super(itemView);
      this._image = itemView.findViewById(R.id.itemImage);
      this._txtHeader = itemView.findViewById(R.id.txtItemHeader);
      this._txtDescription = itemView.findViewById(R.id.txtItemDescription);
      this.relativeLayout = itemView.findViewById(R.id.container);
    }
  }

  MyAdapter(List<Item> itemList) {
    this._itemList = itemList;
    this._itemListFull = new ArrayList<>(itemList);
    this.fillMapColor();
  }

  @NonNull
  @Override
  public ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
    view.setOnClickListener(this);
    return new ItemViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
    Item currentItem = this._itemList.get(position);
    holder._image.setImageResource(currentItem.getImage());
    holder._txtHeader.setText(currentItem.getHeader());
    holder._txtDescription.setText(currentItem.getDescription());
    holder.relativeLayout.setBackgroundColor(this._mapColors.get(position));
  }

  @Override
  public void onClick(View v) {
    if (this._listener != null) this._listener.onClick(v);
  }

  public void setOnClickListener(View.OnClickListener listener) {
    this._listener = listener;
  }

  @Override
  public int getItemCount() {
    return this._itemList.size();
  }

  @Override
  public Filter getFilter() {
    return itemFilter;
  }

  private void fillMapColor() {
    this._mapColors.put(0, Color.parseColor("#FFB5E8"));
    this._mapColors.put(1, Color.parseColor("#B28DFF"));
    this._mapColors.put(2, Color.parseColor("#DCD3FF"));
    this._mapColors.put(3, Color.parseColor("#AFF8DB"));
    this._mapColors.put(4, Color.parseColor("#BFFCC6"));
    this._mapColors.put(5, Color.parseColor("#FFC9DE"));
    this._mapColors.put(6, Color.parseColor("#FF9CEE"));
    this._mapColors.put(7, Color.parseColor("#C5A3FF"));
    this._mapColors.put(8, Color.parseColor("#A79AFF"));
    this._mapColors.put(9, Color.parseColor("#C4FAF8"));
    this._mapColors.put(10, Color.parseColor("#DBFFD6"));
    this._mapColors.put(11, Color.parseColor("#FFABAB"));
    this._mapColors.put(12, Color.parseColor("#FFCCF9"));
    this._mapColors.put(13, Color.parseColor("#D5AAFF"));
    this._mapColors.put(14, Color.parseColor("#B5B9FF"));
    this._mapColors.put(15, Color.parseColor("#85E3FF"));
    this._mapColors.put(16, Color.parseColor("#F3FFE3"));
    this._mapColors.put(17, Color.parseColor("#FFBEBC"));
    this._mapColors.put(18, Color.parseColor("#FCC2FF"));
    this._mapColors.put(19, Color.parseColor("#ECD4FF"));
    this._mapColors.put(20, Color.parseColor("#97A2FF"));
    this._mapColors.put(21, Color.parseColor("#ACE7FF"));
    this._mapColors.put(22, Color.parseColor("#E7FFAC"));
    this._mapColors.put(23, Color.parseColor("#FFCBC1"));
    this._mapColors.put(24, Color.parseColor("#F6A6FF"));
    this._mapColors.put(25, Color.parseColor("#FBE4FF"));
  }

  private Filter itemFilter = new Filter() {
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
      List<Item> filteredList = new ArrayList<>();

      if (constraint == null || constraint.length() == 0) {
        filteredList.addAll(_itemListFull);
      } else {
        String filterPattern = constraint.toString().toLowerCase().trim();

        for (Item item : _itemListFull) {
          if (item.getHeader().toLowerCase().contains(filterPattern)) {
            filteredList.add(item);
          }
        }
      }

      FilterResults results = new FilterResults();
      results.values = filteredList;

      return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
      _itemList.clear();
      _itemList.addAll((List) results.values);
      notifyDataSetChanged();
    }
  };
}
