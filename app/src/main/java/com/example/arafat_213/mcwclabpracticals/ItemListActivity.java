package com.example.arafat_213.mcwclabpracticals;

import android.app.ListActivity;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemListActivity extends ListActivity {

    ListView listView;
    DBHandler db;
    List<Item> itemList;
    ArrayList<HashMap<String, String>> itemListHash;
    HashMap<String, String> item;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        listView = getListView();
        db = new DBHandler(this);

        itemListHash = new ArrayList<HashMap<String, String>>();

        itemList  = db.getItemList();

        /*
         * this will create a heading entry in the item list
         * */
        item = new HashMap<String, String>();
        item.put("item_id", "ID");
        item.put("item_name", "NAME");
        item.put("item_price", "PRICE");
        item.put("item_quantity", "QUANTITY");
        item.put("item_total_amount", "AMOUNT");

        itemListHash.add(item);

        /*
         * this will create item list from the database
         * */
        for (int i = 0; i < itemList.size(); i++) {
            item = new HashMap<String, String>();
            item.put("item_id", String.valueOf(itemList.get(i).getItem_id()));
            item.put("item_name", itemList.get(i).getItem_name());
            item.put("item_price", String.valueOf(itemList.get(i).getItem_price()));
            item.put("item_quantity", String.valueOf(itemList.get(i).getItem_quantity()));
            item.put("item_total_amount", String.valueOf(itemList.get(i).getItem_total_amount()));

            itemListHash.add(item);
        }

        /*
         * this will add item to the adapter to bind it to the list view
         * */
        ListAdapter adapter = new SimpleAdapter(ItemListActivity.this, itemListHash,R.layout.item_list,
                new String[] { "item_id", "item_name", "item_price", "item_quantity", "item_total_amount" },
                new int[] {R.id.tv_item_id, R.id.tv_item_name, R.id.tv_item_price, R.id.tv_item_quantity, R.id.tv_item_amount});

        //bind the adapter to the listview
        setListAdapter(adapter);
    }
}
