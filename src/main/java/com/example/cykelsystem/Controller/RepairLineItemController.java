package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.RepairLineItem;
import com.example.cykelsystem.Service.RepairLineItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RepairLineItemController {

    @Autowired
    RepairLineItemServiceImpl rli;

    @GetMapping("/viewRepairLineItem/{id}")
    public String viewRepairLineItem(@PathVariable("id")int id, Model model){
        model.addAttribute("stdRep", rli.findById(id));
        return "viewrepairli";
    }

    @GetMapping("/deleteRepairLineItem/{id}")
    public String deleteRepairLineItem(@PathVariable("id")int id)
    {
        boolean deleted = rli.delete(id);
        if(deleted) {
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/updateRepairLineItem/{id}")
    public String updateStatus(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("stdRep",rli.findById(id));
        return "updaterepairli";
    }

    @PostMapping("/updateRepairLineItem")
    public String updateStatus(@ModelAttribute RepairLineItem repLinep){
        rli.update(repLinep);
        return "redirect:/";
    }

    @PostMapping("/createRepairLineItem")
    public String createStatus(@ModelAttribute RepairLineItem repLine){
        rli.create(repLine);
        return "redirect:/";
    }
}
