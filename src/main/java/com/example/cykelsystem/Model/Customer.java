// Made by all
package com.example.cykelsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity     // This defines that this is a class, in the Spring framework
public class Customer {

    @Id
    private int customer_id;
    private String phone_number;
    private String name;

    public Customer(int customer_id, String phone_number, String name) {
        this.customer_id = customer_id;
        this.phone_number = phone_number;
        this.name = name;
    }

    public Customer(){}

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
