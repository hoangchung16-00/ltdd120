package com.example.appcaronline1.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.example.appcaronline1.R;
import com.example.appcaronline1.database.account.Account;
import com.example.appcaronline1.database.account.DatabaseHelper;
import com.example.appcaronline1.home.HomeAcitivity;
import com.example.appcaronline1.signup.SignupActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private final AppCompatActivity activity = LoginActivity.this;
    private NestedScrollView nestedScrollView;
    private TextInputLayout textInputLayoutUserName;
    private TextInputLayout textInputLayoutPassword;
    private EditText etUsername;
    private EditText etPassword;
    private Button btLogin,btSignup;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_login);
        databaseHelper = new DatabaseHelper();
        databaseHelper.fetchdata();


        initViews();


    }
    /**
     * This method is to initialize views
     */
    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        textInputLayoutUserName = (TextInputLayout) findViewById(R.id.textInputLayoutUserName);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        etUsername = (EditText) findViewById(R.id.et_login_username);
        etPassword = (EditText) findViewById(R.id.et_login_password);
        btLogin = (Button) findViewById(R.id.bt_login_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(databaseHelper.checkAccount(etUsername.getText().toString().trim(),etPassword.getText().toString().trim())){
                    databaseHelper.getLoginAccount(etUsername.getText().toString().trim());
                    Intent intent = new Intent(LoginActivity.this, HomeAcitivity.class);
                    intent.putExtra("login","Login");
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this,"Sai",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btSignup = (Button) findViewById(R.id.bt_login_signup);
        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                intent.putExtra("login","Login");
                startActivity(intent);
            }
        });
    }





    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */

}