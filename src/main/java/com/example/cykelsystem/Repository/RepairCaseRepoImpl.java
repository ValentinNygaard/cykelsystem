//Made by EPS, VN

package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.RepairCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepairCaseRepoImpl implements IRepo<RepairCase> {

    @Autowired
    JdbcTemplate template;
    // All the methods with the @Override annotation, is implemeted.

    /* This method finds all objects of RepairCase in the database
    it does this through the JdbcTemplate. */
    @Override
    public List<RepairCase> findAll() {
        String sql = "select * from repair_case";
        RowMapper<RepairCase> rowMapper = new BeanPropertyRowMapper<>(RepairCase.class);
        List<RepairCase> repairCases = template.query(sql, rowMapper);
        return repairCases;
    }

    // This method finds a RepairCase on a specific repair_case_id.
    @Override
    public RepairCase findById(int id) {
        String sql = "select * from repair_case where repair_case_id = ?;";
        RowMapper<RepairCase> rowMapper = new BeanPropertyRowMapper<>(RepairCase.class);
        RepairCase repairCase = template.queryForObject(sql, rowMapper, id);
        return repairCase;
    }

    // This method creates an object RepairCase
    @Override
    public RepairCase create(RepairCase repairCase) {
        String sql = "INSERT INTO repair_case (repair_case_id, start_date, end_date, status_id, bicycle_id, customer_employee_id, repair_employee_id, repair_number, end_time) VALUES(?,?,?,?,?,?,?,?,?)";
        template.update(sql, repairCase.getRepair_case_id(), repairCase.getStart_date(), repairCase.getEnd_date(), repairCase.getStatus_id(), repairCase.getBicycle_id(), repairCase.getCustomer_employee_id(), repairCase.getRepair_employee_id(), repairCase.getRepair_number(), repairCase.getEnd_time());
        return repairCase;
    }

    // This method updates a RepairCase with a specific repair_case_id
    @Override
    public RepairCase update(RepairCase repairCase) {
        String sql = "UPDATE repair_case SET start_date=?, end_date=?, status_id=?, bicycle_id=?, customer_employee_id=?, repair_employee_id=?, repair_number=?, end_time=? WHERE repair_case_id=?";
        template.update(sql, repairCase.getStart_date(), repairCase.getEnd_date(), repairCase.getStatus_id(), repairCase.getBicycle_id(), repairCase.getCustomer_employee_id(), repairCase.getRepair_employee_id(), repairCase.getRepair_number(), repairCase.getEnd_time(), repairCase.getRepair_case_id());
        return repairCase;
    }

    // This method deletes a RepairCase on a specific repair_case_id
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM repair_case WHERE repair_case_id=?";
        return template.update(sql, id) >= 0;
    }

    // This method returns the last id, of all the objects of RepairCase
    public int lastId() {
        String sql = "SELECT LAST_INSERT_ID()";
        Integer id = (template.queryForObject(sql, Integer.class));
        return id.intValue();
    }

    // This method returns the last Repair number, of all the objects of RepairCase
    public int lastRepairNumber() {
        List<RepairCase> tempList = findAll();
        int index = tempList.size() - 1;
        return tempList.get(index).getRepair_number();
    }

    // This method returns a list of RepairCase with a specific bicycle_id.
    public List<RepairCase> findAllByBicycleId(int id) {
        String sql = "select * from repair_case where bicycle_id = ?;";
        RowMapper<RepairCase> rowMapper = new BeanPropertyRowMapper<>(RepairCase.class);
        List<RepairCase> repairCases = template.query(sql, rowMapper, id);
        return repairCases;
    }

    public Integer getTotalPriceOnRepairCaseId(int id) {
        String sql = "SELECT IFNULL(sum(repair_line_item.price), 0) + t1.part_price AS total_price\n" +
                "FROM repair_case LEFT JOIN repair_line_item using(repair_case_id)\n" +
                "\tNATURAL JOIN (SELECT repair_case_id, IFNULL(sum(part_line_item.price), 0) AS part_price\n" +
                "FROM repair_case LEFT JOIN part_line_item using(repair_case_id)\n" +
                "WHERE repair_case_id = ?) t1\n" +
                "WHERE repair_case_id = ?;";
        Integer total_price = template.queryForObject(sql, Integer.class, id, id);
        return total_price;
    }

    public Integer getTotalTimeOnRepairCaseId(int id){
        String sql = "SELECT IFNULL(sum(time), 0) AS total_time\n" +
                "FROM repair_line_item \n" +
                "WHERE repair_case_id = ?;";
        Integer total_time = template.queryForObject(sql, Integer.class, id);
        return  total_time;
    }
}






