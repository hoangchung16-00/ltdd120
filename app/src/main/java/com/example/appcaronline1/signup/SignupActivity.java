package com.example.appcaronline1.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.example.appcaronline1.R;
import com.example.appcaronline1.database.account.Account;
import com.example.appcaronline1.database.account.AreaCode;
import com.example.appcaronline1.database.account.DatabaseHelper;
import com.example.appcaronline1.editaccount.SpinnerAdapter;
import com.example.appcaronline1.login.LoginActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {
    private final AppCompatActivity activity = SignupActivity.this;
    private TextInputEditText textInputEditTextUserName;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextConfirm;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPhoneNumber;
    private Spinner spinner;

    private Button btConfirm,btCancel;
    private DatabaseHelper databaseHelper;
    private RadioGroup rgGioiTinh;
    private SpinnerAdapter adapter;
    private AreaCode areaCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);
        databaseHelper = new DatabaseHelper();

        initViews();
    }
    private void initViews() {
        textInputEditTextUserName = (TextInputEditText) findViewById(R.id.et_signup_username);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.et_signup_password);
        textInputEditTextName = (TextInputEditText) findViewById(R.id.et_signup_name);
        textInputEditTextConfirm = (TextInputEditText) findViewById(R.id.et_signup_password_confirm);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.et_signup_email);
        textInputEditTextPhoneNumber = (TextInputEditText) findViewById(R.id.et_signup_phonenumber);

        spinner = (Spinner) findViewById(R.id.spinner_signup);
        adapter = new SpinnerAdapter(this, DatabaseHelper.areaCodeArrayList);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent,
                                               View view, int position, long id)
                    {

                        // It returns the clicked item.
                        areaCode = (AreaCode)
                                parent.getItemAtPosition(position);

                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent)
                    {
                    }
                });
        rgGioiTinh = (RadioGroup) findViewById(R.id.rg_signup_gioitinh);
        btConfirm = (Button) findViewById(R.id.bt_signup_confirm);
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(databaseHelper.checkAccountName(textInputEditTextUserName.getText().toString().trim())){
                    Toast.makeText(SignupActivity.this,"Tài khoản đã tồn tại",Toast.LENGTH_SHORT).show();
                } else
                    if(textInputEditTextPassword.getText().toString().trim().equals(textInputEditTextConfirm.getText().toString().trim())) {
                    Account account = new Account();
                    account.setUserName(textInputEditTextUserName.getText().toString().trim());
                    account.setPassWord(textInputEditTextPassword.getText().toString().trim());
                    account.setName(textInputEditTextName.getText().toString());
                    account.setEmail(textInputEditTextEmail.getText().toString().trim());
                        String temp = textInputEditTextPhoneNumber.getText().toString().trim();
                        int phone = Integer.parseInt(temp);
                    account.setPhoneNumber(phone);
                    if(rgGioiTinh.getCheckedRadioButtonId()==R.id.rb_signup_nam){
                        account.setGioiTinh(1);
                    } else {
                        account.setGioiTinh(0);
                    }
                    account.setCountryCode(areaCode.getCode());
                    databaseHelper.insertdata(account);
                    DatabaseHelper.accountArrayList.add(account);
                    if(databaseHelper.checkAccount(account.getUserName(),account.getPassWord())){
                        Toast.makeText(SignupActivity.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                        intent.putExtra("login","Login");
                        startActivity(intent);
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

}