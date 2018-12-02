package com.example.cykelsystem.Service;

import com.example.cykelsystem.Repository.CustomerRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements IService {

    @Autowired
    CustomerRepoImpl customerRepo;

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