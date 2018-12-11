package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        String sql = "INSERT INTO customer (customer_id, phone_number, name) VALUES(?,?,?)";
        template.update(sql, customer.getCustomer_id(), customer.getPhone_number(), customer.getName());
        /*String sql2 ="SELECT LAST_INSERT_ID()";
        int id = template.update(sql2);
        System.out.println(id);*/
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        String sql = "UPDATE customer SET name=?, phone_number=? WHERE customer_id=?";
        template.update(sql,customer.getName(),customer.getPhone_number(), customer.getCustomer_id());
        Customer c = findById(customer.getCustomer_id());
        return customer;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM customer WHERE customer_id=?";
        return  template.update(sql, id) >= 0;
    }

    public Customer findByPhone(String phone_number){
        String sql = "SELECT * FROM customer WHERE phone_number=?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        try {
            return template.queryForObject(sql, rowMapper, phone_number);
        }catch (EmptyResultDataAccessException e){
            Customer c = new Customer();
            return c;
        }
    }

    public boolean existsByPhone(String phone_number) {
        String sql ="SELECT * FROM customer WHERE phone_number=?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return (template.query(sql, rowMapper, phone_number).size()>0);
    }

   /* public static void main(String[] args) {
        Customer repairCase = new Customer(0, "27344566", "id test");
        CustomerRepoImpl repo = new CustomerRepoImpl();
        repo.create(repairCase);
    }*/
}
