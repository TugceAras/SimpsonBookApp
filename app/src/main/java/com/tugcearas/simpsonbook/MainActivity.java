package com.tugcearas.simpsonbook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

// OOP FEATURES AND SINGLE ARRAYLIST USED. IT IS LIKE THE LANDMARKBOOK APPLICATION.

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        // Images can be given direct integers instead of using bitmaps.
        Simpson homer = new Simpson("Homer Simpson","Nuclear",R.drawable.homersimpson);
        Simpson lisa = new Simpson("Lisa Simpson","Student",R.drawable.lisasimpson);
        Simpson bart = new Simpson("Bart Simpson","Student",R.drawable.bartsimpson);


        // to pass it to listview;
        ArrayList<Simpson> simpsonList = new ArrayList();
        simpsonList.add(homer);
        simpsonList.add(lisa);
        simpsonList.add(bart);


        CustomAdapter customAdapter = new CustomAdapter(simpsonList,MainActivity.this);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {

            Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
            intent.putExtra("selectedSimpson",simpsonList.get(position));
            startActivity(intent);


        });

    }
}