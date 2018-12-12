package com.example.cykelsystem.Service;
import com.example.cykelsystem.Model.Customer;
import com.example.cykelsystem.Repository.CustomerRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements IService<Customer> {

    @Autowired
    CustomerRepoImpl repoImpl;

    @Override
    public List<Customer> findAll() {
        return repoImpl.findAll();
    }

    @Override
    public Customer findById(int id) {
        return repoImpl.findById(id);
    }

    @Override
    public Customer create(Customer customer) {
        return repoImpl.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return repoImpl.update(customer);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

    public Customer findByPhone(String phone_number) {return  repoImpl.findByPhone(phone_number);}

    public boolean existsByPhone(String phone_number) {return  repoImpl.existsByPhone(phone_number);}

    public int lastId() { return repoImpl.lastId(); }
}