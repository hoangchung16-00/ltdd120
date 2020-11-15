package com.example.appcaronline1.editaccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcaronline1.R;
import com.example.appcaronline1.database.account.Account;
import com.example.appcaronline1.home.HomeAcitivity;
import com.example.appcaronline1.login.LoginActivity;

public class EditAccount extends AppCompatActivity {

    private TextView tvUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_edit_account);
        tvUserName = (TextView) findViewById(R.id.tv_edit_account_username);
        tvUserName.setText(Account.AccountLogin.getUserName());



        LinearLayout logout =(LinearLayout) findViewById(R.id.li_edit_account_11111);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditAccount.this, LoginActivity.class);
                intent.putExtra("login","Login");
                startActivity(intent);
            }
        });
        LinearLayout home = (LinearLayout) findViewById(R.id.li_edit_account_11111);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditAccount.this, HomeAcitivity.class);
                intent.putExtra("login","Login");
                startActivity(intent);

            }
        });
    }
}