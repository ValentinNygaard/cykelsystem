package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.StdRepairLineItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestVNController {

    @GetMapping("/bstestvn")
    public String bicycle(Model model){
        //List<StdRepairLineItem> stdRepairLineItems = srli.findAll();
        //model.addAttribute("stdRepairLineItem", stdRepairLineItems);
        return "repaircase/bstestvn";
    }
}
