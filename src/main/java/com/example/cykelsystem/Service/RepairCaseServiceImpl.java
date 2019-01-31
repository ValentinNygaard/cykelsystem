//Made by EPS, VN

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
    // All the methods with the @Override annotation, is implemeted.

    // This method finds all objects of RepairCase
    @Override
    public List<RepairCase> findAll() {
        return repairCaseRepo.findAll();
    }

    // This method finds an object of RepairCase, with a specific id
    @Override
    public RepairCase findById(int id) {
        return repairCaseRepo.findById(id);
    }

    // This method creates an object of RepairCase
    @Override
    public RepairCase create(RepairCase repairCase) {
        return repairCaseRepo.create(repairCase);
    }

    // This method updates an object of RepairCase
    @Override
    public RepairCase update(RepairCase repairCase) {
        return repairCaseRepo.update(repairCase);
    }

    // This method deletes an object of RepairCase, with a specific id
    @Override
    public boolean delete(int id) {
        return repairCaseRepo.delete(id);
    }

    // This method returns the last id of all the objects of RepairCase
    public int lastId() { return repairCaseRepo.lastId(); }

    // This method returns the last RepairNumber of all the objects of RepairCase
    public int lastRepairNumber() { return repairCaseRepo.lastRepairNumber(); }

    public Integer getTotalPriceOnRepairCaseId(int id){
        return repairCaseRepo.getTotalPriceOnRepairCaseId(id);
    }

    public  Integer getTotalTimeOnRepairCaseId(int id){
        return repairCaseRepo.getTotalTimeOnRepairCaseId(id);
    }
}
