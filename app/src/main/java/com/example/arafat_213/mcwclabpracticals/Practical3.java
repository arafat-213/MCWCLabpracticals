package com.example.arafat_213.mcwclabpracticals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Practical3 extends AppCompatActivity {

    private EditText editText1, editText2, editText3;
    private double num1, num2, ans = 0;
    private double inputTemp, celsiusTemp, fahrenheaitTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical3);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
    }

    public void calculate(View view) {
        num1 = Double.parseDouble(editText1.getText().toString());
        num2 = Double.parseDouble(editText2.getText().toString());
        switch (view.getId()) {
            case R.id.btnAdd:
                ans = num1 + num2;
                break;
            case R.id.btnsub:
                ans = num1 - num2;
                break;
            case R.id.btnMul:
                ans = num1 * num2;
                break;
            case R.id.btnDiv:
                ans = num1 / num2;
                break;
        }
        Toast.makeText(Practical3.this, ans + "", Toast.LENGTH_SHORT).show();
    }

    public void convertTemperature(View view) {
        inputTemp = Double.parseDouble(editText3.getText().toString());
        switch (view.getId()) {
            case R.id.btnCel:
                celsiusTemp = (inputTemp - 32) / 1.8;
                Toast.makeText(Practical3.this, inputTemp + " F = " + celsiusTemp + " C", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnFaren:
                fahrenheaitTemp = inputTemp * 1.8 + 32;
                Toast.makeText(Practical3.this, inputTemp + " C = " + fahrenheaitTemp + " F", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}


