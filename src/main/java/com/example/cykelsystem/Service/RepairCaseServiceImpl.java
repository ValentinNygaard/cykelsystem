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
        return repairCaseRepo.findAll();
    }

    @Override
    public RepairCase findById(int id) {
        return repairCaseRepo.findById(id);
    }

    @Override
    public RepairCase create(RepairCase repairCase) {
        return repairCaseRepo.create(repairCase);
    }

    @Override
    public RepairCase update(RepairCase repairCase) {
        return repairCaseRepo.update(repairCase);
    }

    @Override
    public boolean delete(int id) {
        return repairCaseRepo.delete(id);
    }

    public int lastId() { return repairCaseRepo.lastId(); }
}
