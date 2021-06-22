package com.upsin.customadapterdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {

  private final ArrayList<String> _ListData;
  private View.OnClickListener _listener;

  public MyAdapter(ArrayList<String> ListData) {
    this._ListData = ListData;
  }

  @NonNull
  @NotNull
  @Override
  public MyAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, null, false);
    view.setOnClickListener(this); // Listens to click event
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull @NotNull MyAdapter.ViewHolder holder, int position) {
    holder.setTxtData(this._ListData.get(position));
  }

  @Override
  public int getItemCount() {
    return this._ListData.size();
  }

  public void setOnClickListener(View.OnClickListener listener) {
    this._listener = listener;
  }

  @Override
  public void onClick(View v) {
    if (this._listener != null) this._listener.onClick(v);
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    public TextView txtData;

    public ViewHolder(@NonNull @NotNull View itemView) {
      super(itemView);
      this.txtData = itemView.findViewById(R.id.txtName);
    }

    public void setTxtData(String str) {
      this.txtData.setText(str);
    }
  }
}
