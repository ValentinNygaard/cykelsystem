package com.example.cykelsystem.Service;

import com.example.cykelsystem.Repository.BicycleRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BicyleServiceImpl implements IService {

    @Autowired
    BicycleRepoImpl bicycleRepo; //Tjek om det skal være interfacet, det er det i filmen, men her er der jo flere implementationer

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object findById(Object object) {
        return null;
    }

    @Override
    public Object create(Object object) {
        return null;
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
