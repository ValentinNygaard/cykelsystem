// Made by all
package com.example.cykelsystem.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity      // This defines that this is a class, in the Spring framework
public class Comment {

    @Id
    private int repair_case_id;
    private String comment;

    public Comment(int repair_case_id, String comment) {
        this.repair_case_id = repair_case_id;
        this.comment = comment;
    }

    public Comment(){};

    public int getRepair_case_id() {
        return repair_case_id;
    }

    public void setRepair_case_id(int repair_case_id) {
        this.repair_case_id = repair_case_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
