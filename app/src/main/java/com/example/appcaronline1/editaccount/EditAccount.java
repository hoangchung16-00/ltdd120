package com.example.appcaronline1.editaccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcaronline1.R;
import com.example.appcaronline1.database.account.Account;
import com.example.appcaronline1.database.account.AreaCode;
import com.example.appcaronline1.database.account.DatabaseHelper;
import com.example.appcaronline1.home.HomeAcitivity;
import com.example.appcaronline1.login.LoginActivity;

public class EditAccount extends AppCompatActivity {
    private Spinner spinner;
    private TextView tvUserName,tveditname,tvphone,tvemail;
    private SpinnerAdapter adapter;
    private AreaCode areaCode;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_edit_account);
        databaseHelper = new DatabaseHelper();
        tvUserName = (TextView) findViewById(R.id.tv_edit_account_username);
        tvUserName.setText(Account.AccountLogin.getName());
        tveditname = (TextView) findViewById(R.id.tv_name);
        tveditname.setText(Account.AccountLogin.getName());
        tvphone = (TextView) findViewById(R.id.tv_phoneNumber);
        int temp = Account.AccountLogin.getPhoneNumber();
        String phone = Integer.toString(temp);
        tvphone.setText(phone);
        tvemail = (TextView) findViewById(R.id.tv_email);
        tvemail.setText(Account.AccountLogin.getEmail());

        spinner = (Spinner) findViewById(R.id.spinner_view);
        tvUserName.setText(Account.AccountLogin.getUserName());
        Spinner spinner = findViewById(R.id.spinner_view);

        // we pass our item list and context to our Adapter.
        adapter = new SpinnerAdapter(this, DatabaseHelper.areaCodeArrayList);
        spinner.setAdapter(adapter);

        for(int i=0;i<DatabaseHelper.areaCodeArrayList.size();i++){
            if(Account.AccountLogin.getCountryCode().equals(DatabaseHelper.areaCodeArrayList.get(i).getCode())){
                areaCode = DatabaseHelper.areaCodeArrayList.get(i);
            }
        }
        spinner.setSelection(adapter.getPosition(areaCode));
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


        LinearLayout edit = (LinearLayout) findViewById(R.id.li_edit_account_1112);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = tvphone.getText().toString().trim();
                int phone = Integer.parseInt(temp);
                DatabaseHelper.updateLoginAccount(tveditname.getText().toString().trim(),tvemail.getText().toString().trim(),phone,areaCode.getCode());
                databaseHelper.updatedata(Account.AccountLogin.getUserName(),tveditname.getText().toString().trim(),tvemail.getText().toString().trim(),phone,areaCode.getCode());
                finish();
                startActivity(getIntent());
            }
        });
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


        LinearLayout logout =(LinearLayout) findViewById(R.id.li_edit_account_124);
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
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });
    }
}