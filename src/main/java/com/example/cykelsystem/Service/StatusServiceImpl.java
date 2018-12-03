package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements IService<Status> {

    @Autowired
    StatusServiceImpl statusService;

    @Override
    public List<Status> findAll() {
        return null;
    }

    @Override
    public Status findById(Status status) {
        return null;
    }

    @Override
    public Status create(Status status) {
        return null;
    }

    @Override
    public Status update(Status status) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
