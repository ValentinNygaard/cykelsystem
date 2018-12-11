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

    @Override
    public List<Bicycle> findAll() {
        return repoImpl.findAll();
    }

    @Override
    public Bicycle findById(int id) {
        return repoImpl.findById(id);
    }

    @Override
    public Bicycle create(Bicycle bicycle) {
        return repoImpl.create(bicycle);
    }

    @Override
    public Bicycle update(Bicycle bicycle) {
        return repoImpl.update(bicycle);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

    public List<Bicycle> findAllByCustomer(int customer_id) {return repoImpl.findAllByCustomer(customer_id);}

    public int lastId() { return repoImpl.lastId(); }
}
