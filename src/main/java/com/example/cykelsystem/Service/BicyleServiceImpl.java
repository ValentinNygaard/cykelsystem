package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.Bicycle;
import com.example.cykelsystem.Repository.BicycleRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BicyleServiceImpl implements IService<Bicycle> {

    @Autowired
    BicycleRepoImpl bicycleRepo; //Tjek om det skal være interfacet, det er det i filmen, men her er der jo flere implementationer

    @Override
    public List<Bicycle> findAll() {
        return null;
    }

    @Override
    public Bicycle findById(int id) {
        return null;
    }

    @Override
    public Bicycle create(Bicycle bicycle) {
        return null;
    }

    @Override
    public Bicycle update(Bicycle bicycle) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
