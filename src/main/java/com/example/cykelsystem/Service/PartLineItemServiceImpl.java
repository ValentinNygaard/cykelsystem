package com.example.cykelsystem.Service;
import com.example.cykelsystem.Model.PartLineItem;
import com.example.cykelsystem.Repository.PartLineItemRepoImlp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartLineItemServiceImpl implements IService<PartLineItem> {

    @Autowired
    PartLineItemRepoImlp repoImpl;
    // All the methods with the @Override annotation, is implemeted.

    // This method finds all objects of PartLineItem
    @Override
    public List<PartLineItem> findAll() {
        return repoImpl.findAll();
    }

    // This method find an object of PartLineItem with a specific id
    @Override
    public PartLineItem findById(int id) {
        return repoImpl.findById(id);
    }

    // This method creates an object of PartLineItem
    @Override
    public PartLineItem create(PartLineItem partLineItem) {
        return repoImpl.create(partLineItem);
    }

    // This method updates an object of PartLineItem
    @Override
    public PartLineItem update(PartLineItem partLineItem) {
        return repoImpl.update(partLineItem);
    }

    // This method deletes an object of PartLineItem with a specifc id
    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

    // This method finds an object with a specific RepairCaseId
    public List<PartLineItem> findByRcId(int id) {
        return repoImpl.findByRcId(id);
    }

}
