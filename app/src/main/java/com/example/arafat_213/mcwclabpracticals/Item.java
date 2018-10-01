package com.example.arafat_213.mcwclabpracticals;

public class Item {

    private int item_id;
    private String item_name;
    private int item_price;
    private int item_quantity;
    private int item_total_amount;

    public Item() {
    }

    public Item(int item_id, String item_name, int item_price, int item_quantity, int item_total_amount) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_quantity = item_quantity;
        this.item_total_amount = item_total_amount;
    }

    public Item(String item_name, int item_price, int item_quantity, int item_total_amount) {
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_quantity = item_quantity;
        this.item_total_amount = item_total_amount;
    }


    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    public int getItem_total_amount() {
        return item_total_amount;
    }

    public void setItem_total_amount(int item_total_amount) {
        this.item_total_amount = item_total_amount;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }



    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }


}

