package com.example.diaryapp;

import static com.example.diaryapp.DiaDbHelper.DB_DIARY_ENTRY_TABLE;
import static com.example.diaryapp.DiaDbHelper.DB_USER_TABLE;
import static com.example.diaryapp.DiaDbHelper.KEY_DATE;
import static com.example.diaryapp.DiaDbHelper.KEY_EMAIL;
import static com.example.diaryapp.DiaDbHelper.KEY_NAME;
import static com.example.diaryapp.DiaDbHelper.KEY_PASS;
import static com.example.diaryapp.DiaDbHelper.KEY_TEXT;
import static com.example.diaryapp.DiaDbHelper.KEY_TITLE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class DiaryDatabaseManager extends DiaDbManager {
    public DiaryDatabaseManager(Context context) {
        super(context);
    }

    void addUser(User u) {

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, u.getuName()); // get users name
        values.put(KEY_EMAIL, u.getuEmail()); // get users email
        values.put(KEY_PASS, u.getuPass()); // get users name

        // Inserting Row
        diaDB.insert(DB_USER_TABLE, null, values);

    }

    void addEntry(Entry e) {

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, e.geteTitle()); // get entry title
        values.put(KEY_TEXT, e.geteText()); // get entry description
        values.put(KEY_DATE, e.geteDate()); // get entry date

        // Inserting Row
        diaDB.insert(DB_DIARY_ENTRY_TABLE, null, values);

    }


    public Cursor getUser(String uEmail, String uPass){
        String query = "SELECT * FROM user WHERE uEmail = ? AND uPass = ? ";
        String[] selectionArgs = {uEmail, uPass };
        return diaDB.rawQuery(query, selectionArgs);
    }

}