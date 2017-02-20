package com.example.luca.imexal;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Luca on 15/02/2017.
 */

public class BusinessCard{

    String name, email, phoneNumber,address;

        public BusinessCard(String name,String email, String phoneNumber,String address){
                this.name = name;
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.address = address;}

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
