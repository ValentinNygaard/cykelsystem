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
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepo.findById(id);
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepo.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepo.update(employee);
    }

    @Override
    public boolean delete(int id) {
        return employeeRepo.delete(id);
    }

    public boolean login(Employee employee){ return employeeRepo.login(employee);}
}
