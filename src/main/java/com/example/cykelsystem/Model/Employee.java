package com.example.cykelsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity     // This defines that this is a class, in the Spring framework
public class Employee {

    @Id
    private int employee_id;
    private String name;
    private String phone_number;
    private String user_name;
    private String password;


    public Employee(int employee_id, String name, String phone_number, String user_name, String password) {
        this.employee_id = employee_id;
        this.name = name;
        this.phone_number = phone_number;
        this.user_name = user_name;
        this.password = password;

    }

    public Employee(){}

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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
