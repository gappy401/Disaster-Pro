package com.example.disasterpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ArrayList<IndiaItem> arr;
    public static RecyclerView rc;
    ArrayList<String> locations, date, time;
    CustomAdapter ca;
    ArrayList<String> res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        res = new ArrayList<>();
        rc = (RecyclerView) findViewById(R.id.rv);
        rc.setLayoutManager(new LinearLayoutManager(this));
        arr = new ArrayList<>();
        IndiaItem r1 = new IndiaItem("North India", "", R.drawable.north);
        arr.add(r1);
        IndiaItem  r2 = new IndiaItem("East India", "", R.drawable.east1);
        arr.add(r2);
        IndiaItem  r3 = new IndiaItem("West India", "", R.drawable.west1);
        arr.add(r3);
        IndiaItem  r4 = new IndiaItem("South India", "", R.drawable.south1);
        arr.add(r4);


        ca = new CustomAdapter(arr);
        rc.setAdapter(ca);
    }
}
