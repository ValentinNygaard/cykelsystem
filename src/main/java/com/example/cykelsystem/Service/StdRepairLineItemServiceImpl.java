package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.StdRepairLineItem;
import com.example.cykelsystem.Repository.StdRepairLineItemRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StdRepairLineItemServiceImpl implements IService<StdRepairLineItem> {

    @Autowired
    StdRepairLineItemRepoImpl repoImpl;

    @Override
    public List<StdRepairLineItem> findAll() {
        return repoImpl.findAll();
    }

    @Override
    public StdRepairLineItem findById(int id) {
        return repoImpl.findById(id);
    }

    @Override
    public StdRepairLineItem create(StdRepairLineItem o) {
        return repoImpl.create(o);
    }

    @Override
    public StdRepairLineItem update(StdRepairLineItem o) {
        return repoImpl.update(o);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }
}
