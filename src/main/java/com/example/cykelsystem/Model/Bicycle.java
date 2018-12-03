package com.example.cykelsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bicycle {

    @Id
    private int bicycle_id;
    private String description;
    private int customer_id;

    public Bicycle(int bicycle_id, String description, int customer_id) {
        this.bicycle_id = bicycle_id;
        this.description = description;
        this.customer_id = customer_id;
    }

    public Bicycle(){
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getBicycle_id() {
        return bicycle_id;
    }

    public void setBicycle_id(int bicycle_id) {
        this.bicycle_id = bicycle_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
