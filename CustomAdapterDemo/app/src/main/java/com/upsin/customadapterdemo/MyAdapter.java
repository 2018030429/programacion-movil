package com.upsin.customadapterdemo;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {

  protected ArrayList<Student> _studentsList;
  private View.OnClickListener _listener;
  private Context _context;
  private final LayoutInflater _inflater;


  public MyAdapter(ArrayList<Student> studentList, Context context) {
    this._studentsList = studentList;
    this._context = context;
    this._inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
  }

  @NonNull
  @NotNull
  @Override
  public MyAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
    View view = this._inflater.inflate(R.layout.student_item, null);
    view.setOnClickListener(this); // Listens to click event
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull @NotNull MyAdapter.ViewHolder holder, int position) {
    Student student = this._studentsList.get(position);
    holder._txtEnrollment.setText(student.get_enrollment());
    holder._txtName.setText(student.get_name());
    holder._idImg.setImageURI(Uri.parse(student.get_img()));
    holder._txtCareer.setText(student.get_career());
  }

  @Override
  public int getItemCount() {
    return this._studentsList.size();
  }

  public void setOnClickListener(View.OnClickListener listener) {
    this._listener = listener;
  }

  @Override
  public void onClick(View v) {
    if (this._listener != null) this._listener.onClick(v);
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    private LayoutInflater _inflater;
    private final TextView _txtName;
    private final TextView _txtEnrollment;
    private final TextView _txtCareer;
    private final ImageView _idImg;

    public ViewHolder(@NonNull @NotNull View itemView) {
      super(itemView);
      this._txtName = itemView.findViewById(R.id.txtStudentName);
      this._txtCareer = itemView.findViewById(R.id.txtCareer);
      this._txtEnrollment = itemView.findViewById(R.id.txtEnrollment);
      this._idImg = itemView.findViewById(R.id.photo);
    }

  }
}
