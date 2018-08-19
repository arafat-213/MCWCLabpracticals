package com.example.arafat_213.mcwclabpracticals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;

public class Practical6Display extends AppCompatActivity {

    private WebView webView1;
    private HashMap<String, String> newsPapersMap = new HashMap<>();
    private String[] newsPaperNames = {"Times of India", "Hindustan Times", "Dainik Bhaskar", "Sandesh"};
    private String[] newsPaperLinks = {"http://timesofindia.indiatimes.com", "http://m.hindustantimes.com/",
            "http://bhaskar.com/", "http://sandesh.com/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical6_display);

        for (int i = 0; i < newsPaperNames.length; i++) {
            newsPapersMap.put(newsPaperNames[i], newsPaperLinks[i]);
        }
        webView1 = findViewById(R.id.webView1);
        WebSettings webSettings = webView1.getSettings();
        webSettings.setAllowContentAccess(true);
        webSettings.setJavaScriptEnabled(true);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        webView1.setWebViewClient(new WebViewClient());
        webView1.loadUrl(newsPapersMap.get(name));
    }
}
