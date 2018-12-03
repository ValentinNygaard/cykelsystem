package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.RepairLineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepairLineItemRepoImpl implements IRepo<RepairLineItem> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<RepairLineItem> findAll() {
        return null;
    }

    @Override
    public RepairLineItem findById(RepairLineItem repairLineItem) {
        return null;
    }

    @Override
    public RepairLineItem create(RepairLineItem repairLineItem) {
        return null;
    }

    @Override
    public RepairLineItem update(RepairLineItem repairLineItem) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
