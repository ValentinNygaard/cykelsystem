package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.RepairCase;
import com.example.cykelsystem.Repository.RepairCaseRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairCaseServiceImpl implements IService<RepairCase> {

    @Autowired
    RepairCaseRepoImpl repairCaseRepo;

    @Override
    public List<RepairCase> findAll() {
        return null;
    }

    @Override
    public RepairCase findById(RepairCase repairCase) {
        return null;
    }

    @Override
    public RepairCase create(RepairCase repairCase) {
        return null;
    }

    @Override
    public RepairCase update(RepairCase repairCase) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
