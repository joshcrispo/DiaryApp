package com.example.diaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    ImageButton calendar;
    ImageButton entryOverview;
    ImageButton writeEntry;
    ImageButton settings;
    ImageButton user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Bundle data         = getIntent().getExtras();
        int userID        = data.getInt("userID");

        calendar = (ImageButton) findViewById(R.id.calendar);
        entryOverview = (ImageButton) findViewById(R.id.entryOverview);
        writeEntry = (ImageButton) findViewById(R.id.writeEntry);
        settings = (ImageButton) findViewById(R.id.settings);
        user = (ImageButton) findViewById(R.id.user_button);

        // Event handlers for buttons
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Calendar.class);

                // add the data to send to the next screen onto the intent as "extras"
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });

        entryOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Menu.class);

                // add the data to send to the next screen onto the intent as "extras"
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });

        writeEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WriteEntry.class);

                // add the data to send to the next screen onto the intent as "extras"
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });

        user.setOnClickListener(view -> Toast.makeText(Settings.this, "Clicked user", Toast.LENGTH_LONG).show());
    }
}