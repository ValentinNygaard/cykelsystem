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

    // All the methods with the @Override annotation, is implemeted.

    // This method finds all objects of Status
    @Override
    public List<Status> findAll() { return repoImpl.findAll(); }

    // This method finds an object of Status with a specific id
    @Override
    public Status findById(int id) {
        return repoImpl.findById(id);
    }

    // This method creates an object of Status
    @Override
    public Status create(Status status) {
        return repoImpl.create(status);
    }

    // This method updates an object of Status
    @Override
    public Status update(Status status) {
        return repoImpl.update(status);
    }

    // This method deletes an object of Status, with a specific id
    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }
}
