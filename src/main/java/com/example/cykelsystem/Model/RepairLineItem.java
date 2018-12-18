// Made by all
package com.example.cykelsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity     // This defines that this is a class, in the Spring framework
public class RepairLineItem {

    @Id
    private int repair_line_item_id;
    private String description;
    private int time;
    private double price;
    private int repair_case_id;

    public RepairLineItem(int repair_line_item_id, String description, int time, double price, int repair_case_id) {
        this.repair_line_item_id = repair_line_item_id;
        this.description = description;
        this.time = time;
        this.price = price;
        this.repair_case_id = repair_case_id;
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

    public int getRepair_case_id() { return repair_case_id; }

    public void setRepair_case_id(int repair_case_id) { this.repair_case_id = repair_case_id; }
}
