package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.RepairLineItem;
import com.example.cykelsystem.Repository.RepairLineItemRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairLineItemServiceImpl implements IService<RepairLineItem> {

    @Autowired
    RepairLineItemRepoImpl repairLineItemRepo;

    @Override
    public List findAll() {
        return repairLineItemRepo.findAll();
    }

    @Override
    public RepairLineItem findById(int id) {
        return repairLineItemRepo.findById(id);
    }

    @Override
    public RepairLineItem create(RepairLineItem repairLineItem) {
        return repairLineItemRepo.create(repairLineItem);
    }

    @Override
    public RepairLineItem update(RepairLineItem repairLineItem) {
        return repairLineItemRepo.update(repairLineItem);
    }

    @Override
    public boolean delete(int id) {
        return repairLineItemRepo.delete(id);
    }
}
