// Made by EB
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
    RepBarLineService rbls;                     // We are initialising the class RepBarLineService

    ServiceService service = new ServiceService();

    private String currentDate = service.getDateForToday();
    /* This method is refering to the HTML site "overview", in the method we are creating a list of RepBarLIne,
     we are filling the list with a method in RepBarLineService, the method findRepBarsWithStatusFromDate.
     then we are adding the elements to a Model object, with the method addAttribute.
     after that, we are returning the HTML site. */
    @GetMapping("/overview")
    public String overview(Model model){
        List<RepBarLine> repBarLines = rbls.findRepbarsWithStatusFromDate(2,3, currentDate);
        model.addAttribute("repBarLine", repBarLines);
        return "overview/overview";
    }
}
