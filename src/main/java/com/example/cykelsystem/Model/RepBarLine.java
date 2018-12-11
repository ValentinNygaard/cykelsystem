package com.example.cykelsystem.Model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RepBarLine {

    @Id
    private int repair_case_id;
    private String phone_number;
    private int repair_number;
    private int time;
    private double price;
    private String status_title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String end_date;

    public RepBarLine(int repair_case_id, String phone_number, int repair_number, int time, double price, String status_title, String end_date) {
        this.repair_case_id = repair_case_id;
        this.phone_number = phone_number;
        this.repair_number = repair_number;
        this.time = time;
        this.price = price;
        this.status_title = status_title;
        this.end_date = end_date;
    }

    public RepBarLine(){}

    public int getRepair_case_id() {
        return repair_case_id;
    }

    public void setRepair_case_id(int repair_id) {
        this.repair_case_id = repair_id;
    }

    public String getStatus_title() {
        return status_title;
    }

    public void setStatus_title(String status_title) {
        this.status_title = status_title;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getRepair_number() {
        return repair_number;
    }

    public void setRepair_number(int repair_number) {
        this.repair_number = repair_number;
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

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
