package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepoImpl implements IRepo<Customer> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public Customer findById(int id) {
        String sql ="SELECT * FROM customer WHERE customer_id=?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    @Override
    public Customer create(Customer customer) {
        String sql = "INCERT INTO customer (customer_id, phone_number, name) VALUES(?,?,?)";
        template.update(sql, customer.getCustomer_id(), customer.getName(), customer.getPhone_number());
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        String sql = "UPDATE customer SET name=? AND SET phone_number=? WHERE status_id=?";
        template.update(sql, customer.getCustomer_id(), customer.getPhone_number(),customer.getName());
        Customer c = findById(customer.getCustomer_id());
        return customer;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE * FROM customer WHERE customer_id=?";
        return  template.update(sql, id) >= 0;
    }
}
