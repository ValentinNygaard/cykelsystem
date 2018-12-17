//Made by EPS

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

    // This method finds objects of RepBarLine, with a status_id within a range
    public List<RepBarLine> findRepBarsWithStatus(int fromStatus, int toStatus){return repoImpl.findRepbarsWithStatus(fromStatus, toStatus);}

    // This method finds objects of RepBarLine, with status_id within a range. And from a specific date
    public List<RepBarLine> findRepbarsWithStatusFromDate(int fromStatus, int toStatus, String fromDate){
        return repoImpl.findRepbarsWithStatusFromDate(fromStatus, toStatus, fromDate);
    }

    // This method finds objects of RepBarLine, with status_id within a range. And within a range of dates
    public List<RepBarLine> findRepbarsWithStatusBetweenDates(int fromStatus, int toStatus, String fromDate, String toDate){
        return repoImpl.findRepbarsWithStatusBetweenDates(fromStatus, toStatus, fromDate, toDate);
    }
}
