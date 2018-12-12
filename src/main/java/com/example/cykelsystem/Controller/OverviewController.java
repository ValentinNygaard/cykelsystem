package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.RepBarLine;
import com.example.cykelsystem.Service.RepBarLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OverviewController {

    @Autowired
    RepBarLineService rbls;

    @GetMapping("/overview")
    public String overview(Model model){
        List<RepBarLine> repBarLines = rbls.findAllRepbarsDate();
        model.addAttribute("repBarLine", repBarLines);
        return "overview/overview";
    }
}
