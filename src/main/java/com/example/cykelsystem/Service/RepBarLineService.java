package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.RepBarLine;
import com.example.cykelsystem.Repository.RepBarLineRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepBarLineService implements IService<RepBarLine>{

    @Autowired
    RepBarLineRepoImpl repBarLineRepoImpl;

    @Override
    public List<RepBarLine> findAll() {
        return repBarLineRepoImpl.findAll();
    }

    @Override
    public RepBarLine findById(int id) {
        return null;
    }

    @Override
    public RepBarLine create(RepBarLine repBarLine) {
        return null;
    }

    @Override
    public RepBarLine update(RepBarLine repBarLine) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
