package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.StdPartLineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StdPartLineItemRepoImpl implements IRepo<StdPartLineItem> {


    @Autowired
    JdbcTemplate template;
    // All the methods with the @Override annotation, is implemeted.

    /* This method finds all objects of StdPartLineItem in the database
    it does this through the JdbcTemplate. */
    @Override
    public List<StdPartLineItem> findAll(){
        String sql = "SELECT * FROM std_part_line_item";
        RowMapper<StdPartLineItem> rowMapper = new BeanPropertyRowMapper<>(StdPartLineItem.class);
        return template.query(sql, rowMapper);
    }

    // This method returns a StdPartLineItem with a specific std_part_line_item_id.
    @Override
    public StdPartLineItem findById(int id){
        String sql = "SELECT * FROM std_part_line_item WHERE std_part_line_item_id=?";
        RowMapper<StdPartLineItem> rowMapper = new BeanPropertyRowMapper<>(StdPartLineItem.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    // This method creates a StdPartLineItem object
    @Override
    public StdPartLineItem create(StdPartLineItem spil) {
        String sql = "INSERT INTO std_part_line_item (std_part_line_item_id, description, price) VALUES(?,?,?)";
        template.update(sql, spil.getStd_part_line_item_id(), spil.getDescription(), spil.getPrice());
        return spil;
    }

    // This method updates a StdPartLineItem object, with a specific std_part_line_item_id.
    @Override
    public StdPartLineItem update(StdPartLineItem spil) {
        String sql = "UPDATE std_part_line_item SET description=?, price=? WHERE std_part_line_item_id=?";
        template.update(sql, spil.getDescription(), spil.getPrice(), spil.getStd_part_line_item_id());
        return spil;
    }

    // This method deletes a StdPartLineItem object, with a specific std_part_line_item_id.
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM std_part_line_item WHERE std_part_line_item_id=?";
        return template.update(sql, id) >= 0;
    }
}

