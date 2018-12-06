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
        String sql = "SELECT * FROM std_part_line_item";
        RowMapper<StdPartItemLine> rowMapper = new BeanPropertyRowMapper<>(StdPartItemLine.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public StdPartItemLine findById(int id){
        String sql = "SELECT * FROM std_part_line_item WHERE std_part_line_item_id=?";
        RowMapper<StdPartItemLine> rowMapper = new BeanPropertyRowMapper<>(StdPartItemLine.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    @Override
    public StdPartItemLine create(StdPartItemLine spil) {
        String sql = "INSERT INTO std_part_line_item (std_part_line_item_id, description, price) VALUES(?,?,?)";
        template.update(sql, spil.getStd_part_line_item_id(), spil.getDescription(), spil.getPrice(), spil.getPrice());
        return spil;
    }

    @Override
    public StdPartItemLine update(StdPartItemLine spil) {
        String sql = "UPDATE std_part_line_item SET description=?, price=? WHERE std_part_line_item_id=?";
        template.update(sql, spil.getDescription(), spil.getPrice(), spil.getStd_part_line_item_id());
        return spil;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM std_part_line_item WHERE std_part_line_item_id=?";
        return template.update(sql, id) >= 0;
    }
}

