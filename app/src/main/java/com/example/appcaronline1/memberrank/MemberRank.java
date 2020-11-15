package com.example.appcaronline1.memberrank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcaronline1.R;
import com.example.appcaronline1.home.HomeAcitivity;

public class MemberRank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_rank);
        Button bt_return = (Button) findViewById(R.id.btreturn);
        bt_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemberRank.this, HomeAcitivity.class);
                intent.putExtra("meber","home");
                startActivity(intent);
            }
        });
    }
}