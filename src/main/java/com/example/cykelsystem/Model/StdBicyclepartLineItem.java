package com.example.cykelsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StdBicyclepartLineItem {

    @Id
    private int std_bicycle_line_item_id;
    private String description;
    private int price;

    public StdBicyclepartLineItem(int std_bicycle_line_item_id, String description, int price) {
        this.std_bicycle_line_item_id = std_bicycle_line_item_id;
        this.description = description;
        this.price = price;
    }

    public  StdBicyclepartLineItem(){}

    public int getStd_bicycle_line_item_id() {
        return std_bicycle_line_item_id;
    }

    public void setStd_bicycle_line_item_id(int std_bicycle_line_item_id) {
        this.std_bicycle_line_item_id = std_bicycle_line_item_id;
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
}
