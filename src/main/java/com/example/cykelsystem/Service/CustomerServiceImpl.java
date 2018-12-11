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
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepo.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepo.update(customer);
    }

    @Override
    public boolean delete(int id) {
        return customerRepo.delete(id);
    }

    public Customer findByPhone(String phone_number) {return  customerRepo.findByPhone(phone_number);}

    public boolean existsByPhone(String phone_number) {return  customerRepo.existsByPhone(phone_number);}
}