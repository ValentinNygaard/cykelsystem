// Made by EPS
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

    // All the methods with the @Override annotation, is implemeted.

    /* This method finds all objects of bicycle in the database
     it does this through the JdbcTemplate. */
    @Override
    public List<Bicycle> findAll() {
        String sql = "SELECT * FROM bicycle";
        RowMapper<Bicycle> rowMapper = new BeanPropertyRowMapper<>(Bicycle.class);
        List<Bicycle> bicycles = template.query(sql, rowMapper);
        return bicycles;
    }
    // This method returns a Bicycle with a specific id.
    @Override
    public Bicycle findById(int id) {
        String sql = "SELECT * FROM bicycle WHERE bicycle_id=?";
        RowMapper<Bicycle> rowMapper = new BeanPropertyRowMapper<>(Bicycle.class);
        Bicycle bicycle = template.queryForObject(sql, rowMapper, id);
        return bicycle;
    }

    // This method creates a new object of a Bicycle
    @Override
    public Bicycle create(Bicycle bicycle) {
        String sql = "INSERT INTO bicycle (bicycle_id, description, customer_id) VALUES(?,?,?)";
        template.update(sql, bicycle.getBicycle_id(), bicycle.getDescription(),bicycle.getCustomer_id());
        return bicycle;
    }

    // This method updates an object of a Bicycle
    @Override
    public Bicycle update(Bicycle bicycle) {
        String sql = "UPDATE bicycle SET description=? WHERE bicycle_id=?";
        template.update(sql, bicycle.getDescription(), bicycle.getBicycle_id());
        Bicycle newBicycle = findById(bicycle.getBicycle_id());
        return newBicycle;
    }

    // This method delets an object of a Bicycle, with a specific id.
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM bicycle WHERE bicycle_id=?";
        return template.update(sql, id) >= 0;
    }

    // This method returns a list of bicyles, with a specific customer id.
    public List<Bicycle> findAllByCustomer(int customer_id){
        String sql = "SELECT * FROM bicycle WHERE customer_id=?";
        RowMapper<Bicycle> rowMapper = new BeanPropertyRowMapper<>(Bicycle.class);
        List<Bicycle> bicycles = template.query(sql, rowMapper, customer_id);
        return bicycles;
    }

    // This method returns the last id of the objects of bicycle.
    public int lastId() {
        String sql2 ="SELECT LAST_INSERT_ID()";
        Integer id = (template.queryForObject(sql2, Integer.class));
        return id.intValue();
    }
}