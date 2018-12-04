package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.Bicycle;
import com.example.cykelsystem.Repository.BicycleRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BicyleServiceImpl implements IService<Bicycle> {

    @Autowired
    BicycleRepoImpl bicycleRepo;

    @Override
    public List<Bicycle> findAll() {
        return bicycleRepo.findAll();
    }

    @Override
    public Bicycle findById(int id) {
        return bicycleRepo.findById(id);
    }

    @Override
    public Bicycle create(Bicycle bicycle) {
        return bicycleRepo.create(bicycle);
    }

    @Override
    public Bicycle update(Bicycle bicycle) {
        return bicycleRepo.update(bicycle);
    }

    @Override
    public boolean delete(int id) {
        return bicycleRepo.delete(id);
    }
}
