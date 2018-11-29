package com.example.cykelsystem.model;

public class RepairLineItem {

    private int repair_line_item_id;
    private String description;
    private int time;
    private double price;

    public RepairLineItem(int repair_line_item_id, String description, int time, double price) {
        this.repair_line_item_id = repair_line_item_id;
        this.description = description;
        this.time = time;
        this.price = price;
    }

    public RepairLineItem(){}

    public int getRepair_line_item_id() {
        return repair_line_item_id;
    }

    public void setRepair_line_item_id(int repair_line_item_id) {
        this.repair_line_item_id = repair_line_item_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
