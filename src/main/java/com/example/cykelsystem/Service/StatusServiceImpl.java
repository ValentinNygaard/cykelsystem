package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.Status;
import com.example.cykelsystem.Repository.StatusRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatusServiceImpl implements IService<Status> {

    @Autowired
    StatusRepoImpl repoImpl;

    @Override
    public List<Status> findAll() { return repoImpl.findAll(); }

    @Override
    public Status findById(int id) {
        return repoImpl.findById(id);
    }

    @Override
    public Status create(Status status) {
        return repoImpl.create(status);
    }

    @Override
    public Status update(Status status) {
        return repoImpl.update(status);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }
}
