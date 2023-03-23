package com.example.diaryapp;

public class User {
    private int uId;
    private String uName;
    private String uEmail;
    private String uPass;

    //Constructors
    public User(String uName, String uEmail, String uPass) {
        this.uName = uName;
        this.uEmail = uEmail;
        this.uPass = uPass;
    }

    public User() {
    }


    //Getters and setters

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }
}
