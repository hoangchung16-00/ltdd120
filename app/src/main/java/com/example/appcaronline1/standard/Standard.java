package com.example.appcaronline1.standard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcaronline1.R;
import com.example.appcaronline1.home.HomeAcitivity;
import com.example.appcaronline1.map.MapsActivity;

public class Standard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_standard);
        //Di chuyen ve trang chu
        LinearLayout home =(LinearLayout) findViewById(R.id.li_standard_111);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Standard.this, HomeAcitivity.class);
                intent.putExtra("android","android is great");
                startActivity(intent);
            }
        });
        //Di chuyen toi map
        Button map =(Button) findViewById(R.id.bt_standard_agree);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Standard.this, MapsActivity.class);
                intent.putExtra("android","android is great");
                startActivity(intent);
            }
        });
    }
}