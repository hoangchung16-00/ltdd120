package com.example.appcaronline1.database.account;

public class AreaCode {
    private String countryName, code;
    private int id;
    public AreaCode() {
    }

    public AreaCode(String countryName, String code, int id) {
        this.countryName = countryName;
        this.code = code;
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
