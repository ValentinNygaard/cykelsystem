package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.RepairLineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepairLineItemRepoImpl implements IRepo<RepairLineItem> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<RepairLineItem> findAll(){
        String sql = "SELECT * FROM repair_line_item";
        RowMapper<RepairLineItem> rowMapper = new BeanPropertyRowMapper<>(RepairLineItem.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public RepairLineItem findById(int id){
        String sql = "SELECT * FROM repair_line_item WHERE repair_line_item_id=?";
        RowMapper<RepairLineItem> rowMapper = new BeanPropertyRowMapper<>(RepairLineItem.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    @Override
    public RepairLineItem create(RepairLineItem srli) {
        String sql = "INSERT INTO repair_line_item (repair_line_item_id, description, time, price, repair_case_id) VALUES(?,?,?,?,?)";
        template.update(sql, srli.getRepair_line_item_id(), srli.getDescription(), srli.getTime(), srli.getPrice(), srli.getRepair_case_id());
        return srli;
    }

    @Override
    public RepairLineItem update(RepairLineItem srli) {
        String sql = "UPDATE repair_line_item SET (description, time, price, repair_case_id) VALUES(?,?,?,?) WHERE repair_line_item_id=?";
        template.update(sql, srli.getRepair_line_item_id(), srli.getDescription(), srli.getTime(), srli.getPrice());
        return srli;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM repair_line_item WHERE repair_line_item_id=?";
        return template.update(sql, id) >= 0;
    }
}
