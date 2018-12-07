package com.example.cykelsystem.Controller;


import com.example.cykelsystem.Model.RepBarLine;
import com.example.cykelsystem.Service.RepBarLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    RepBarLineService rbls;

   /*@GetMapping("/")
    public String home(Model model){
       return "home/index";
    }*/


    @GetMapping("/")
    public String home(Model model){
        List<RepBarLine> repbarlines = rbls.findAllRepbarsDate();
        model.addAttribute("repBarLine", repbarlines);
        System.out.println(java.sql.Date.valueOf(LocalDate.now()));
        return "bootstrapemilie/bootstraptest";
    }
}
