package com.example.arafat_213.mcwclabpracticals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Practical9 extends AppCompatActivity {

    EditText nameEditText, passEditText;
    private String userName = "Admin";
    private String password = "admin";
    private int attemptCounter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical9);
        nameEditText = findViewById(R.id.nameEditText);
        passEditText = findViewById(R.id.passEditText);
    }

    public void login(View view) {
        if (userName.equals(nameEditText.getText().toString()) && password.equals(passEditText.getText().toString())) {
            Intent intent = new Intent(Practical9.this, Practical9Display.class);
            intent.putExtra("username", nameEditText.getText().toString());
            attemptCounter = 5;
            if (intent != null)
                startActivity(intent);
        } else {
            --attemptCounter;
            if (attemptCounter < 0) {
                Toast.makeText(getApplicationContext(), "Too many attempts, try again after some time", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Username or password Incorrect " + attemptCounter + " Attempt left", Toast.LENGTH_LONG).show();
            }
        }
    }
}
