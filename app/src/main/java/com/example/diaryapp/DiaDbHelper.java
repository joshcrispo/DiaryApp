package com.example.diaryapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DiaDbHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "diary_app";


    // Diary App Tables
    protected static final String DB_USER_TABLE = "user";
    protected static final String DB_DIARY_ENTRY_TABLE = "diaryEntry";

    // User columns
    protected static final String KEY_USER_ID = "uId";
    protected static final String KEY_NAME = "uName";
    protected static final String KEY_EMAIL = "uEmail";
    protected static final String KEY_PASS = "uPass";

    // Diary Entry columns
    protected static final String KEY_ENTRY_ID = "eId";
    protected static final String KEY_TITLE = "eTitle";
    protected static final String KEY_TEXT = "eText";
    protected static final String KEY_DATE = "eDate";

    //Create table queries
    private static final String DB_CREATE_USER_TABLE = "CREATE TABLE " + DB_USER_TABLE + " (" +
            KEY_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_NAME + " TEXT NOT NULL, " +
            KEY_EMAIL + " TEXT NOT NULL UNIQUE, " +
            KEY_PASS + " TEXT NOT NULL);";

    private static final String DB_CREATE_DIARY_ENTRY_TABLE = "CREATE TABLE " + DB_DIARY_ENTRY_TABLE + " (" +
            KEY_ENTRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_TITLE + " TEXT NOT NULL, " +
            KEY_TEXT + " TEXT NOT NULL, " +
            KEY_DATE + " TEXT NOT NULL);";


    public DiaDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE_USER_TABLE);
        db.execSQL(DB_CREATE_DIARY_ENTRY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
