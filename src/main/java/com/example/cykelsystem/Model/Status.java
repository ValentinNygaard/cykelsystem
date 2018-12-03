package com.example.cykelsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {

    @Id
    private int status_id;
    private String status_title;

    public Status(int status_id, String status_title) {
        this.status_id = status_id;
        this.status_title = status_title;
    }

    public Status(){}

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getStatus_title() {
        return status_title;
    }

    public void setStatus_title(String status_title) {
        this.status_title = status_title;
    }
}
