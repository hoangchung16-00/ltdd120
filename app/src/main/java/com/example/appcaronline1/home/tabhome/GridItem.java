package com.example.appcaronline1.home.tabhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.appcaronline1.R;

public class GridItem extends AppCompatActivity {
    TextView textView,content,date;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);
        textView =(TextView) findViewById(R.id.title) ;
        content =(TextView) findViewById(R.id.content) ;
        date =(TextView) findViewById(R.id.date) ;
        image =(ImageView) findViewById(R.id.image);
        Intent intent = getIntent();
        String stringTitle = intent.getStringExtra("title");
        String stringContent = intent.getStringExtra("content");
        String stringDate = intent.getStringExtra("date");
        int IdImage = intent.getIntExtra("image",0);

        textView.setText(stringTitle);
        image.setImageResource(IdImage);
        content.setText(stringContent);
        date.setText(stringDate);
    }
}