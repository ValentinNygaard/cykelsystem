package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatusRepoImpl implements IRepo<Status> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Status> findAll() {
        return null;
    }

    @Override
    public Status findById(Status Status) {
        return null;
    }

    @Override
    public Status create(Status Status) {
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
