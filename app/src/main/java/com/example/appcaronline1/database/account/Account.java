package com.example.appcaronline1.database.account;

public class Account {
    private String userName,passWord,name,phoneNumber,email;
    private int gioiTinh;
    public static Account AccountLogin;


    public Account(String userName, String passWord, String name, String phoneNumber, String email, int gioiTinh) {
        this.userName = userName;
        this.passWord = passWord;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gioiTinh = gioiTinh;
    }

    public Account() {
    }
    public Account(String passWord){
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
