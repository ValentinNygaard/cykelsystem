package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.StdPartLineItem;
import com.example.cykelsystem.Repository.StdPartLineItemRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public abstract class StdPartLineItemServiceImpl implements IService<StdPartLineItem> {

    @Autowired
    StdPartLineItemRepoImpl repoImpl;

    @Override
    public List<StdPartLineItem> findAll() {
        return repoImpl.findAll();
    }

    @Override
    public StdPartLineItem findById(int id) {
        return repoImpl.findById(id);
    }

    @Override
    public StdPartLineItem create(StdPartLineItem stdPartLineItem) {
        return repoImpl.create(stdPartLineItem);
    }

    @Override
    public StdPartLineItem update(StdPartLineItem stdPartLineItem) {
        return repoImpl.update(stdPartLineItem);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }
}
