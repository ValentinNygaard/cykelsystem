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

    // All the methods with the @Override annotation, is implemeted.

    /* This method finds all objects of RepairLineItem in the database
    it does this through the JdbcTemplate. */
    @Override
    public List<RepairLineItem> findAll(){
        String sql = "SELECT * FROM repair_line_item";
        RowMapper<RepairLineItem> rowMapper = new BeanPropertyRowMapper<>(RepairLineItem.class);
        return template.query(sql, rowMapper);
    }

    // This method finds an object of RepairLineItem, with a specific repair_line_item_id.
    @Override
    public RepairLineItem findById(int id){
        String sql = "SELECT * FROM repair_line_item WHERE repair_line_item_id=?";
        RowMapper<RepairLineItem> rowMapper = new BeanPropertyRowMapper<>(RepairLineItem.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    // This method creates an object of RepairLineItem
    @Override
    public RepairLineItem create(RepairLineItem rli) {
        String sql = "INSERT INTO repair_line_item (repair_line_item_id, description, time, price, repair_case_id) VALUES(?,?,?,?,?)";
        template.update(sql, rli.getRepair_line_item_id(), rli.getDescription(), rli.getTime(), rli.getPrice(), rli.getRepair_case_id());
        return rli;
    }

    // This method updates an object of RepairLineItem, with a specific repair_line_item_id
    @Override
    public RepairLineItem update(RepairLineItem rli) {
        String sql = "UPDATE repair_line_item SET description=?, time=?, price=?, repair_case_id=? WHERE repair_line_item_id=?";
        template.update(sql, rli.getDescription(), rli.getTime(), rli.getPrice(), rli.getRepair_case_id(), rli.getRepair_line_item_id());
        return rli;
    }

    // This method deletes an object of RepairLineItem, with a specific repair_line_item_id.
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM repair_line_item WHERE repair_line_item_id=?";
        return template.update(sql, id) >= 0;
    }

    // This method finds a RepairLineItem, with a specific repair_case_id.
    public List<RepairLineItem> findByRcId(int repair_case_id) {
        String sql = "SELECT * FROM repair_line_item WHERE repair_case_id=?";
        RowMapper<RepairLineItem> rowMapper = new BeanPropertyRowMapper<>(RepairLineItem.class);
        return template.query(sql, rowMapper, repair_case_id);
    }

    // This method returns the sum of time on a repair_case_id.
    public int sumRepairTimeByRepairCaseId(int repair_case_id) {
            String sql = "SELECT repair_case_id, sum(time) as time\n" +
                    "FROM repair_line_item\n" +
                    "WHERE repair_case_id = ?;";
            RowMapper<Integer> rowMapper = new BeanPropertyRowMapper<>(Integer.class);
            Integer time = template.queryForObject(sql, rowMapper, repair_case_id);
            return time.intValue();
    }

    // This method sums the price of a specific repair_case_id.
    public double sumRepairPriceByRepairCaseId(int repair_case_id) {
        String sql = "SELECT repair_case_id, sum(price) as price\n" +
                "FROM repair_line_item\n" +
                "WHERE repair_case_id = ?;";
        RowMapper<Double> rowMapper = new BeanPropertyRowMapper<>(Double.class);
        Double price = template.queryForObject(sql, rowMapper, repair_case_id);
        return price.doubleValue();
    }




}
