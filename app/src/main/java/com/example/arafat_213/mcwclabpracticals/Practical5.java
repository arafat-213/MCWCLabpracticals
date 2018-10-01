package com.example.arafat_213.mcwclabpracticals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class Practical5 extends AppCompatActivity {

    private ImageSwitcher imageSwitcher;
    private Gallery gallery;

    private int [] imgIds = {
      R.drawable.eevee,
      R.drawable.squirtle,
      R.drawable.bulbasaur,
      R.drawable.pikachu,
      R.drawable.jigglypuff,
      R.drawable.charmander
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical5);
        imageSwitcher = findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return  imageView;
            }
        });
        gallery = findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this, imgIds));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageSwitcher.setImageResource(imgIds[i]);
            }
        });
    }


}

