package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.StdPartItemLine;
import com.example.cykelsystem.Repository.StdPartLineItemRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public abstract class StdBicyclepartLineItemService implements IService<StdPartItemLine> {

    @Autowired
    StdPartLineItemRepoImpl repoImpl;

    @Override
    public List<StdPartItemLine> findAll() {
        return repoImpl.findAll();
    }

    @Override
    public StdPartItemLine findById(int id) {
        return repoImpl.findById(id);
    }

    @Override
    public StdPartItemLine create(StdPartItemLine stdPartLineItem) {
        return repoImpl.create(stdPartLineItem);
    }

    @Override
    public StdPartItemLine update(StdPartItemLine stdPartLineItem) {
        return repoImpl.update(stdPartLineItem);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }
}
