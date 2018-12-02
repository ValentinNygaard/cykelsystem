package com.example.cykelsystem.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RepairCase {

    @Id
    private int repair_case_id;
    private Date start_date;
    private Date end_date;
    private int status;

    public RepairCase(int repair_case_id, Date start_date, Date end_date, int status) {
        this.repair_case_id = repair_case_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
