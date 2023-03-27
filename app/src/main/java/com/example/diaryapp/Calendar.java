package com.example.diaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

public class Calendar extends AppCompatActivity {

    ImageButton entryOverview;
    ImageButton writeEntry;
    ImageButton settings;
    ImageButton user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        entryOverview = (ImageButton) findViewById(R.id.entryOverview);
        writeEntry = (ImageButton) findViewById(R.id.writeEntry);
        settings = (ImageButton) findViewById(R.id.settings);
        user = (ImageButton) findViewById(R.id.user_button);

        // Event handlers for buttons
        entryOverview.setOnClickListener(view -> startActivity(new Intent(Calendar.this, Menu.class)));
        writeEntry.setOnClickListener(view -> startActivity(new Intent(Calendar.this, WriteEntry.class)));
        settings.setOnClickListener(view -> startActivity(new Intent(Calendar.this, Settings.class)));
        user.setOnClickListener(view -> Toast.makeText(Calendar.this, "Clicked user", Toast.LENGTH_LONG).show());
    }
}