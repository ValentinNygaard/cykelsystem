package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepoImpl implements IRepo<Customer> {

    @Autowired
    JdbcTemplate template;

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
