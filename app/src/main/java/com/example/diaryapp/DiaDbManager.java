package com.example.diaryapp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class    DiaDbManager
{
    Context context;
    private DiaDbHelper diaDbHelper;
    protected SQLiteDatabase diaDB;

    public DiaDbManager(Context context) {
        this.context = context;
    }

    public DiaDbManager open() throws SQLException {
        this.diaDbHelper = new DiaDbHelper(this.context);
        this.diaDB = diaDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        diaDbHelper.close();
    }
}

