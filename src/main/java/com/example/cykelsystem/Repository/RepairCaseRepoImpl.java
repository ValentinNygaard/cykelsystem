package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.RepairCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepairCaseRepoImpl implements IRepo<RepairCase> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<RepairCase> findAll() {
        return null;
    }

    @Override
    public RepairCase findById(int id) {
        return null;
    }

    @Override
    public RepairCase create(RepairCase repairCase) {
        return null;
    }

    @Override
    public RepairCase update(RepairCase repairCase) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
