// Made by EB
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
    // All the methods with the @Override annotation, is implemeted.

    // This method finds all objects of Employee
    @Override
    public List<Employee> findAll() {
        return repoImpl.findAll();
    }

    // This method finds all Employee objects with a specific id.
    @Override
    public Employee findById(int id) {
        return repoImpl.findById(id);
    }

    // This method creates an object of Employee, with a specific id.
    @Override
    public Employee create(Employee employee) {
        return repoImpl.create(employee);
    }

    // This method updates an object of Employee, with a specific id.
    @Override
    public Employee update(Employee employee) {
        return repoImpl.update(employee);
    }

    // This method deletes an object of Employee, with a specific id.
    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

    public List<Employee> findAllActive(){
        return repoImpl.findAllActive();
    }

    //public boolean login(Employee employee){ return repoImpl.login(employee);}
}
