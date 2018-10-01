package com.example.arafat_213.mcwclabpracticals.Practical8;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arafat_213.mcwclabpracticals.R;

import java.util.List;

public class RemoveItemInfoActivity extends AppCompatActivity {
    TextView tvItemName, tvItemPrice, tvItemQuantity;
    Button btnRemoveItemInfo;
    Spinner spinnerItemList;
    Context mContext;

    DBHandler db;
    List<Item> itemList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_item_info);

        findViewById();

        itemList = db.getItemList();
        String[] itemArray = new String[itemList.size()];

        for (int i =0;i < itemList.size(); i++) {
            itemArray[i] = String.valueOf(itemList.get(i).getItem_id());
        }

        spinnerItemList.setAdapter(new ArrayAdapter<String>(RemoveItemInfoActivity.this, android.R.layout.simple_spinner_dropdown_item, itemArray));

        spinnerItemList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Item item = itemList.get(i);
                Log.d("Selected", "onItemSelected: " + i);
                tvItemName.setText(item.getItem_name());
                tvItemPrice.setText(String.valueOf(item.getItem_price()));
                tvItemQuantity.setText(String.valueOf(item.getItem_quantity()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });

        btnRemoveItemInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int itemId =  Integer.parseInt(spinnerItemList.getSelectedItem().toString());

                if (db.removeItemInfo(itemId)) {
                    Toast.makeText(mContext, "Item Details Removed from database.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(mContext, "Item Details Not Removed..Try Again", Toast.LENGTH_LONG).show();
                }
            }
        });



    }

    private void findViewById() {

        db = new DBHandler(RemoveItemInfoActivity.this);
        mContext = RemoveItemInfoActivity.this;
        tvItemName = (TextView) findViewById(R.id.tv_itemName);
        tvItemPrice = (TextView) findViewById(R.id.tv_itemPrice);
        tvItemQuantity = (TextView) findViewById(R.id.tv_itemQuantity);
        spinnerItemList = (Spinner) findViewById(R.id.spinner_itemIds);
        btnRemoveItemInfo = (Button) findViewById(R.id.btnRemoveItem);
    }
}
