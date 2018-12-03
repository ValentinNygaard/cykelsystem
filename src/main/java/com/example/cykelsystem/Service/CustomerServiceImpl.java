package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.Customer;
import com.example.cykelsystem.Repository.CustomerRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements IService<Customer> {

    @Autowired
    CustomerRepoImpl customerRepo;

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(Customer customer) {
        return null;
    }

    @Override
    public Customer create(Customer customer) {
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}