package com.example.diaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.Date;

public class WriteEntry extends AppCompatActivity {

    ImageButton back;
    ImageButton user;
    ImageButton photo;
    ImageButton audio;
    ImageButton mood;
    ImageButton save;


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

        back = (ImageButton) findViewById(R.id.go_back);
        user = (ImageButton) findViewById(R.id.user_button);
        photo = (ImageButton) findViewById(R.id.photo);
        audio = (ImageButton) findViewById(R.id.audio);
        mood = (ImageButton) findViewById(R.id.mood);
        save = (ImageButton) findViewById(R.id.save);

        // Event handlers for buttons
        back.setOnClickListener(view -> startActivity(new Intent(WriteEntry.this, Menu.class)));
        user.setOnClickListener(view -> Toast.makeText(WriteEntry.this, "Clicked user", Toast.LENGTH_LONG).show());
        photo.setOnClickListener(view -> Toast.makeText(WriteEntry.this, "Clicked photo", Toast.LENGTH_LONG).show());
        audio.setOnClickListener(view -> Toast.makeText(WriteEntry.this, "Clicked audio", Toast.LENGTH_LONG).show());
        mood.setOnClickListener(view -> Toast.makeText(WriteEntry.this, "Clicked mood", Toast.LENGTH_LONG).show());
        save.setOnClickListener(view -> Toast.makeText(WriteEntry.this, "Clicked save", Toast.LENGTH_LONG).show());

    }
}