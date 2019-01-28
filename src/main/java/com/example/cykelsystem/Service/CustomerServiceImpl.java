//Made by EB, JØ, VN

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
    // All the methods with the @Override annotation, is implemeted.

    // This method finds all objects of Costumer
    @Override
    public List<Customer> findAll() {
        return repoImpl.findAll();
    }

    // This method finds all Cosutmer objects with a specific id.
    @Override
    public Customer findById(int id) {
        return repoImpl.findById(id);
    }

    // This method creates an object of Customer
    @Override
    public Customer create(Customer customer) {
        return repoImpl.create(customer);
    }

    // This method updates an object of Customer
    @Override
    public Customer update(Customer customer) {
        return repoImpl.update(customer);
    }

    // This method deletes an object of Customer, with a specific id.
    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

    // This method finds a Customer with a specific phone_number
    public Customer findByPhone(String phone_number) {return  repoImpl.findByPhone(phone_number);}

    // This method checkes if there is a Customer object, with a phone_number
    public boolean existsByPhone(String phone_number) {return  repoImpl.existsByPhone(phone_number);}

    // this method returns the last id of all the objects of Customer
    public int lastId() { return repoImpl.lastId(); }

    public List<Customer> findByName(String name){
        String concatName ="%" + name + "%";
        return repoImpl.findByName(concatName);
    }

    public  List<Customer> findByPhoneList (String phoneNumber){
        return repoImpl.findByPhoneList(phoneNumber);
    }
}