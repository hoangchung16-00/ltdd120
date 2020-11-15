package com.example.appcaronline1.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.example.appcaronline1.R;
import com.example.appcaronline1.database.account.Account;
import com.example.appcaronline1.database.account.DatabaseHelper;
import com.example.appcaronline1.login.LoginActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {
    private final AppCompatActivity activity = SignupActivity.this;
    private NestedScrollView nestedScrollView;
    private TextInputLayout textInputLayoutUserName;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutConfirm;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPhoneNumber;
    private TextInputEditText textInputEditTextUserName;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextConfirm;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPhoneNumber;

    private Button btConfirm,btCancel;
    private DatabaseHelper databaseHelper;
    private RadioGroup rgGioiTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);
        initViews();
        databaseHelper = new DatabaseHelper(activity);


    }
    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        textInputLayoutUserName = (TextInputLayout) findViewById(R.id.textInputLayoutUserName_signup);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword_signup);
        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName_signup);
        textInputLayoutConfirm = (TextInputLayout) findViewById(R.id.textInputLayoutConfirm_signup);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail_signup);
        textInputLayoutPhoneNumber = (TextInputLayout) findViewById(R.id.textInputLayoutPhoneNumber_signup);

        textInputEditTextUserName = (TextInputEditText) findViewById(R.id.et_signup_username);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.et_signup_password);
        textInputEditTextName = (TextInputEditText) findViewById(R.id.et_signup_name);
        textInputEditTextConfirm = (TextInputEditText) findViewById(R.id.et_signup_password_confirm);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.et_signup_email);
        textInputEditTextPhoneNumber = (TextInputEditText) findViewById(R.id.et_signup_phonenumber);

        rgGioiTinh = (RadioGroup) findViewById(R.id.rg_signup_gioitinh);
        btConfirm = (Button) findViewById(R.id.bt_signup_confirm);
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verifyFromSQLite() ){
                    Toast.makeText(SignupActivity.this,"Sai",Toast.LENGTH_SHORT).show();
                } else
                    if(textInputEditTextPassword.getText().toString().trim().equals(textInputEditTextConfirm.getText().toString().trim())) {
                    Account account = new Account();
                    account.setUserName(textInputEditTextUserName.getText().toString().trim());
                    account.setPassWord(textInputEditTextPassword.getText().toString().trim());
                    account.setName(textInputEditTextName.getText().toString());
                    account.setEmail(textInputEditTextEmail.getText().toString().trim());
                    account.setPhoneNumber(textInputEditTextPhoneNumber.getText().toString().trim());
                    if(rgGioiTinh.getCheckedRadioButtonId()==R.id.rb_signup_nam){
                        account.setGioiTinh(1);
                    } else {
                        account.setGioiTinh(0);
                    }
                    databaseHelper.addAccount(account);
                    if(verifyFromSQLite()){
                        Toast.makeText(SignupActivity.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                        emptyInputEditText();
                    }
                } else {
                        Toast.makeText(SignupActivity.this,"Mật khẩu không khớp",Toast.LENGTH_SHORT).show();
                    }
            }
        });
        btCancel = (Button) findViewById(R.id.bt_signup_cancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                intent.putExtra("login","Login");
                startActivity(intent);
            }
        });
    }
    private boolean verifyFromSQLite() {
        if (databaseHelper.checkAccountName(textInputEditTextUserName.getText().toString().trim())) {
            return true;
        } else {
            return false;
        }
    }
    private void emptyInputEditText() {
        textInputEditTextName.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextUserName.setText(null);
        textInputEditTextConfirm.setText(null);
        textInputEditTextPhoneNumber.setText(null);

    }
}