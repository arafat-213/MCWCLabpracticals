package com.example.arafat_213.mcwclabpracticals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical8 extends AppCompatActivity {
    Button btnAddItem, btnUpdateItem, btnDeleteItem, btnGetItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAddItem =  findViewById(R.id.btnAddItem);

        btnDeleteItem =findViewById(R.id.btnDeleteItem);

        btnUpdateItem = findViewById(R.id.btnUpdateItem);

        btnGetItemList =findViewById(R.id.btnListItems);

    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnAddItem:
                startActivity(new Intent(Practical8.this, AddItemActivity.class));
                break;


            case R.id.btnListItems:
                startActivity(new Intent(Practical8.this, ItemListActivity.class));
                break;

            case R.id.btnUpdateItem:
                startActivity(new Intent(Practical8.this, UpdateItemInfoActivity.class));
                break;

            case R.id.btnDeleteItem:
                startActivity(new Intent(Practical8.this, RemoveItemInfoActivity.class));
                break;
        }
    }
}
