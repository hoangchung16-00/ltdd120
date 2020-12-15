package com.example.appcaronline1.booking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.appcaronline1.R;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class DirectionActivity extends AppCompatActivity {
    EditText startpoint, endpoint;
    Button btconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);
        startpoint = (EditText) findViewById(R.id.start_point);
        endpoint = (EditText) findViewById(R.id.end_point);
        btconfirm = (Button) findViewById(R.id.bt_confirm);

        btconfirm.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DirectionActivity.this, BookingDetailActivity.class);

                ArrayList<String> move = new ArrayList<String>();

                move.add(startpoint.getText().toString());
                move.add(endpoint.getText().toString());


                intent.putStringArrayListExtra("move",move);
                startActivity(intent);
            }
        });
    }
}