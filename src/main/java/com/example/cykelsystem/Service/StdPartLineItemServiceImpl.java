//Made by EPS

package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.StdPartLineItem;
import com.example.cykelsystem.Repository.StdPartLineItemRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StdPartLineItemServiceImpl implements IService<StdPartLineItem> {

    @Autowired
    StdPartLineItemRepoImpl repoImpl;

    // All the methods with the @Override annotation, is implemeted.

    // This method finds all objects of StdPartLineItem
    @Override
    public List<StdPartLineItem> findAll() {
        return repoImpl.findAll();
    }

    // this method finds an object of StdPartLineItem, with a specific id
    @Override
    public StdPartLineItem findById(int id) {
        return repoImpl.findById(id);
    }

    // This method creates an object of StdPartLineItem
    @Override
    public StdPartLineItem create(StdPartLineItem o) {
        return repoImpl.create(o);
    }

    // This method updates an objecet of StdPartLineItem
    @Override
    public StdPartLineItem update(StdPartLineItem o) {
        return repoImpl.update(o);
    }

    // This method deletes an object of StdPartLineItem, with a specific id
    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }
}
