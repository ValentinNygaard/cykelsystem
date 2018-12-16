package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.PartLineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartLineItemRepoImlp implements IRepo<PartLineItem>{
    @Autowired
    JdbcTemplate template;

    // All the methods with the @Override annotation, is implemeted.

    /* This method finds all objects of PartLineItem in the database
    it does this through the JdbcTemplate. */
    @Override
    public List<PartLineItem> findAll() {
        String sql = "SELECT * FROM part_line_item";
        RowMapper<PartLineItem> rowMapper = new BeanPropertyRowMapper<>(PartLineItem.class);
        return template.query(sql, rowMapper);
    }

    // This method finds a specific PartLineItem with a specific part_line_item_id.
    @Override
    public PartLineItem findById(int id) {
        String sql ="SELECT * FROM part_line_item WHERE part_line_item_id=?";
        RowMapper<PartLineItem> rowMapper = new BeanPropertyRowMapper<>(PartLineItem.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    // This method creates an object of PartLineItem
    @Override
    public PartLineItem create(PartLineItem partLineItem) {
        String sql = "INSERT INTO  part_line_item (part_line_item_id, description, price, repair_case_id) VALUES(?,?,?,?)";
        template.update(sql, partLineItem.getPart_line_item_id(), partLineItem.getDescription(), partLineItem.getPrice(), partLineItem.getRepair_case_id());
        return partLineItem;
    }

    // This method updates an object of Employee, on a specific employee_id
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM part_line_item WHERE part_line_item_id=?";
        return  template.update(sql, id) >= 0;
    }

    // This method deletes an Employee on a specific employee_id.

    @Override
    public PartLineItem update(PartLineItem partLineItem) {
        String sql = "UPDATE part_line_item SET description=?, price=?, repair_case_id=? WHERE part_line_item_id=?";
        template.update(sql,partLineItem.getDescription(), partLineItem.getPrice(), partLineItem.getRepair_case_id(),partLineItem.getPart_line_item_id());
        return partLineItem;
    }

    // This method finds a PartLineItem with a specific repair_case_id.
    public List<PartLineItem> findByRcId(int repair_case_id) {
        String sql = "SELECT * FROM part_line_item WHERE repair_case_id=?";
        RowMapper<PartLineItem> rowMapper = new BeanPropertyRowMapper<>(PartLineItem.class);
        return template.query(sql, rowMapper, repair_case_id);
    }

    // This method sums the price of a PartLineItem, on a repair_case_id.
    public double sumPartPriceByRepairCaseId(int repair_case_id) {
        String sql = "SELECT repair_case_id, sum(price) as price\n" +
                "FROM part_line_item\n" +
                "WHERE repair_case_id = ?;";
        RowMapper<Double> rowMapper = new BeanPropertyRowMapper<>(Double.class);
        Double price = template.queryForObject(sql, rowMapper, repair_case_id);
        return price.doubleValue();
    }
}
