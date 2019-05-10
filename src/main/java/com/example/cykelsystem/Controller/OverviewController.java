// Made by EB
package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.RepBarLine;
import com.example.cykelsystem.Service.RepBarLineService;
import com.example.cykelsystem.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
public class OverviewController {

    @Autowired
    RepBarLineService rbls;                     // We are initialising the class RepBarLineService

    ServiceService service = new ServiceService();

    /* This method is refering to the HTML site "overview", in the method we are creating a list of RepBarLIne,
     we are filling the list with a method in RepBarLineService, the method findRepBarsWithStatusFromDate.
     then we are adding the elements to a Model object, with the method addAttribute.
     after that, we are returning the HTML site. */
    @GetMapping("/overviewJens")
    public String overview(Model model) {
        String curentDate = service.getDateForToday();
        String tomorrow = service.getDateForTomorrow();
        List<RepBarLine> repBarLinesO = rbls.findRepbarsWithStatusBetweenDates(2,2, curentDate, curentDate);
        model.addAttribute("repBarLineO", repBarLinesO);
        List<RepBarLine> repBarLinesR = rbls.findRepbarsWithStatusBetweenDates(3,3, curentDate, curentDate);
        model.addAttribute("repBarLineR", repBarLinesR);
        List<RepBarLine> repBarLinesOT = rbls.findRepbarsWithStatusBetweenDates(2,2, tomorrow, tomorrow);
        model.addAttribute("repBarLineOT", repBarLinesOT);
        List<RepBarLine> repBarLinesRT = rbls.findRepbarsWithStatusBetweenDates(3,3, tomorrow, tomorrow);
        model.addAttribute("repBarLineRT", repBarLinesRT);
        List<RepBarLine> repBarLines = rbls.findRepbarsWithStatusFromDate(2, 3, service.getDateForLaterThanToday(2));
        model.addAttribute("repBarLine", repBarLines);
        return "overview/overviewJens";
    }
}
