package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.RepBarLine;
import com.example.cykelsystem.Repository.RepBarLineRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RepBarLineService {

    @Autowired
    RepBarLineRepoImpl repoImpl;

    public List<RepBarLine> findAll() {
        return repoImpl.findAll();
    }

    public List<RepBarLine> findAllRepBars(){return repoImpl.findAllRepbars();}

    public List<RepBarLine> findRepBarsWithStatus(int fromStatus, int toStatus){return repoImpl.findRepbarsWithStatus(fromStatus, toStatus);}

    public List<RepBarLine> findAllRepbarsDate(){
        return repoImpl.findAllRepbarsDate(getCurrentDate());
    }

    public List<RepBarLine> findRepbarsWithStatusFromDate(int fromStatus, int toStatus, String fromDate){
        return repoImpl.findRepbarsWithStatusFromDate(fromStatus, toStatus, fromDate);
    }

    public List<RepBarLine> findRepbarsWithStatusBetweenDates(int fromStatus, int toStatus, String fromDate, String toDate){
        return repoImpl.findRepbarsWithStatusBetweenDates(fromStatus, toStatus, fromDate, toDate);
    }

    //jeg ved ikke hvorfor den skal ligge her men den virker ikke når den kaldes fra service klassen
    public java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
}
