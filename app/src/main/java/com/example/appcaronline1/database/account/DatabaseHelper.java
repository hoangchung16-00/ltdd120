package com.example.appcaronline1.database.account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private static final String apiurl ="http://10.0.2.2/webserver_android/json_fetch.php";
    private static final String url ="http://10.0.2.2/webserver_android/db_insert.php";
    public static ArrayList<Account> accountArrayList ;

    public void fetchdata(){
        class dbManager extends AsyncTask<String,Void,String> {
            protected void onPostExecute(String data){
                try {
                    accountArrayList = new ArrayList<Account>();
                    JSONArray ja = new JSONArray(data);
                    JSONObject jo = null;
                    for (int i=0;i<ja.length();i++){
                        jo=ja.getJSONObject(i);
                        String username = jo.getString("username");
                        String password = jo.getString("password");
                        String fullname = jo.getString("fullname");
                        String email = jo.getString("email");
                        String phonenumber = jo.getString("phonenumber");
                        int gioitinh = jo.getInt("gioitinh");
                        accountArrayList.add(new Account(username,password,fullname,phonenumber,email,gioitinh));
                    }

                } catch (Exception ex){

                }
            }
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection conn =(HttpURLConnection) url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer data = new StringBuffer();
                    String line;
                    while ((line=br.readLine())!=null){
                        data.append(line+"\n");
                    }
                    br.close();
                    return data.toString();
                } catch (Exception e){
                    return e.getMessage();
                }

            }
        }
        dbManager obj = new dbManager();
        obj.execute(apiurl);
    }
    public void insertdata(Account signupAccount){
        String qryString = "?t1="+signupAccount.getUserName()+"&t2="+signupAccount.getPassWord()+"&t3="+signupAccount.getName()+"&t4="+signupAccount.getPhoneNumber()+"&t5="+signupAccount.getEmail()+"&t6="+signupAccount.getGioiTinh();
        class dbclass extends AsyncTask<String,Void,String>{
            @Override
            protected String doInBackground(String... param) {
                try {
                    URL url = new URL(param[0]);
                    HttpURLConnection conn =(HttpURLConnection) url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    return br.readLine();
                } catch (Exception e){
                    return e.getMessage();
                }
            }
        }
        dbclass obj = new dbclass();
        obj.execute(url+qryString);
    }
    public boolean checkAccountName(String username){
        for(int i =0;i<accountArrayList.size();i++){
            if(username.equals(accountArrayList.get(i).getUserName())){
                return true;
            }
        }
        return false;
    }
    public boolean checkAccount(String username,String password){
        for(int i=0;i<accountArrayList.size();i++){
            if(username.equals(accountArrayList.get(i).getUserName())&&password.equals(accountArrayList.get(i).getPassWord())){
                return true;
            }
        }
        return false;
    }
    public void getLoginAccount(String username){
        for(int i=0;i<accountArrayList.size();i++){
            if(username.equals(accountArrayList.get(i).getUserName())){
                Account.AccountLogin = accountArrayList.get(i);
            }
        }
    }

}
