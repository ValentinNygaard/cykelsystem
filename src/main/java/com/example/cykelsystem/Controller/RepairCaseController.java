package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.RepairCase;
import com.example.cykelsystem.Service.RepairCaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RepairCaseController {

    @Autowired
    RepairCaseServiceImpl rcsi;

    @GetMapping("/repaircase")
    public String repairCase(Model model){
        List<RepairCase> repairCases = rcsi.findAll();
        model.addAttribute("repairCase", repairCases);
        return "repaircase/repaircase";
    }

    @GetMapping("/detailsRepairCase/{id}")
    public String detailsrepaircase(@PathVariable("id")int id, Model model){
        model.addAttribute("repairCase", rcsi.findById(id));
        return "repaircase/detailsrepaircase";
    }

    @GetMapping("/deleteRepairCase/{id}")
    public String deleteRepairCase(@PathVariable("id")int id)
    {
        boolean deleted = rcsi.delete(id);
        if(deleted) {
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/updateRepairCase/{id}")
    public String updateRepairCase(@PathVariable("id")int id, Model model) {
        model.addAttribute("repairCase",rcsi.findById(id));
        return "repaircase/updaterepaircase";
    }

    @PostMapping("/updateRepairCase")
    public String updateRepairCase(@ModelAttribute RepairCase repairCase){
        rcsi.update(repairCase);
        return "redirect:/";
    }

    @PostMapping("/createRepairCase")
    public String createRepairCase(@ModelAttribute RepairCase repairCase){
        rcsi.create(repairCase);
        return "redirect:/";
    }
}
