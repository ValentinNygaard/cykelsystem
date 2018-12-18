// Made VN
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
    // All the methods with the @Override annotation, is implemeted.

    // This method finds all objects of RepairLineItem
    @Override
    public List<RepairLineItem> findAll() {
        return repoImpl.findAll();
    }

    // This method finds an object of RepairLineItem with a specific id
    @Override
    public RepairLineItem findById(int id) {
        return repoImpl.findById(id);
    }

    // This method creates an object of RepairLineItem
    @Override
    public RepairLineItem create(RepairLineItem o) {
        return repoImpl.create(o);
    }

    // This method updates an object of RepairLineItem
    @Override
    public RepairLineItem update(RepairLineItem o) {
        return repoImpl.update(o);
    }

    // This method deletes an object of RepairLineItem, with a specific id
    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

    // This method finds all objects of RepairLineItem, with a specific RepairCaseId.
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
