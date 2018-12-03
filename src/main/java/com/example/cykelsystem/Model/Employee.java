package com.example.cykelsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private int emplyee_id;
    private String name;
    private String password;
    private String phone_number;

    public Employee(int emplyee_id, String name, String password, String phone_number) {
        this.emplyee_id = emplyee_id;
        this.name = name;
        this.password = password;
        this.phone_number = phone_number;
    }

    public Employee(){}

    public int getEmplyee_id() {
        return emplyee_id;
    }

    public void setEmplyee_id(int emplyee_id) {
        this.emplyee_id = emplyee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
