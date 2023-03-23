package com.example.diaryapp;

public class User {
    private int uId;
    private String uName;
    private String uEmail;
    private String uPass;

    public int getuId() {
        return uId;
    }

    //Constructors
    public User(int uId, String uName, String uEmail, String uPass, String uGender) {
        this.uId = uId;
        this.uName = uName;
        this.uEmail = uEmail;
        this.uPass = uPass;
    }

    public User() {
    }


    //Getters and setters
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
