package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.Employee;
import com.example.cykelsystem.Repository.EmployeeRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IService<Employee> {

    @Autowired
    EmployeeRepoImpl repoImpl;

    @Override
    public List<Employee> findAll() {
        return repoImpl.findAll();
    }

    @Override
    public Employee findById(int id) {
        return repoImpl.findById(id);
    }

    @Override
    public Employee create(Employee employee) {
        return repoImpl.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return repoImpl.update(employee);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

    //public boolean login(Employee employee){ return repoImpl.login(employee);}
}
