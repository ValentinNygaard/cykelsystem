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
        String sql = "select repair_case.repair_case_id, start_date, end_date, status_id, bicycle_id, customer_employee_id, repair_employee_id, repair_number, comment.comment\n" +
                "from repair_case left join comment using(repair_case_id)";
        RowMapper<RepairCase> rowMapper = new BeanPropertyRowMapper<>(RepairCase.class);
        List<RepairCase> repairCases = template.query(sql, rowMapper);
        return repairCases;
    }

    @Override
    public RepairCase findById(int id) {
        String sql = "select repair_case.repair_case_id, repair_case.start_date, repair_case.end_date, repair_case.status_id, repair_case.bicycle_id,\n" +
                "\t\trepair_case.customer_employee_id, repair_case.repair_employee_id, repair_case.repair_number, comment.comment\n" +
                "from repair_case\n" +
                "left join comment on repair_case.repair_case_id = comment.repair_case_id\n" +
                "where repair_case.repair_case_id = ?;";
        RowMapper<RepairCase> rowMapper = new BeanPropertyRowMapper<>(RepairCase.class);
        RepairCase repairCase = template.queryForObject(sql, rowMapper, id);
        return repairCase;
    }

    @Override
    public RepairCase create(RepairCase repairCase) {
        String sql1 = "INSERT INTO repair_case (repair_case_id, start_date, end_date, status_id, bicycle_id, customer_employee_id, repair_employee_id, repair_number) VALUES(?,?,?,?,?,?,?,?)";
        template.update(sql1, repairCase.getRepair_case_id(), repairCase.getStart_date(),repairCase.getEnd_date(),
                repairCase.getStatus_id(), repairCase.getBicycle_id(), repairCase.getCustomer_employee_id(),
                repairCase.getRepair_employee_id(), repairCase.getRepair_number());

        /*if(repairCase.getComment() == null) {
        }
        else{
            RepairCase r = returnRepairCaseWithSqlId(repairCase);
            String sql2 = "INSERT INTO comment (repair_case_id, comment) VALUES (?,?)";
            template.update(sql2, repairCase.getRepair_case_id(), repairCase.getComment());
        }*/
        RepairCase r = returnRepairCaseWithSqlId(repairCase);
        return r;
    }

    @Override
    public RepairCase update(RepairCase repairCase) {
        String sql1 = "UPDATE repair_case SET start_date=?, end_date=?, status_id=?, bicycle_id=?,customer_employee_id=?, repair_employee_id=?, repair_number=? WHERE repair_case_id=?";
        template.update(sql1, repairCase.getStart_date(), repairCase.getEnd_date(), repairCase.getStatus_id(),
                repairCase.getBicycle_id(), repairCase.getCustomer_employee_id(), repairCase.getCustomer_employee_id(), repairCase.getRepair_number(), repairCase.getRepair_case_id());
        String sql2 = "SELECT * FROM comment WHERE repair_case_id=?";
        RowMapper<RepairCase> rowMapper = new BeanPropertyRowMapper<>(RepairCase.class);
        if(repairCase.getComment() == null) {
        }
        else if(template.queryForObject(sql2, rowMapper, repairCase.getRepair_case_id()) == null){
            String sql3 = "INSERT INTO comment (repair_case_id, comment) VALUES (?,?)";
            template.update(sql3, repairCase.getRepair_case_id(), repairCase.getComment());
        }
        else{
            String sql4 = "UPDATE comment SET comment=? WHERE repair_case_id=?";
            template.update(sql4, repairCase.getComment(), repairCase.getRepair_case_id());
        }
        return repairCase;
    }

    @Override
    public boolean delete(int id){
    String sql = "DELETE FROM repair_case WHERE repair_case_id=?";
    String sql2 = "DELETE FROM comment WHERE repair_case_id=?";
    template.update(sql2, id);
        return template.update(sql, id) >= 0;
    }

    public RepairCase returnRepairCaseWithSqlId(RepairCase repairCase) {
        String sql = "select repair_case_id, start_date, end_date, status_id, bicycle_id, customer_employee_id, repair_employee_id, repair_number, comment\n" +
                "from repair_case left join comment using(repair_case_id)\n" +
                "where start_date = ? and end_date = ? and repair_number = ?;";
        RowMapper<RepairCase> rowMapper = new BeanPropertyRowMapper<>(RepairCase.class);
        RepairCase r = template.queryForObject(sql, rowMapper, repairCase.getStart_date(), repairCase.getEnd_date(), repairCase.getRepair_number());
        return r;
    }

}






