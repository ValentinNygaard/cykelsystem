package com.example.cykelsystem.Model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RepairCase {

    @Id
    private int repair_case_id;
    private Date start_date;
    private Date end_date;
    private int status_id;
    private int bicycle_id;
    private int employee_id;
    private int repair_number;

    public RepairCase(int repair_case_id, Date start_date, Date end_date,
                      int status_id, int bicycle_id, int employee_id, int repair_number){
        this.repair_case_id = repair_case_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status_id = status_id;
        this.bicycle_id = bicycle_id;
        this.employee_id = employee_id;
        this.repair_number = repair_number;
    }

    public RepairCase(){}

    public int getRepair_case_id() {
        return repair_case_id;
    }

    public void setRepair_case_id(int repair_case_id) {
        this.repair_case_id = repair_case_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
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

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getRepair_number() {
        return repair_number;
    }

    public void setRepair_number(int repair_number) {
        this.repair_number = repair_number;
    }
}
