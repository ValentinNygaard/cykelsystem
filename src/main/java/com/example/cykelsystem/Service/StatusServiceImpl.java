package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.Status;
import com.example.cykelsystem.Repository.StatusRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatusServiceImpl implements IService<Status> {

    @Autowired
    StatusRepoImpl statusRepoImpl;

    @Override
    public List<Status> findAll() {
        return statusRepoImpl.findAll();
    }

    @Override
    public Status findById(int id) {
        return statusRepoImpl.findById(id);
    }

    @Override
    public Status create(Status status) {
        return statusRepoImpl.create(status);
    }

    @Override
    public Status update(Status status) {
        return statusRepoImpl.update(status);
    }

    @Override
    public boolean delete(int id) {
        return statusRepoImpl.delete(id);
    }
}
