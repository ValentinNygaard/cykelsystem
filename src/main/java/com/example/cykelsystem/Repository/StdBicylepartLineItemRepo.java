package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.StdBicyclepartLineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StdBicylepartLineItemRepo implements IRepo<StdBicyclepartLineItem> {


    @Autowired
    JdbcTemplate template;

    @Override
    public List<StdBicyclepartLineItem> findAll(){
        String sql = "SELECT * FROM std_bicyclepart_line_item";
        RowMapper<StdBicyclepartLineItem> rowMapper = new BeanPropertyRowMapper<>(StdBicyclepartLineItem.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public StdBicyclepartLineItem findById(int id){
        String sql = "SELECT * FROM std_bicycle_line_item WHERE std_bicycle_line_item_id=?";
        RowMapper<StdBicyclepartLineItem> rowMapper = new BeanPropertyRowMapper<>(StdBicyclepartLineItem.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    @Override
    public StdBicyclepartLineItem create(StdBicyclepartLineItem sbli) {
        String sql = "INSERT INTO std_bicycle_line_item (std_bicycle_line_item_id, description, price) VALUES(?,?,?)";
        template.update(sql, sbli.getStd_bicycle_line_item_id(), sbli.getDescription(), sbli.getPrice(), sbli.getPrice());
        return sbli;
    }

    @Override
    public StdBicyclepartLineItem update(StdBicyclepartLineItem sbli) {
        String sql = "UPDATE std_bicyclepart_line_item SET description=?, price=? WHERE std_bicycle_line_item_id=?";
        template.update(sql, sbli.getDescription(), sbli.getPrice(), sbli.getStd_bicycle_line_item_id());
        return sbli;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM std_bicyclepart_line_item WHERE std_bicycle_line_item_id=?";
        return template.update(sql, id) >= 0;
    }
}

