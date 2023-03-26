package com.example.diaryapp;

public class Entry {
    private int eId;
    private String eTitle;
    private String eText;
    private String eDate;

    public Entry(String eTitle, String eText, String eDate) {
        this.eTitle = eTitle;
        this.eText = eText;
        this.eDate = eDate;
    }

    public Entry() {
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteTitle() {
        return eTitle;
    }

    public void seteTitle(String eTitle) {
        this.eTitle = eTitle;
    }

    public String geteText() {
        return eText;
    }

    public void seteText(String eText) {
        this.eText = eText;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }
}
