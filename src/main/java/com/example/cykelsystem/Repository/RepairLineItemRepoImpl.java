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

    public List<RepairLineItem> findByRcId(int repair_case_id) {
        String sql = "SELECT * FROM repair_line_item WHERE repair_case_id=?";
        RowMapper<RepairLineItem> rowMapper = new BeanPropertyRowMapper<>(RepairLineItem.class);
        return template.query(sql, rowMapper, repair_case_id);
    }

    @Override
    public RepairLineItem findById(int id){
        String sql = "SELECT * FROM repair_line_item WHERE repair_line_item_id=?";
        RowMapper<RepairLineItem> rowMapper = new BeanPropertyRowMapper<>(RepairLineItem.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    @Override
    public RepairLineItem create(RepairLineItem rli) {
        String sql = "INSERT INTO repair_line_item (repair_line_item_id, description, time, price, repair_case_id) VALUES(?,?,?,?,?)";
        template.update(sql, rli.getRepair_line_item_id(), rli.getDescription(), rli.getTime(), rli.getPrice(), rli.getRepair_case_id());
        return rli;
    }

    @Override
    public RepairLineItem update(RepairLineItem rli) {
        String sql = "UPDATE repair_line_item SET description=?, time=?, price=?, repair_case_id=? WHERE repair_line_item_id=?";
        template.update(sql, rli.getDescription(), rli.getTime(), rli.getPrice(), rli.getRepair_case_id(), rli.getRepair_line_item_id());
        return rli;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM repair_line_item WHERE repair_line_item_id=?";
        return template.update(sql, id) >= 0;
    }
}
