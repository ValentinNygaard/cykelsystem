package com.example.cykelsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity     // This defines that this is a class, in the Spring framework
public class PartLineItem {

    @Id
    private int part_line_item_id;
    private String description;
    private int price;
    private int repair_case_id;

    public PartLineItem(int part_line_item_id, String description, int price, int repair_case_id) {
        this.part_line_item_id = part_line_item_id;
        this.description = description;
        this.price = price;
        this.repair_case_id = repair_case_id;
    }

    public PartLineItem(){}

    public int getPart_line_item_id() {
        return part_line_item_id;
    }

    public void setPart_line_item_id(int bicyclepart_line_item_id) {
        this.part_line_item_id = bicyclepart_line_item_id;
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
