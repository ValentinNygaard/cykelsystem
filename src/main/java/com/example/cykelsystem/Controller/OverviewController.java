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
    RepBarLineService rbls;

    ServiceService service;

    @GetMapping("/overview")
    public String overview(Model model){
        //List<RepBarLine> repBarLines = rbls.findAll();
        List<RepBarLine> repBarLines = rbls.findRepbarsWithStatusFromDate(1,6, "2017-12-01");
        model.addAttribute("repBarLine", repBarLines);
        return "overview/overview";
    }
}
