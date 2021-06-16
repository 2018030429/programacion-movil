package com.upsin.baby;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

  private ListView listItems;
  private ArrayList<String> babyItemHeaders;
  private ArrayList<String> babyItemDescription;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.initializeComponents();

    listItems.setOnItemClickListener((parent, view, position, id) -> {
      Toast.makeText(
        parent.getContext(),
        ((Item) parent.getItemAtPosition(position)).getDescription(),
        Toast.LENGTH_SHORT
      ).show();
    });

  }

  private void initializeComponents() {
    ArrayList<Item> list = new ArrayList<>();
    ArrayList<Integer> imageList = new ArrayList<>();

    this.babyItemHeaders = new ArrayList<String>();
    this.babyItemDescription = new ArrayList<String>();

    this.babyItemHeaders.addAll(
      Arrays.asList(getResources().getStringArray(R.array.babyItemsHeader))
    );
    this.babyItemDescription.addAll(
      Arrays.asList(getResources().getStringArray(R.array.babyItemsDescription))
    );

    imageList = this.getArrayImages();

    for (Integer index=0; index < 25; index++) {
      list.add(
        new Item(
          imageList.get(index),
          babyItemHeaders.get(index),
          babyItemDescription.get(index)
        )
      );
    }

    listItems = findViewById(R.id.lstItem);
    ListAdapter adapter = new ListAdapter(
      this,
      R.layout.list_layout,
      R.id.lblHeader,
      list
    );

    listItems.setAdapter(adapter);

  }

  public ArrayList<Integer> getArrayImages() {
    ArrayList<Integer> List = new ArrayList<>();
    List.add(R.drawable.babyitem_1);
    List.add(R.drawable.babyitem_2);
    List.add(R.drawable.babyitem_3);
    List.add(R.drawable.babyitem_4);
    List.add(R.drawable.babyitem_5);
    List.add(R.drawable.babyitem_6);
    List.add(R.drawable.babyitem_7);
    List.add(R.drawable.babyitem_8);
    List.add(R.drawable.babyitem_9);
    List.add(R.drawable.babyitem_10);
    List.add(R.drawable.babyitem_11);
    List.add(R.drawable.babyitem_12);
    List.add(R.drawable.babyitem_13);
    List.add(R.drawable.babyitem_14);
    List.add(R.drawable.babyitem_15);
    List.add(R.drawable.babyitem_16);
    List.add(R.drawable.babyitem_17);
    List.add(R.drawable.babyitem_18);
    List.add(R.drawable.babyitem_19);
    List.add(R.drawable.babyitem_20);
    List.add(R.drawable.babyitem_21);
    List.add(R.drawable.babyitem_22);
    List.add(R.drawable.babyitem_23);
    List.add(R.drawable.babyitem_24);
    List.add(R.drawable.babyitem_25);
    return List;
  }

  private void setColorItem(ListView list) {

  }

}