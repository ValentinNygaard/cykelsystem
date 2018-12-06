package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.RepBarLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class RepBarLineRepo implements IRepo<RepBarLine> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<RepBarLine> findAll() {
        String sql = "";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        return template.query(sql, rowMapper);
        //    phone_number, repair_number, time, price, status, end_date;
    }



    @Override
    public RepBarLine findById(int id) {
        return null;
    }

    @Override
    public RepBarLine create(RepBarLine repBarLine) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public RepBarLine update(RepBarLine repBarLine) {
        return null;
    }
}
