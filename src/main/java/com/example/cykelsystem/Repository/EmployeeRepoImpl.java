package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepoImpl implements IRepo<Employee> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql, rowMapper);

    }

    @Override
    public  Employee findById(int id) {
        String sql = "SELECT * FROM employee WHERE employee_id=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = template.queryForObject(sql, rowMapper, id);
        return employee;
    }

    @Override
    public Employee create(Employee employee) {
        String sql = "INSERT INTO employee (employee_id, name, phone_number, user_name, password) VALUES(?,?,?,?,?)";
        template.update(sql, employee.getEmployee_id(), employee.getName(), employee.getPhone_number(),
                employee.getUser_name(), employee.getPassword());
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        String sql = "UPDATE employee SET name=?, phone_number=?, user_name=?, password=? WHERE employee_id=?";
        template.update(sql, employee.getName(), employee.getPhone_number(), employee.getUser_name(), employee.getPassword(), employee.getEmployee_id());
        Employee e = findById(employee.getEmployee_id());
        return e;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM employee WHERE employee_id=?";
        return template.update(sql, id) >= 0;
    }

    /*public boolean login(Employee employee){
        String sql = "SELECT * FROM employee WHERE user_name=? and password=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> e = template.query(sql, rowMapper, employee.getUser_name(), employee.getPassword());
        if (e.size() > 0) {
            return true;
        }else{
            return false;
        }
    }*/
}
