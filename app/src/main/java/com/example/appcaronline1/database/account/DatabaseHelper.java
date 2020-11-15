package com.example.appcaronline1.database.account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "database.db";
    // User table name
    private static final String TABLE_ACCOUNT = "account";
    // User Table Columns names
    private static final String COLUMN_USER_NAME = "username";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_PHONE_NUMBER = "phonenumber";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_GIOI_TINH = "gioitinh";
    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_ACCOUNT + "("
            + COLUMN_USER_NAME + " TEXT PRIMARY KEY," + COLUMN_PASSWORD + " TEXT,"
            + COLUMN_NAME + " TEXT," + COLUMN_GIOI_TINH + " INT,"
            + COLUMN_EMAIL + " TEXT," + COLUMN_PHONE_NUMBER + " TEXT" + ")";
    // drop table sql query
    private String DROP_ACCOUNT_TABLE = "DROP TABLE IF EXISTS " + TABLE_ACCOUNT;
    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop User Table if exist
        db.execSQL(DROP_ACCOUNT_TABLE);
        // Create tables again
        onCreate(db);
    }

    public void addAccount(Account account) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, account.getUserName());
        values.put(COLUMN_PASSWORD, account.getPassWord());
        values.put(COLUMN_NAME, account.getName());
        values.put(COLUMN_GIOI_TINH, account.getGioiTinh());
        values.put(COLUMN_EMAIL, account.getEmail());
        values.put(COLUMN_PHONE_NUMBER, account.getPhoneNumber());
        // Inserting Row
        db.insert(TABLE_ACCOUNT, null, values);
        db.close();
    }
    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<Account> getAllAccount() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_NAME,
                COLUMN_PASSWORD,
                COLUMN_NAME,
                COLUMN_GIOI_TINH,
                COLUMN_EMAIL,
                COLUMN_PHONE_NUMBER
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<Account> accountList = new ArrayList<Account>();
        SQLiteDatabase db = this.getReadableDatabase();
        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_ACCOUNT, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Account account = new Account();
                account.setUserName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                account.setPassWord(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
                account.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                account.setGioiTinh(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_GIOI_TINH))));
                account.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
                account.setPhoneNumber(cursor.getString(cursor.getColumnIndex(COLUMN_PHONE_NUMBER)));
                // Adding user record to list
                accountList.add(account);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return user list
        return accountList;
    }


    public void updateAccount(Account account) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, account.getUserName());
        values.put(COLUMN_PASSWORD,account.getPassWord());
        values.put(COLUMN_NAME,account.getName());
        values.put(COLUMN_GIOI_TINH,account.getGioiTinh());
        values.put(COLUMN_EMAIL,account.getEmail());
        values.put(COLUMN_PHONE_NUMBER,account.getPhoneNumber());
        // updating row
        db.update(TABLE_ACCOUNT, values, COLUMN_USER_NAME + " = ?",
                new String[]{String.valueOf(account.getUserName())});
        db.close();
    }

    public void deleteAccount(Account account) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_ACCOUNT, COLUMN_USER_NAME + " = ?",
                new String[]{String.valueOf(account.getUserName())});
        db.close();
    }


    public boolean checkAccount(String username,String password) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_NAME,
                COLUMN_PASSWORD
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_NAME + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username,password};
        Cursor cursor = db.query(TABLE_ACCOUNT, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }
    public boolean checkAccountName(String username) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_NAME
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_NAME + " = ?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(TABLE_ACCOUNT, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }




}
