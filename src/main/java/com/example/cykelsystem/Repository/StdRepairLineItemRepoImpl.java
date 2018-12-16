package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.StdRepairLineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StdRepairLineItemRepoImpl implements IRepo<StdRepairLineItem> {

    @Autowired
    JdbcTemplate template;
    // All the methods with the @Override annotation, is implemeted.

    /* This method finds all objects of StdRepairLineItem in the database
    it does this through the JdbcTemplate. */
    @Override
    public List<StdRepairLineItem> findAll(){
        String sql = "SELECT * FROM std_repair_line_item";
        RowMapper<StdRepairLineItem> rowMapper = new BeanPropertyRowMapper<>(StdRepairLineItem.class);
        return template.query(sql, rowMapper);
    }

    // This method returns a StdRepairLineItem with a specific std_repair_line_item_id.
    @Override
    public StdRepairLineItem findById(int id){
        String sql = "SELECT * FROM std_repair_line_item WHERE std_repair_line_item_id=?";
        RowMapper<StdRepairLineItem> rowMapper = new BeanPropertyRowMapper<>(StdRepairLineItem.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    // This method creates a StdRepairLineItem object
    @Override
    public StdRepairLineItem create(StdRepairLineItem srli) {
        String sql = "INSERT INTO std_repair_line_item (std_repair_line_item_id, description, time, price) VALUES(?,?,?,?)";
        template.update(sql, srli.getStd_repair_line_item_id(), srli.getDescription(), srli.getTime(), srli.getPrice());
        return srli;
    }

    // This method updates a StdRepairLineItem object, with a specific std_repair_line_item_id.
    @Override
    public StdRepairLineItem update(StdRepairLineItem srli) {
        String sql = "UPDATE std_repair_line_item SET description=?, time=?, price=? WHERE std_repair_line_item_id=?";
        template.update(sql, srli.getDescription(), srli.getTime(), srli.getPrice(), srli.getStd_repair_line_item_id());
        return srli;
    }

    // This method deletes a StdRepairLineItem object, with a specific std_part_line_item_id.
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM std_repair_line_item WHERE std_repair_line_item_id=?";
        return template.update(sql, id) >= 0;
    }
}

