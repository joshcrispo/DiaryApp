package com.example.diaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.Date;

public class WriteEntry extends AppCompatActivity {

    TextView date;
    Date d = new Date();
    CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());
    String day = LocalDate.now().getDayOfWeek().name();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_entry);

        date = (TextView) this.findViewById(R.id.entryDate);
        date.setText(day + " - " +s);
    }
}