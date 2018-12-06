package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.StdPartItemLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StdPartLineItemRepoImpl implements IRepo<StdPartItemLine> {


    @Autowired
    JdbcTemplate template;

    @Override
    public List<StdPartItemLine> findAll(){
        String sql = "SELECT * FROM std_bicyclepart_line_item";
        RowMapper<StdPartItemLine> rowMapper = new BeanPropertyRowMapper<>(StdPartItemLine.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public StdPartItemLine findById(int id){
        String sql = "SELECT * FROM std_bicycle_line_item WHERE std_bicycle_line_item_id=?";
        RowMapper<StdPartItemLine> rowMapper = new BeanPropertyRowMapper<>(StdPartItemLine.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    @Override
    public StdPartItemLine create(StdPartItemLine sbli) {
        String sql = "INSERT INTO std_bicycle_line_item (std_bicycle_line_item_id, description, price) VALUES(?,?,?)";
        template.update(sql, sbli.getStd_part_line_item_id(), sbli.getDescription(), sbli.getPrice(), sbli.getPrice());
        return sbli;
    }

    @Override
    public StdPartItemLine update(StdPartItemLine sbli) {
        String sql = "UPDATE std_bicyclepart_line_item SET description=?, price=? WHERE std_bicycle_line_item_id=?";
        template.update(sql, sbli.getDescription(), sbli.getPrice(), sbli.getStd_part_line_item_id());
        return sbli;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM std_bicyclepart_line_item WHERE std_bicycle_line_item_id=?";
        return template.update(sql, id) >= 0;
    }
}

