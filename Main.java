package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize ImageButton after setContentView
        ImageButton profile = findViewById(R.id.profilimgbutton);
        ImageButton gvrn = findViewById(R.id.govnbttn);
        ImageButton helpline= findViewById(R.id.helplinebttn);
        ImageButton reminder = findViewById(R.id.reminderbttn);
        ImageButton buy = findViewById(R.id.buybttn);
        ImageButton crpsugg = findViewById(R.id.cropsuggestionButton);

        // Set click listener
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ProfileActivity when button is clicked
                Intent intent = new Intent(MainActivity.this, profileactivity.class);
                startActivity(intent);
            }
        });
        //bur bttn
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ProfileActivity when button is clicked
                Intent intent = new Intent(MainActivity.this, buyactivity.class);
                startActivity(intent);
            }
        });

        //cropsuggestion
        crpsugg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ProfileActivity when button is clicked
                Intent intent = new Intent(MainActivity.this, cropSuggestionActivity.class);
                startActivity(intent);
            }
        });
        //govnschemes
        gvrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ProfileActivity when button is clicked
                Intent intent = new Intent(MainActivity.this, governmentSchemesActivity.class);
                startActivity(intent);
            }
        });

        //helpline
        helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ProfileActivity when button is clicked
                Intent intent = new Intent(MainActivity.this, helplineactivity.class);
                startActivity(intent);
            }
        });
        //reminder
        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ProfileActivity when button is clicked
                Intent intent = new Intent(MainActivity.this, reminderActivity.class);
                startActivity(intent);
            }
        });

    }
}
