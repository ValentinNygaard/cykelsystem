package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.StdBicyclepartLineItem;
import com.example.cykelsystem.Repository.StdBicylepartLineItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public abstract class StdBicyclepartLineItemService implements IService<StdBicyclepartLineItem> {

    @Autowired
    StdBicylepartLineItemRepo repoImpl;

    @Override
    public List<StdBicyclepartLineItem> findAll() {
        return repoImpl.findAll();
    }

    @Override
    public StdBicyclepartLineItem findById(int id) {
        return repoImpl.findById(id);
    }

    @Override
    public StdBicyclepartLineItem create(StdBicyclepartLineItem stdBicyclepartLineItem) {
        return repoImpl.create(stdBicyclepartLineItem);
    }

    @Override
    public StdBicyclepartLineItem update(StdBicyclepartLineItem stdBicyclepartLineItem) {
        return repoImpl.update(stdBicyclepartLineItem);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }
}
