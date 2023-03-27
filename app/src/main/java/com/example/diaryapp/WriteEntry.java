package com.example.diaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
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
    EditText title;
    EditText yourDayText;
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
        String theDate = day + " - " +s;
        date.setText(theDate);

        back = (ImageButton) findViewById(R.id.go_back);
        user = (ImageButton) findViewById(R.id.user_button);
        photo = (ImageButton) findViewById(R.id.photo);
        audio = (ImageButton) findViewById(R.id.audio);
        mood = (ImageButton) findViewById(R.id.mood);
        save = (ImageButton) findViewById(R.id.save);
        title = (EditText) findViewById(R.id.titleEdit);
        yourDayText = (EditText) findViewById(R.id.yourDayText);


        // Event handlers for buttons
        back.setOnClickListener(view -> startActivity(new Intent(WriteEntry.this, Menu.class)));
        user.setOnClickListener(view -> Toast.makeText(WriteEntry.this, "Clicked user", Toast.LENGTH_LONG).show());
        photo.setOnClickListener(view -> Toast.makeText(WriteEntry.this, "Clicked photo", Toast.LENGTH_LONG).show());
        audio.setOnClickListener(view -> Toast.makeText(WriteEntry.this, "Clicked audio", Toast.LENGTH_LONG).show());
        mood.setOnClickListener(view -> Toast.makeText(WriteEntry.this, "Clicked mood", Toast.LENGTH_LONG).show());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entryTitle = title.getEditableText().toString();
                String description = yourDayText.getEditableText().toString();

                //Opening Database
                DiaryDatabaseManager dbManager = new DiaryDatabaseManager(getApplicationContext());
                dbManager.open();
                dbManager.addEntry(new Entry(entryTitle, description, theDate));

                Toast.makeText(WriteEntry.this, "Saved", Toast.LENGTH_LONG).show();
                dbManager.close();
            }
        });

    }
}