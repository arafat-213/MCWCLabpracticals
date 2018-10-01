package com.example.arafat_213.mcwclabpracticals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Shopping Demo";

    // Items table name
    private static final String TABLE_ITEM_DETAIL = "itemRecords";

    // Items Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_ITEM_NAME = "item_name";
    private static final String KEY_ITEM_PRICE = "item_price";
    private static final String KEY_ITEM_QUANTITY= "item_quantity";
    private static final String KEY_TOTAL_AMOUNT = "item_total_amount";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_ITEM_DETAIL_TABLE = "CREATE TABLE " + TABLE_ITEM_DETAIL + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_ITEM_NAME + " TEXT,"
                + KEY_ITEM_PRICE + " NUMBER,"
                + KEY_ITEM_QUANTITY + " NUMBER,"
                + KEY_TOTAL_AMOUNT + " NUMBER" + ")";

        db.execSQL(CREATE_ITEM_DETAIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM_DETAIL);

        // Create tables again
        onCreate(db);

    }


    /*
     * All CRUD Method are here
     * */

    public void addNewItemToDb(Item newItem){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ITEM_NAME, newItem.getItem_name());
        values.put(KEY_ITEM_PRICE, newItem.getItem_price());
        values.put(KEY_ITEM_QUANTITY, newItem.getItem_quantity());
        values.put(KEY_TOTAL_AMOUNT, newItem.getItem_total_amount());

        // Inserting Row
        db.insert(TABLE_ITEM_DETAIL, null, values);
        db.close(); // Closing database connection

    }



    /*
     * Method To Get Item List From the Database
     * */
    public List<Item> getItemList(){

        List<Item> itemList = new ArrayList<Item>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_DETAIL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                Item item = new Item();
                item.setItem_id(Integer.parseInt(cursor.getString(0)));
                item.setItem_name(cursor.getString(1));
                item.setItem_price(cursor.getInt(2));
                item.setItem_quantity(cursor.getInt(3));
                item.setItem_total_amount(cursor.getInt(4));


                // Adding contact to list
                itemList.add(item);

            } while (cursor.moveToNext());
        }

        // return contact list
        return itemList;
    }


    /*
     * Method to Update Item Information in the Database
     * */

    public boolean updateItemInfo(Item item){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ITEM_NAME, item.getItem_name());
        values.put(KEY_ITEM_PRICE, item.getItem_price());
        values.put(KEY_ITEM_QUANTITY, item.getItem_quantity());
        values.put(KEY_TOTAL_AMOUNT, item.getItem_price() * item.getItem_quantity());

        return db.update(TABLE_ITEM_DETAIL, values, KEY_ID + "="+item.getItem_id(), null) > 0;
    }

    public boolean removeItemInfo(int itemId){

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_ITEM_DETAIL, KEY_ID + "=" + itemId, null) > 0;

    }



}
