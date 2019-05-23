// Made by EB
package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.Employee;
import com.example.cykelsystem.Model.RepBarLine;
import com.example.cykelsystem.Model.Status;
import com.example.cykelsystem.Service.EmployeeServiceImpl;
import com.example.cykelsystem.Service.RepBarLineService;
import com.example.cykelsystem.Service.ServiceService;
import com.example.cykelsystem.Service.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
public class OverviewController {

    @Autowired
    RepBarLineService rbls;                     // We are initialising the class RepBarLineService

    @Autowired
    StatusServiceImpl ss;

    @Autowired
    EmployeeServiceImpl esi;

    ServiceService service = new ServiceService();

    /* This method is refering to the HTML site "overview", in the method we are creating a list of RepBarLIne,
     we are filling the list with a method in RepBarLineService, the method findRepBarsWithStatusFromDate.
     then we are adding the elements to a Model object, with the method addAttribute.
     after that, we are returning the HTML site. */
    @GetMapping("/overview")
    public String overview(Model model) {
        String day0 = service.getDateForToday();
        String day1 = service.getDateForTomorrow();
        String day2 = service.getDateForLaterThanToday(2);
        String day3 = service.getDateForLaterThanToday(3);
        String day4 = service.getDateForLaterThanToday(4);

        List<Status> statusList = ss.findAll();
        model.addAttribute("status", statusList);

        List<RepBarLine> repBarLinesD0 = rbls.findRepbarsWithStatusBetweenDates(1,3, day0, day0);
        model.addAttribute("repBarLineD0", repBarLinesD0);
        List<RepBarLine> repBarLinesFD0 = rbls.findRepbarsWithStatusBetweenDates(4,4, day0, day0);
        model.addAttribute("repBarLineFD0", repBarLinesFD0);

        List<RepBarLine> repBarLinesD1 = rbls.findRepbarsWithStatusBetweenDates(1,3, day1, day1);
        model.addAttribute("repBarLineD1", repBarLinesD1);
        List<RepBarLine> repBarLinesFD1 = rbls.findRepbarsWithStatusBetweenDates(4,4, day1, day1);
        model.addAttribute("repBarLineFD1", repBarLinesFD1);

        List<RepBarLine> repBarLinesD2 = rbls.findRepbarsWithStatusBetweenDates(1,3, day2, day2);
        model.addAttribute("repBarLineD2", repBarLinesD2);
        List<RepBarLine> repBarLinesFD2 = rbls.findRepbarsWithStatusBetweenDates(4,4, day2, day2);
        model.addAttribute("repBarLineFD2", repBarLinesFD2);

        List<RepBarLine> repBarLinesD3 = rbls.findRepbarsWithStatusBetweenDates(1,3, day3, day3);
        model.addAttribute("repBarLineD3", repBarLinesD3);
        List<RepBarLine> repBarLinesFD3 = rbls.findRepbarsWithStatusBetweenDates(4,4, day3, day3);
        model.addAttribute("repBarLineFD3", repBarLinesFD3);

        List<RepBarLine> repBarLinesD4 = rbls.findRepbarsWithStatusBetweenDates(1,3, day4, day4);
        model.addAttribute("repBarLineD4", repBarLinesD4);
        List<RepBarLine> repBarLinesFD4 = rbls.findRepbarsWithStatusBetweenDates(4,4, day4, day4);
        model.addAttribute("repBarLineFD4", repBarLinesFD4);

        List<RepBarLine> repBarLines = rbls.findRepbarsWithStatusFromDate(1, 4, service.getDateForLaterThanToday(2));
        model.addAttribute("repBarLine", repBarLines);
        return "overview/overview";
    }
}
