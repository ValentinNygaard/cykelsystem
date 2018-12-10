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

    @Override
    public List<RepairCase> findAll() {
        String sql = "select * from repair_case";
        RowMapper<RepairCase> rowMapper = new BeanPropertyRowMapper<>(RepairCase.class);
        List<RepairCase> repairCases = template.query(sql, rowMapper);
        return repairCases;
    }

    @Override
    public RepairCase findById(int id) {
        String sql = "select * from repair_case where repair_case_id = ?;";
        RowMapper<RepairCase> rowMapper = new BeanPropertyRowMapper<>(RepairCase.class);
        RepairCase repairCase = template.queryForObject(sql, rowMapper, id);
        return repairCase;
    }

    @Override
    public RepairCase create(RepairCase repairCase) {
        String sql1 = "INSERT INTO repair_case (repair_case_id, start_date, end_date, status_id, bicycle_id, customer_employee_id, repair_employee_id, repair_number) VALUES(?,?,?,?,?,?,?,?)";
        template.update(sql1, repairCase.getRepair_case_id(), repairCase.getStart_date(),repairCase.getEnd_date(), repairCase.getStatus_id(), repairCase.getBicycle_id(), repairCase.getCustomer_employee_id(), repairCase.getRepair_employee_id(), repairCase.getRepair_number());
        return repairCase;
    }

    @Override
    public RepairCase update(RepairCase repairCase) {
        String sql = "UPDATE repair_case SET start_date=?, end_date=?, status_id=?, bicycle_id=?, customer_employee_id=?, repair_employee_id=?, repair_number=? WHERE repair_case_id=?";
        template.update(sql, repairCase.getStart_date(), repairCase.getEnd_date(), repairCase.getStatus_id(), repairCase.getBicycle_id(), repairCase.getCustomer_employee_id(), repairCase.getRepair_employee_id(), repairCase.getRepair_number(), repairCase.getRepair_case_id());
        RowMapper<RepairCase> rowMapper = new BeanPropertyRowMapper<>(RepairCase.class);
        return repairCase;
    }

    @Override
    public boolean delete(int id){
        String sql = "DELETE FROM repair_case WHERE repair_case_id=?";
        return template.update(sql, id) >= 0;
    }

    public int nextId() {
        List<RepairCase> tempList = findAll();
        int nextId = tempList.get(tempList.size());
        //int nextId = tempList.size();
        return nextId;
    }
}






