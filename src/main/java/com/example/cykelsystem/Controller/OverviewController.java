package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.RepBarLine;
import com.example.cykelsystem.Service.RepBarLineService;
import com.example.cykelsystem.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OverviewController {

    @Autowired
    RepBarLineService rbls;                      // Her opretter vi et objekt af RepBarLineService
    ServiceService service;                     //Overflødig?

    /* This method is refering to the HTML site "overview", in the method we are creating a list of RepBarLIne,
     we are filling the list with a method in RepBarLineService, the method findRepBarsWithStatusFromDate.
     then we are adding the elements to a Model object, with the method addAttribute.
     after that, we are returning the HTML site. */
    @GetMapping("/overview")
    public String overview(Model model){
        List<RepBarLine> repBarLinesO = rbls.findRepbarsWithStatusFromDate(2,2, "2017-12-01");
        model.addAttribute("repBarLineO", repBarLinesO);
        List<RepBarLine> repBarLinesR = rbls.findRepbarsWithStatusFromDate(3,3, "2017-12-01");
        model.addAttribute("repBarLineR", repBarLinesR);
        List<RepBarLine> repBarLinesA = rbls.findRepbarsWithStatusFromDate(4,4, "2017-12-01");
        model.addAttribute("repBarLineA", repBarLinesA);
        List<RepBarLine> repBarLinesU = rbls.findRepbarsWithStatusFromDate(1,1, "2017-12-01");
        model.addAttribute("repBarLineU", repBarLinesU);
        List<RepBarLine> repBarLinesP = rbls.findRepbarsWithStatusFromDate(6,6, "2017-12-01");
        model.addAttribute("repBarLineP", repBarLinesP);
        List<RepBarLine> repBarLinesK = rbls.findRepbarsWithStatusFromDate(5,5, "2017-12-01");
        model.addAttribute("repBarLineK", repBarLinesK);
        return "overview/overview";
    }
}
