package com.example.cykelsystem.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepoImpl implements IRepo {

    @Autowired
    JdbcTemplate template;

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object findById(Object object) {
        return null;
    }

    @Override
    public Object create(Object object) {
        return null;
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
