//Made by EPS
package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.RepBarLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepBarLineRepoImpl {

    @Autowired
    JdbcTemplate template;

    // This method returns a list of RepBarLine with specific status_id's
    public List<RepBarLine> findRepbarsWithStatus(int fromStatus, int toStatus) {
        String sql = "SELECT repair_case_id, customer.phone_number, repair_number, IFNULL(t1.time, 0) AS time, IFNULL(t1.price, 0) AS price, status_title, end_date, customer.name AS customer_name, employee.name AS employee_name\n" +
                "FROM customer NATURAL JOIN bicycle\n" +
                "NATURAL JOIN repair_case\n" +
                "LEFT JOIN employee on repair_case.repair_employee_id = employee.employee_id\n" +
                "NATURAL JOIN (SELECT repair_case_id, status_title, sum(time) AS time, sum(price) AS price\n" +
                "FROM status NATURAL JOIN repair_case LEFT JOIN repair_line_item using(repair_case_id)\n" +
                "GROUP BY repair_case_id) t1\n" +
                "WHERE status_id >= ? AND status_id <= ?\n" +
                "group by repair_case_id\n" +
                "order by end_date, status_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        List<RepBarLine> repBarLines = template.query(sql, rowMapper, fromStatus, toStatus);
        return repBarLines;
    }

    // This method returns a list of RepBarLines, with specific status_id's ordered by the date
    public List<RepBarLine> findRepbarsWithStatusFromDate(int fromStatus, int toStatus, String fromDate) {
        String sql = "SELECT repair_case_id, customer.phone_number, repair_number, IFNULL(t1.time, 0) AS time, IFNULL(t1.price, 0) AS price, status_title, end_date, customer.name AS customer_name, employee.name AS employee_name\n" +
                "FROM customer NATURAL JOIN bicycle\n" +
                "NATURAL JOIN repair_case\n" +
                "LEFT JOIN employee on repair_case.repair_employee_id = employee.employee_id\n" +
                "NATURAL JOIN (SELECT repair_case_id, status_title, sum(time) AS time, sum(price) AS price\n" +
                "FROM status NATURAL JOIN repair_case LEFT JOIN repair_line_item using(repair_case_id)\n" +
                "GROUP BY repair_case_id) t1\n" +
                "WHERE status_id >= ? AND status_id <= ? AND end_date >= ?\n" +
                "group by repair_case_id\n" +
                "order by end_date, status_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        List<RepBarLine> repBarLines = template.query(sql, rowMapper, fromStatus, toStatus, fromDate);
        return repBarLines;
    }

    // This method returns a list of RepBarLines, with specific status_id's, between given dates :skal måske laves i search
    public List<RepBarLine> findRepbarsWithStatusBetweenDates(int fromStatus, int toStatus, String fromDate, String toDate) {
        String sql = "SELECT repair_case_id, customer.phone_number, repair_number, IFNULL(t1.time, 0) AS time, IFNULL(t1.price, 0) AS price, status_title, end_date, customer.name AS customer_name, employee.name AS employee_name\n" +
                "FROM customer NATURAL JOIN bicycle\n" +
                "NATURAL JOIN repair_case\n" +
                "LEFT JOIN employee on repair_case.repair_employee_id = employee.employee_id\n" +
                "NATURAL JOIN (SELECT repair_case_id, status_title, sum(time) AS time, sum(price) AS price\n" +
                "FROM status NATURAL JOIN repair_case LEFT JOIN repair_line_item using(repair_case_id)\n" +
                "GROUP BY repair_case_id) t1\n" +
                "WHERE status_id >= ? AND status_id <= ? AND end_date >= ? AND end_date <= ?\n" +
                "group by repair_case_id\n" +
                "order by end_date, status_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        List<RepBarLine> repBarLines = template.query(sql, rowMapper, fromStatus, toStatus, fromDate, toDate);
        return repBarLines;
    }

    public List<RepBarLine> findByStartDate(String fromDate, String toDate) {
        String sql = "SELECT repair_case_id, customer.phone_number, repair_number, IFNULL(t1.time, 0) AS time, IFNULL(t1.price, 0) AS price, status_title, start_date as end_date, customer.name AS customer_name, employee.name AS employee_name\n" +
                "FROM customer NATURAL JOIN bicycle\n" +
                "NATURAL JOIN repair_case\n" +
                "LEFT JOIN employee ON repair_case.repair_employee_id = employee.employee_id\n" +
                "NATURAL JOIN (SELECT repair_case_id, status_title, sum(time) AS time, sum(price) AS price\n" +
                "FROM status NATURAL JOIN repair_case LEFT JOIN repair_line_item using(repair_case_id)\n" +
                "GROUP BY repair_case_id) t1\n" +
                "WHERE start_date >= ? AND start_date <= ?\n" +
                "group by repair_case_id\n" +
                "order by start_date, status_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        List<RepBarLine> repBarLines = template.query(sql, rowMapper, fromDate, toDate);
        return repBarLines;
    }

    public List<RepBarLine> findByCustomerName(String customerName) {
        String sql = "SELECT repair_case_id, customer.phone_number, repair_number, IFNULL(t1.time, 0) AS time, IFNULL(t1.price, 0) AS price, status_title, end_date, customer.name AS customer_name, employee.name AS employee_name\n" +
                "FROM customer NATURAL JOIN bicycle\n" +
                "NATURAL JOIN repair_case\n" +
                "LEFT JOIN employee on repair_case.repair_employee_id = employee.employee_id\n" +
                "NATURAL JOIN (SELECT repair_case_id, status_title, sum(time) AS time, sum(price) AS price\n" +
                "FROM status NATURAL JOIN repair_case LEFT JOIN repair_line_item using(repair_case_id)\n" +
                "GROUP BY repair_case_id) t1\n" +
                "WHERE customer.name LIKE ?\t\n" +
                "group by repair_case_id\n" +
                "order by end_date, status_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        List<RepBarLine> repBarLines = template.query(sql, rowMapper, customerName);
        return repBarLines;
    }

    public List<RepBarLine> findByRepairEmployeeNameAndDate(String employeeName, String fromDate, String toDate) {
        String sql = "SELECT repair_case_id, customer.phone_number, repair_number, IFNULL(t1.time, 0) AS time, IFNULL(t1.price, 0) AS price, status_title, end_date, customer.name AS customer_name, employee.name AS employee_name\n" +
                "FROM customer NATURAL JOIN bicycle\n" +
                "NATURAL JOIN repair_case\n" +
                "LEFT JOIN employee on repair_case.repair_employee_id = employee.employee_id\n" +
                "NATURAL JOIN (SELECT repair_case_id, status_title, sum(time) AS time, sum(price) AS price\n" +
                "FROM status NATURAL JOIN repair_case LEFT JOIN repair_line_item using(repair_case_id)\n" +
                "GROUP BY repair_case_id) t1\n" +
                "WHERE employee.name LIKE ? AND start_date >= ? AND start_date <= ? AND status_id > 2\n" +/*LIKE '%?%'*/
                "group by repair_case_id\n" +
                "order by end_date, status_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        List<RepBarLine> repBarLines = template.query(sql, rowMapper, employeeName, fromDate, toDate);
        return repBarLines;
    }

    public List<RepBarLine> findByCreateEmployeeNameAndDate(String employeeName, String fromDate, String toDate){
        String sql = "SELECT repair_case_id, customer.phone_number, repair_number, IFNULL(t1.time, 0) AS time, IFNULL(t1.price, 0) AS price, status_title, start_date AS end_date, customer.name AS customer_name, employee.name AS employee_name\n" +
                "FROM customer NATURAL JOIN bicycle\n" +
                "NATURAL JOIN repair_case\n" +
                "LEFT JOIN employee on repair_case.customer_employee_id = employee.employee_id\n" +
                "NATURAL JOIN (SELECT repair_case_id, status_title, sum(time) AS time, sum(price) AS price\n" +
                "FROM status NATURAL JOIN repair_case LEFT JOIN repair_line_item using(repair_case_id)\n" +
                "GROUP BY repair_case_id) t1\n" +
                "WHERE employee.name LIKE ? AND start_date >= ? AND start_date <= ?\n" +
                "group by repair_case_id\n" +
                "order by start_date, status_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        List<RepBarLine> repBarLines = template.query(sql, rowMapper, employeeName, fromDate, toDate);
        return repBarLines;
    }

    public List<RepBarLine> findByPhoneNumber(String phoneNumber){
        String sql = "SELECT repair_case_id, customer.phone_number, repair_number, IFNULL(t1.time, 0) AS time, IFNULL(t1.price, 0) AS price, status_title, end_date, customer.name AS customer_name, employee.name AS employee_name\n" +
                "FROM customer NATURAL JOIN bicycle\n" +
                "NATURAL JOIN repair_case\n" +
                "LEFT JOIN employee on repair_case.customer_employee_id = employee.employee_id\n" +
                "NATURAL JOIN (SELECT repair_case_id, status_title, sum(time) AS time, sum(price) AS price\n" +
                "FROM status NATURAL JOIN repair_case LEFT JOIN repair_line_item using(repair_case_id)\n" +
                "GROUP BY repair_case_id) t1\n" +
                "WHERE customer.phone_number = ?\n" +
                "group by repair_case_id\n" +
                "order by start_date, status_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        List<RepBarLine> repBarLines = template.query(sql, rowMapper, phoneNumber);
        return repBarLines;
    }
 }


