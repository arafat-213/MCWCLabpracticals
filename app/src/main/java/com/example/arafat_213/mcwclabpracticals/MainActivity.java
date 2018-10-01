package com.example.arafat_213.mcwclabpracticals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.arafat_213.mcwclabpracticals.Practical8.Practical8;

public class MainActivity extends AppCompatActivity {

    private Button practical8;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToPractical(View view) {
        switch (view.getId()) {
            case R.id.practical2:
                intent = new Intent(MainActivity.this, Practical2.class);
                if (intent != null)
                    startActivity(intent);
                break;
            case R.id.practical3:
                intent = new Intent(MainActivity.this, Practical3.class);
                if (intent != null)
                    startActivity(intent);
                break;
            case R.id.practical4:
                intent = new Intent(MainActivity.this, Practical4.class);
                if (intent != null)
                    startActivity(intent);
                break;
            case R.id.practical5:
                intent = new Intent(MainActivity.this, Practical5.class);
                if (intent != null)
                    startActivity(intent);
                break;
            case R.id.practical6:
                intent = new Intent(MainActivity.this, Practical6.class);
                if (intent != null)
                    startActivity(intent);
                break;
            case R.id.practical9:
                intent = new Intent(MainActivity.this, Practical9.class);
                if (intent != null)
                    startActivity(intent);
                break;
            default:
                Toast.makeText(MainActivity.this, "Practical is not added yet", Toast.LENGTH_LONG).show();
                break;
        }
    }
}