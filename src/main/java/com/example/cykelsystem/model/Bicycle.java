package com.example.cykelsystem.model;

public class Bicycle {

    private int bicycle_id;
    private String description;

    public Bicycle(int bicycle_id, String description) {
        this.bicycle_id = bicycle_id;
        this.description = description;
    }

    public Bicycle(){
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
