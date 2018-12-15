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

    public List<RepBarLine> findRepBarsWithStatus(int fromStatus, int toStatus){return repoImpl.findRepbarsWithStatus(fromStatus, toStatus);}

    public List<RepBarLine> findRepbarsWithStatusFromDate(int fromStatus, int toStatus, String fromDate){
        return repoImpl.findRepbarsWithStatusFromDate(fromStatus, toStatus, fromDate);
    }

    public List<RepBarLine> findRepbarsWithStatusBetweenDates(int fromStatus, int toStatus, String fromDate, String toDate){
        return repoImpl.findRepbarsWithStatusBetweenDates(fromStatus, toStatus, fromDate, toDate);
    }
}
