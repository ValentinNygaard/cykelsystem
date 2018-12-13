package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.RepBarLine;
import com.example.cykelsystem.Repository.RepBarLineRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RepBarLineService {

    @Autowired
    RepBarLineRepoImpl barLineRepo;

    ServiceService service;

    public List<RepBarLine> findAll() {
        return barLineRepo.findAll();
    }

    public List<RepBarLine> findAllRepBars(){return barLineRepo.findAllRepbars();}

    public List<RepBarLine> findAllRepbarsDate(){
        return barLineRepo.findAllRepbarsDate(getCurrentDate());
    }

    //jeg ved ikke hvorfor den skal ligge her men den virker ikke når den kaldes fra service klassen
    public java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
}
