package com.example.user.recylerviewstickyadapterdemocar24;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.recylerviewstickyadapterdemocar24.sticky.DividerDecoration;
import com.example.user.recylerviewstickyadapterdemocar24.sticky.StickyHeaderDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView  recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerId);
        recyclerView=setDivider(recyclerView);
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            list.add("Cars Number "+i);
        }

        CarsAdapter adapter=new CarsAdapter(this,list);
        StickyHeaderDecoration  decor = new StickyHeaderDecoration(adapter);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(decor, 1);

    }

    public RecyclerView setDivider(RecyclerView recyclerView)
    {
        final DividerDecoration divider = new DividerDecoration.Builder(this)
                .setHeight(R.dimen.default_divider_height)
                .setPadding(R.dimen.default_divider_padding)
                .setColorResource(R.color.default_header_color)
                .build();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(divider);

        return recyclerView;
    }

}
