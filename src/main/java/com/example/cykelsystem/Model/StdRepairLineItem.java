// Made by all
package com.example.cykelsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity     // This defines that this is a class, in the Spring framework
public class StdRepairLineItem {

    @Id
    private int std_repair_line_item_id;
    private String description;
    private int time;
    private double price;

    public StdRepairLineItem(int std_repair_line_item_id, String description, int time, double price) {
        this.std_repair_line_item_id = std_repair_line_item_id;
        this.description = description;
        this.time = time;
        this.price = price;
    }

    public StdRepairLineItem(){}

    public int getStd_repair_line_item_id() {
        return std_repair_line_item_id;
    }

    public void setStd_repair_line_item_id(int repair_line_item_id) {
        this.std_repair_line_item_id = repair_line_item_id;
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
