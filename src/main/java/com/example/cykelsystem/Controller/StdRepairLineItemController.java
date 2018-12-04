package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.StdRepairLineItem;
import com.example.cykelsystem.Service.StdRepairLineItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StdRepairLineItemController {

    @Autowired
    StdRepairLineItemServiceImpl srli;

    @GetMapping("/viewStdRepairLineItem/{id}")
    public String viewStdRepairLineItem(@PathVariable("id")int id, Model model){
        model.addAttribute("stdRep", srli.findById(id));
        return "detailssrli";
    }

    @GetMapping("/deleteStdRepairLineItem/{id}")
    public String deleteStdRepairLineItem(@PathVariable("id")int id)
    {
        boolean deleted = srli.delete(id);
        if(deleted) {
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/updateStdRepairLineItem/{id}")
    public String updateStatus(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("stdRep",srli.findById(id));
        return "updatesrli";
    }

    @PostMapping("/updateStdRepairLineItem")
    public String updateStatus(@ModelAttribute StdRepairLineItem stdRep){
        srli.update(stdRep);
        return "redirect:/";
    }

    @PostMapping("/createStdRepairLineItem")
    public String createStatus(@ModelAttribute StdRepairLineItem stdRep){
        srli.create(stdRep);
        return "redirect:/";
    }
}
