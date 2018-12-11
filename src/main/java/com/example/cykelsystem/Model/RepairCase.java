package com.example.cykelsystem.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RepairCase {

    @Id
    private int repair_case_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String start_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String end_date;
    private int status_id;
    private int bicycle_id;
    private int customer_employee_id;
    private int repair_employee_id;
    private int repair_number;
    private String comment;

    public RepairCase(int repair_case_id, String start_date, String end_date, int status_id, int bicycle_id,
                      int customer_employee_id, int repair_employee_id, int repair_number, String comment) {
        this.repair_case_id = repair_case_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status_id = status_id;
        this.bicycle_id = bicycle_id;
        this.customer_employee_id = customer_employee_id;
        this.repair_employee_id = repair_employee_id;
        this.repair_number = repair_number;
        this.comment = comment;
    }

    public RepairCase(){}

    public int getCustomer_employee_id() {
        return customer_employee_id;
    }

    public void setCustomer_employee_id(int customer_employee_id) {
        this.customer_employee_id = customer_employee_id;
    }

    public int getRepair_employee_id() {
        return repair_employee_id;
    }

    public void setRepair_employee_id(int repair_employee_id) {
        this.repair_employee_id = repair_employee_id;
}

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRepair_case_id() {
        return repair_case_id;
    }

    public void setRepair_case_id(int repair_case_id) {
        this.repair_case_id = repair_case_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getBicycle_id() {
        return bicycle_id;
    }

    public void setBicycle_id(int bicycle_id) {
        this.bicycle_id = bicycle_id;
    }

    public int getRepair_number() {
        return repair_number;
    }

    public void setRepair_number(int repair_number) {
        this.repair_number = repair_number;
    }

    public String toString(){
        return "start date"+ " "+getStart_date()+" "+"end date"+" "+getEnd_date()+" "+"status"+" "+ getStatus_id()+" "+"bicycle id"+" "+ getBicycle_id()
                +" "+"repair nr"+" "+ getRepair_number()+" "+"customer employee id"+" "+ getCustomer_employee_id()+" "+"repair employee id"+" "+ getRepair_employee_id()+" "+"comment"+" "+ getComment();
    }
}
