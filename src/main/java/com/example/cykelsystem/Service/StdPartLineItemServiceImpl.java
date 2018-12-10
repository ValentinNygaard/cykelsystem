package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.StdPartLineItem;
import com.example.cykelsystem.Repository.StdPartLineItemRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StdPartLineItemServiceImpl<T extends StdPartLineItem> implements IService<T> {

    @Autowired
    StdPartLineItemRepoImpl repoImpl;

    @Override
    public List findAll() {
        return repoImpl.findAll();
    }

    @Override
    public T findById(int id) {
        return (T) repoImpl.findById(id);
    }

    @Override
    public T create(T o) {
        return (T) repoImpl.create(o);
    }

    @Override
    public T update(T o) {
        return (T) repoImpl.update(o);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }
}
