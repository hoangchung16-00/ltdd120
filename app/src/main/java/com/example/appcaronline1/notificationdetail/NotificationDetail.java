package com.example.appcaronline1.notificationdetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcaronline1.R;
import com.example.appcaronline1.editaccount.EditAccount;
import com.example.appcaronline1.home.HomeAcitivity;
import com.example.appcaronline1.standard.Standard;

public class NotificationDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_notification_detail);
        ImageView home = (ImageView) findViewById(R.id.backtoprofile);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotificationDetail.this, HomeAcitivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });
        LinearLayout orderCar = (LinearLayout) findViewById(R.id.order_grab);
        orderCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NotificationDetail.this, Standard.class);
                startActivity(myIntent);
            }
        });
    }
}