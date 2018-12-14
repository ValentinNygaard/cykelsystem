package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.RepairCase;
import com.example.cykelsystem.Repository.RepairCaseRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RepairCaseServiceImpl implements IService<RepairCase> {

    @Autowired
    RepairCaseRepoImpl repoImpl;

    @Override
    public List<RepairCase> findAll() {
        return repoImpl.findAll();
    }

    @Override
    public RepairCase findById(int id) {
        return repoImpl.findById(id);
    }

    @Override
    public RepairCase create(RepairCase repairCase) {
        return repoImpl.create(repairCase);
    }

    @Override
    public RepairCase update(RepairCase repairCase) {
        return repoImpl.update(repairCase);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

    public int lastId() { return repoImpl.lastId(); }

    public int lastRepairNumber() { return repoImpl.lastRepairNumber(); }

    public List<RepairCase> findAllByBicycleId(int id) { return repoImpl.findAllByBicycleId(id); }
}
