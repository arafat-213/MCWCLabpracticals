package com.example.arafat_213.mcwclabpracticals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Practical2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical2);
    }

    public void helloWorld(View view) {
        Toast.makeText(Practical2.this, "Hello, Welcome to android lab", Toast.LENGTH_LONG).show();
    }
}
