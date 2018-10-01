package com.example.arafat_213.mcwclabpracticals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    EditText edtName, edtPrice, edtQuantity;
    Button btnAddToDB;
    DBHandler db;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        db = new DBHandler(this);

        edtName = (EditText) findViewById(R.id.edtItemName);
        edtPrice = (EditText) findViewById(R.id.edtItemPrice);
        edtQuantity = (EditText) findViewById(R.id.edtItemQuantity);

        btnAddToDB = (Button) findViewById(R.id.btnAddItemToDB);

        btnAddToDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String itemName = edtName.getText().toString();
                int itemPrice = Integer.parseInt(edtPrice.getText().toString());
                int itemQuantity = Integer.parseInt(edtQuantity.getText().toString());
                int itemAmount = itemPrice * itemQuantity;

                db.addNewItemToDb(new Item(itemName, itemPrice, itemQuantity, itemAmount));
                Toast.makeText(AddItemActivity.this, "Item Added to the List", Toast.LENGTH_LONG).show();
            }
        });
    }
}
