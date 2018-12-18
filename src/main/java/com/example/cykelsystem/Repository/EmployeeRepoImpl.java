// Made by EB
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

    // All the methods with the @Override annotation, is implemeted.

    /* This method finds all objects of Employee in the database
    it does this through the JdbcTemplate. */
    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql, rowMapper);

    }

    // This method finds a specific Employee with a specific employee_id.
    @Override
    public  Employee findById(int id) {
        String sql = "SELECT * FROM employee WHERE employee_id=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = template.queryForObject(sql, rowMapper, id);
        return employee;
    }

    // This method creates an object of Employee
    @Override
    public Employee create(Employee employee) {
        String sql = "INSERT INTO employee (employee_id, name, phone_number, user_name, password) VALUES(?,?,?,?,?)";
        template.update(sql, employee.getEmployee_id(), employee.getName(), employee.getPhone_number(),
                employee.getUser_name(), employee.getPassword());
        return employee;
    }

    // This method updates an object of Employee, on a specific employee_id
    @Override
    public Employee update(Employee employee) {
        String sql = "UPDATE employee SET name=?, phone_number=?, user_name=?, password=? WHERE employee_id=?";
        template.update(sql, employee.getName(), employee.getPhone_number(), employee.getUser_name(), employee.getPassword(), employee.getEmployee_id());
        Employee e = findById(employee.getEmployee_id());
        return e;
    }

    // This method deletes an Employee on a specific employee_id.
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM employee WHERE employee_id=?";
        return template.update(sql, id) >= 0;
    }

    // This method is not implemented, but we want to implement it later.
    // It checkes if there is a user_name, that mathes a password.
    public boolean login(Employee employee){
        String sql = "SELECT * FROM employee WHERE user_name=? and password=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> e = template.query(sql, rowMapper, employee.getUser_name(), employee.getPassword());
        if (e.size() > 0) {
            return true;
        }else{
            return false;
        }
    }
}
