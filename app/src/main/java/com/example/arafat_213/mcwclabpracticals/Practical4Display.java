package com.example.arafat_213.mcwclabpracticals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Practical4Display extends AppCompatActivity {

    private TextView tvName, tvAge, tvDOB, tvEmail, tvPhone, tvHobbies, tvGender, tvCountry, tvState, tvMarried;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical4_display);
        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvDOB = findViewById(R.id.tvDOB);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvHobbies = findViewById(R.id.tvHobbies);
        tvGender = findViewById(R.id.tvGender);
        tvCountry = findViewById(R.id.tvCountry);
        tvState = findViewById(R.id.tvState);
        tvMarried = findViewById(R.id.tvMarried);

        Intent intent = getIntent();
        tvName.setText("Name : " + intent.getStringExtra("Name"));
        tvAge.setText("Age : " + intent.getStringExtra("Age"));
        tvDOB.setText("Date of birth : " + intent.getStringExtra("DOB"));
        tvEmail.setText("Email : " + intent.getStringExtra("Email"));
        tvPhone.setText("Phone : " + intent.getStringExtra("Phone"));
        tvGender.setText("Gender : " + intent.getStringExtra("Gender"));
        tvHobbies.setText("Hobbies : " + intent.getStringExtra("Hobbies"));
        tvCountry.setText("Cuntry : " + intent.getStringExtra("Country"));
        tvState.setText("State : " + intent.getStringExtra("State"));
        tvMarried.setText("Married ?  : " + intent.getStringExtra("Married"));
    }
}

