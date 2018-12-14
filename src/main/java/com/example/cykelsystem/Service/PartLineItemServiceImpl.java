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

    @Override
    public List<PartLineItem> findAll() {
        return repoImpl.findAll();
    }

    @Override
    public PartLineItem findById(int id) {
        return repoImpl.findById(id);
    }

    @Override
    public PartLineItem create(PartLineItem partLineItem) {
        return repoImpl.create(partLineItem);
    }

    @Override
    public PartLineItem update(PartLineItem partLineItem) {
        return repoImpl.update(partLineItem);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

    public List<PartLineItem> findByRcId(int id) {
        return repoImpl.findByRcId(id);
    }

    public double sumPartPriceByRepairCaseId(int id) {
        return repoImpl.sumPartPriceByRepairCaseId(id);
    }

}
