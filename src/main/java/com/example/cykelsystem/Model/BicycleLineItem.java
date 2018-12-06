package com.example.cykelsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BicycleLineItem {

    @Id
    private int bicyclepart_line_item_id;
    private String description;
    private int price;
    private int repair_case_id;

    public BicycleLineItem(int bicyclepart_line_item_id, String description, int price, int repair_case_id) {
        this.bicyclepart_line_item_id = bicyclepart_line_item_id;
        this.description = description;
        this.price = price;
        this.repair_case_id = repair_case_id;
    }

    public BicycleLineItem(){}

    public int getBicyclepart_line_item_id() {
        return bicyclepart_line_item_id;
    }

    public void setBicyclepart_line_item_id(int bicyclepart_line_item_id) {
        this.bicyclepart_line_item_id = bicyclepart_line_item_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRepair_case_id() {
        return repair_case_id;
    }

    public void setRepair_case_id(int repair_case_id) {
        this.repair_case_id = repair_case_id;
    }
}
