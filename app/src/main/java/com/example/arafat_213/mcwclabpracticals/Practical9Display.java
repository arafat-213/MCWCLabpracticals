package com.example.arafat_213.mcwclabpracticals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Practical9Display extends AppCompatActivity {

    TextView usernameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical9_display);
        usernameTV = findViewById(R.id.usernameTV);
        Intent intent = getIntent();
        usernameTV.setText("Welcome " + intent.getStringExtra("username"));
    }
}
