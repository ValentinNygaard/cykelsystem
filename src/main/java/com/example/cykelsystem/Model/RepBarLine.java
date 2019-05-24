// Made by all
package com.example.cykelsystem.Model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity     // This defines that this is a class, in the Spring framework
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
    private String customer_name;
    private String employee_name;
    private int end_time;


    public RepBarLine(int repair_case_id, String phone_number, int repair_number, int time, double price, String status_title, String end_date, String customer_name, String employee_name, int end_time) {
        this.repair_case_id = repair_case_id;
        this.phone_number = phone_number;
        this.repair_number = repair_number;
        this.time = time;
        this.price = price;
        this.status_title = status_title;
        this.end_date = end_date;
        this.customer_name = customer_name;
        this.employee_name = employee_name;
        this.end_time = end_time;
    }

    public RepBarLine(){}

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

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


    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
}
