package com.example.cykelsystem.Service;

import com.example.cykelsystem.Repository.RepairLineItemRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairLineItemServiceImpl implements IService {

    @Autowired
    RepairLineItemRepoImpl repairLineItemRepo;

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
