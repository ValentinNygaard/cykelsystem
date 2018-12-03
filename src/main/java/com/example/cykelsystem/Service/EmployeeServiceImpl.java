package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.Employee;
import com.example.cykelsystem.Repository.EmployeeRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IService<Employee> {

    @Autowired
    EmployeeRepoImpl employeeRepo;

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Employee findById(Employee employee) {
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
