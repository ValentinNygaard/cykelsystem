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

    public List<RepBarLine> findAll() {
        return barLineRepo.findAll();
    }

    public List<RepBarLine> findAllRepBars(){return barLineRepo.findAllRepbars();}

    public RepBarLine findById(int id) {
        return null;
    }


}
