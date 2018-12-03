package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepoImpl implements IRepo<Employee> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public  Employee findById(Employee employee) {
        return null;
    }

    @Override
    public Employee create(Employee employee) {
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
