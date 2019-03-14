//Made by JØ, EB

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

    // All the methods with the @Override annotation, is implemeted.

    /* This method finds all objects of Customer in the database
    it does this through the JdbcTemplate. */
    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }


    // This method returns a Customer with a specific id.
    @Override
    public Customer findById(int id) {
        String sql ="SELECT * FROM customer WHERE customer_id=?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    // This method creates a new object of Customer
    @Override
    public Customer create(Customer customer) {
        String sql = "INSERT INTO customer (customer_id, phone_number, name) VALUES(?,?,?)";
        template.update(sql, customer.getCustomer_id(), customer.getPhone_number(), customer.getName());
        return customer;
    }

    // This method updates a specific Comment with a specific repair_case_id.
    @Override
    public Customer update(Customer customer) {
        String sql = "UPDATE customer SET name=?, phone_number=? WHERE customer_id=?";
        template.update(sql,customer.getName(),customer.getPhone_number(), customer.getCustomer_id());
        Customer c = findById(customer.getCustomer_id());
        return customer;
    }

    // This method deletes a comment,
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM customer WHERE customer_id=?";
        return  template.update(sql, id) >= 0;
    }

    // Finds a Customer with a specific phone_number
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

    // er den her nødvendig?? samme som tidligere metode?
    public boolean existsByPhone(String phone_number) {
        String sql ="SELECT * FROM customer WHERE phone_number=?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return (template.query(sql, rowMapper, phone_number).size()>0);
    }

    // This method returns the last id, of all the objects of Customer
    public int lastId() {
        String sql2 ="SELECT LAST_INSERT_ID()";
        Integer id = (template.queryForObject(sql2, Integer.class));
        return id.intValue();
    }

    public List<Customer> findByName(String name){
        String sql = "SELECT * from customer WHERE name LIKE ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper, name);
    }

    public List<Customer> findByPhoneList(String phone_number){
        String sql = "SELECT * FROM customer WHERE phone_number=?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper, phone_number);
    }
}
