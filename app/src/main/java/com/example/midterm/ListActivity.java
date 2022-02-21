package com.example.midterm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListActivity extends android.app.ListActivity { //must extends ListActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); not needed because it is declared in the adapter

        String[] attraction =
                {
                        "Art Institute of Chicago", "Magnificent Mile", "Willis Tower",
                        "Navy Peer", "Water Tower"
                };

        setListAdapter(new ArrayAdapter<String>(this,
                R.layout.activity_list,
                R.id.list,
                attraction));

        Button bttnToGrid = (Button) findViewById(R.id.button33);

        bttnToGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListActivity.this, MainActivity.class));
            }
        });

        Button bttnToList = (Button) findViewById(R.id.button44);

        bttnToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListActivity.this, GridActivity.class));
            }
        });


    }

    protected void onListItemClick(ListView l, View v, int position, long id){
        switch(position){

            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.alfaisal.edu")));
                break;

            case 1:
                startActivity(new Intent(ListActivity.this, TextActivity.class));
                break;

        }

    }

}