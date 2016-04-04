package com.example.ozgur.sqlite_2048;


import android.content.ContentValues;

/**
 * Created by Ozgur on 27/03/2016.
 */
public class User {
    private String name;
    private int age;
    private String adress;
    private int zipcode;
    private String city;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
