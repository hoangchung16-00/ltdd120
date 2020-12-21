package com.example.appcaronline1.database.account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Path;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.appcaronline1.activityhistory.Move;
import com.example.appcaronline1.home.tabacitivity.activityhistory.Movement;
import com.example.appcaronline1.home.tabacitivity.activityhistory.OptionMoving;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseHelper {
    String username;
    private static final String apiurl1 = "http://10.0.2.2/webserver_android/json_fetch_booking_history.php";
    private static final String apiurl ="http://10.0.2.2/webserver_android/json_fetch.php";
    private static final String url ="http://10.0.2.2/webserver_android/db_insert.php";
    private static final String url2 ="http://10.0.2.2/webserver_android/db_update.php";
    private static final String url3 ="http://10.0.2.2/webserver_android/db_insert_booking.php";
    public static ArrayList<Account> accountArrayList ;
    public static ArrayList<Move> moveListData;
    public static List<AreaCode> areaCodeArrayList = Arrays.asList(new AreaCode("usaflag","+1",1),
            new AreaCode("vietnamflag","+84",2),
            new AreaCode("japanflag","+81",3));
    public String getApiurl1(String username){
        return "http://10.0.2.2/webserver_android/json_fetch_booking_history.php?t1="+username;
    }
    public DatabaseHelper(String username){
        this.username=username;
    }
    public DatabaseHelper(){
    }
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
                        int phonenumber = jo.getInt("phonenumber");
                        String countryCode = jo.getString("countrycode");
                        int gioitinh = jo.getInt("gioitinh");
                        accountArrayList.add(new Account(username,password,fullname,phonenumber,email,gioitinh,countryCode));
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
    public void fetchdata1(){
        class dbManager1 extends AsyncTask<String,Void,String> {
            protected void onPostExecute(String data){
                try {
                    moveListData = new ArrayList<Move>();
                    JSONArray ja = new JSONArray(data);
                    JSONObject jo = null;
                    for (int i=0;i<ja.length();i++){
                        jo=ja.getJSONObject(i);
                        String moveFrom = jo.getString("place_from");
                        String moveTo = jo.getString("place_to");
                        String timeStart = jo.getString("time_from");
                        String timeEnd = jo.getString("time_to");
                        String temp = jo.getString("option");
                        OptionMoving optionMoving = OptionMoving.valueOf(temp);
                        Double cash = jo.getDouble("cash");
                        moveListData.add(new Move(moveFrom,moveTo,timeStart,timeEnd,optionMoving,cash));
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
        dbManager1 obj1 = new dbManager1();
        obj1.execute(getApiurl1(username));
    }
    public List<Move> getMoveList(){
        return moveListData;
    }

    public void insertdata(Account signupAccount){

        String qryString = "?t1="+signupAccount.getUserName()+"&t2="+signupAccount.getPassWord()+"&t3="+signupAccount.getName()+"&t4="+signupAccount.getPhoneNumber()+"&t5="+signupAccount.getEmail()+"&t6="+signupAccount.getGioiTinh()+"&t7="+signupAccount.getCountryCode();
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

    public void updatedata(String username,String fullname,String email,int phonenumber,String code){
        String qryString = "?t1="+fullname+"&t2="+phonenumber+"&t3="+email+"&t4="+username+"&t5="+code;
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
        obj.execute(url2+qryString);
    }
    public static void updateLoginAccount(String fullname,String email,int phonenumber,String code){
        Account.AccountLogin.setName(fullname);
        Account.AccountLogin.setEmail(email);
        Account.AccountLogin.setPhoneNumber(phonenumber);
        Account.AccountLogin.setCountryCode(code);

    }
    public void createBooking(Movement movement,String username){
        String qryString = "?t1="+movement.getStart()+"&t2="+movement.getEnd()+"&t3="+movement.getMoveFrom()+"&t4="+movement.getMoveTo()+"&t5="+movement.getCash()+"&t6="+movement.getOptionMoving()+"&t7="+username;
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
        obj.execute(url3+qryString);
    }
}
