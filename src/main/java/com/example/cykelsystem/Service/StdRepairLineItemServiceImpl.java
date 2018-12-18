// Made by VN
package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.StdRepairLineItem;
import com.example.cykelsystem.Repository.StdRepairLineItemRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StdRepairLineItemServiceImpl<T extends StdRepairLineItem> implements IService<T> {

    @Autowired
    StdRepairLineItemRepoImpl repoImpl;
    // All the methods with the @Override annotation, is implemeted.

    // This method finds all objects of StdRepairLineItem
    @Override
    public List findAll() {
        return repoImpl.findAll();
    }

    // This method finds an object of StdRepairLineItem, with a specific id
    @Override
    public T findById(int id) {
        return (T) repoImpl.findById(id);
    }

    // This method creates an object of StdRepairLineItem
    @Override
    public T create(T o) {
        return (T) repoImpl.create(o);
    }

    // This method updates an object of StdRepairLineItem
    @Override
    public T update(T o) {
        return (T) repoImpl.update(o);
    }

    // This method deletes an object of StdRepairLineItem, with a specific id
    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }
}
