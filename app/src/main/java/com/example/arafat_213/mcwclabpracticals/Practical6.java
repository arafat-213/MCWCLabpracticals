package com.example.arafat_213.mcwclabpracticals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Practical6 extends AppCompatActivity {

    private TextView textView1, textView2, textView3, textView4;
    private TextView[] newsPapers = new TextView[4];
    private int[] textViewIDs = {R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4};
    private String[] newsPaperNames = {"Times of India", "Hindustan Times", "Dainik Bhaskar", "Sandesh"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical6);
       /* textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
*/
        for (int i = 0; i < textViewIDs.length; i++) {
            newsPapers[i] = findViewById(textViewIDs[i]);
            newsPapers[i].setText(newsPaperNames[i]);
        }
    }

    public void displayNewsPaper(View view) {
        Intent intent = new Intent(Practical6.this, Practical6Display.class);
        switch (view.getId()) {
            case R.id.textView1:
                intent.putExtra("name", newsPaperNames[0]);
                break;
            case R.id.textView2:
                intent.putExtra("name", newsPaperNames[1]);
                break;
            case R.id.textView3:
                intent.putExtra("name", newsPaperNames[2]);
                break;
            case R.id.textView4:
                intent.putExtra("name", newsPaperNames[3]);
                break;
        }
        startActivity(intent);
    }
}