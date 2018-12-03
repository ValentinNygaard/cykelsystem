package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BicycleRepoImpl implements IRepo<Bicycle> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Bicycle> findAll() {
        String sql = "SELECT * FROM bicycle";
        RowMapper<Bicycle> rowMapper = new BeanPropertyRowMapper<>(Bicycle.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public Bicycle findById(int id) {
        String sql = "SELECT * FROM bicycle WHERE bicycle_id=?";
        RowMapper<Bicycle> rowMapper = new BeanPropertyRowMapper<>(Bicycle.class);
        Bicycle bicycle = template.queryForObject(sql, rowMapper, id);
        return bicycle;
    }

    @Override
    public Bicycle create(Bicycle bicycle) {
        String sql = "INSERT INTO bicycle (bicycle_id, description, customer_id) VALUES(?,?,?)";
        template.update(sql, bicycle.getBicycle_id(), bicycle.getDescription(),bicycle.getCustomer_id());
        return bicycle;
    }

    @Override
    public Bicycle update(Bicycle bicycle) {
        String sql = "UPDATE bicycle SET description=? WHERE bicycle_id=?";
        template.update(sql, bicycle.getDescription(), bicycle.getBicycle_id());
        Bicycle newBicycle = findById(bicycle.getBicycle_id());
        return newBicycle;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM bicycle WHERE bicycle_id=?";
        return template.update(sql, id) >= 0;
    }
}