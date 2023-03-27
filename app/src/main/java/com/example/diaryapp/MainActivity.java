package com.example.diaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    EditText et1;
    EditText et2;
    TextView date;
    Date d = new Date();
    CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());
    String day = LocalDate.now().getDayOfWeek().name();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.login_email);
        et2 = (EditText) findViewById(R.id.login_pass);
        date = (TextView) this.findViewById(R.id.date);
        date.setText(day + " - " +s);

        //Opening Database
        DiaryDatabaseManager dbManager = new DiaryDatabaseManager(getApplicationContext());
        dbManager.open();

        //Adding user dummy user
        //dbManager.addUser(new User("Joshua", "joshua@tudublin.ie", "mypass123"));

        //Log in
        loginButton = (Button) findViewById(R.id.buttonlog);
        loginButton.setOnClickListener(view -> {
            String email = et1.getEditableText().toString();
            String pass = et2.getEditableText().toString();
            Cursor cursor = dbManager.getUser(email, pass);


            if (cursor.moveToFirst()) {
                int uID = cursor.getInt(0);
                dbManager.close();
                // switching screens requires an intent
                Intent intent = new Intent(getApplicationContext(), Menu.class);

                // add the data to send to the next screen onto the intent as "extras"
                intent.putExtra("userID", uID);
                startActivity(intent);
            }
            else{
                Toast.makeText(MainActivity.this, "Wrong login details", Toast.LENGTH_LONG).show();
            }
        });
    }
}