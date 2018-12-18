// Made by EPS
package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.Bicycle;
import com.example.cykelsystem.Repository.BicycleRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BicyleServiceImpl implements IService<Bicycle> {

    @Autowired
    BicycleRepoImpl repoImpl;
    // All the methods with the @Override annotation, is implemeted.

    // This method finds all objects of Bicycle
    @Override
    public List<Bicycle> findAll() {
        return repoImpl.findAll();
    }

    // This method finds an object of bicycle with a specicif id
    @Override
    public Bicycle findById(int id) {
        return repoImpl.findById(id);
    }

    // This method creates a new object of Bicycle
    @Override
    public Bicycle create(Bicycle bicycle) {
        return repoImpl.create(bicycle);
    }

    // This method updates an object of Bicycle
    @Override
    public Bicycle update(Bicycle bicycle) {
        return repoImpl.update(bicycle);
    }

    // This method delets an object of Bicycle with a specific id
    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

    // This method finds all objects of Bicycle with a specific customer_id
    public List<Bicycle> findAllByCustomer(int customer_id) {return repoImpl.findAllByCustomer(customer_id);}

    // This method gives us the last id of the objects.
    public int lastId() { return repoImpl.lastId(); }
}
