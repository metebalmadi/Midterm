package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridActivity extends AppCompatActivity {


    Integer[] Animals = {R.drawable.cat4, R.drawable.cub2, R.drawable.cute6,
            R.drawable.jir1, R.drawable.deer8, R.drawable.lioness5};

    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);






        GridView grid = (GridView) findViewById(R.id.gridview);
        final ImageView pic = (ImageView) findViewById(R.id.imageView);
        grid.setAdapter(new ImageAdapter(this));


        Button bttnToMain = (Button) findViewById(R.id.button2);

        bttnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GridActivity.this, MainActivity.class));
            }
        });


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                Toast.makeText(getBaseContext(),
                        "Selected Species " + (position +1), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Animals[position]);
            }
        });

    }

    public class ImageAdapter extends BaseAdapter {

        private Context context;

        public ImageAdapter(Context c)
        {
            context = c;
        }

        @Override
        public int getCount() {
            return Animals.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            pic = new ImageView(context);
            pic.setImageResource(Animals[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new ViewGroup.LayoutParams(300,300));
            return pic;
        }
    }
}