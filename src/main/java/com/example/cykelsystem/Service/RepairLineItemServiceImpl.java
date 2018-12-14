package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.RepairLineItem;
import com.example.cykelsystem.Repository.RepairLineItemRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairLineItemServiceImpl implements IService<RepairLineItem> {

    @Autowired
    RepairLineItemRepoImpl repoImpl;

    @Override
    public List<RepairLineItem> findAll() {
        return repoImpl.findAll();
    }

    @Override
    public RepairLineItem findById(int id) {
        return repoImpl.findById(id);
    }

    @Override
    public RepairLineItem create(RepairLineItem o) {
        return repoImpl.create(o);
    }

    @Override
    public RepairLineItem update(RepairLineItem o) {
        return repoImpl.update(o);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

    public List<RepairLineItem> findByRcId(int id) {
        return repoImpl.findByRcId(id);
    }

    public double sumRepairPriceByRepairCaseId(int id) {
        return repoImpl.sumRepairPriceByRepairCaseId(id);
    }

    public int sumRepairTimeByRepairCaseId(int id) {
        return repoImpl.sumRepairTimeByRepairCaseId(id);
    }

}
