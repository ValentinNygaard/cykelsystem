package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BicycleRepoImpl implements IRepo<Bicycle> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Bicycle> findAll() {
        return null;
    }

    @Override
    public Bicycle findById(int id) {
        return null;
    }

    @Override
    public Bicycle create(Bicycle bicycle) {
        return null;
    }

    @Override
    public Bicycle update(Bicycle bicycle) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
        return false;
    }
}
