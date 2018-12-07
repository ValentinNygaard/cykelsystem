package com.example.cykelsystem.Service;
import com.example.cykelsystem.Model.PartLineItem;
import com.example.cykelsystem.Repository.PartLineItemRepoImlp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartLineItemServiceImpl implements IService<PartLineItem> {
    @Autowired
    PartLineItemRepoImlp pliRepo;

    @Override
    public List<PartLineItem> findAll() {
        return pliRepo.findAll();
    }

    @Override
    public PartLineItem findById(int id) {
        return pliRepo.findById(id);
    }

    @Override
    public PartLineItem create(PartLineItem partLineItem) {
        return pliRepo.create(partLineItem);
    }

    @Override
    public PartLineItem update(PartLineItem partLineItem) {
        return pliRepo.update(partLineItem);
    }

    @Override
    public boolean delete(int id) {
        return pliRepo.delete(id);
    }
}
