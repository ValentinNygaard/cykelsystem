package com.example.cykelsystem.Controller;
import com.example.cykelsystem.Model.*;
import com.example.cykelsystem.Repository.*;
import com.example.cykelsystem.Service.StdPartLineItemServiceImpl;
import com.example.cykelsystem.Service.StdRepairLineItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class SettingsController {


    @Autowired
    StdPartLineItemServiceImpl stdPartLineItemService;

    @Autowired
    StdRepairLineItemServiceImpl stdRepairLineItemService;


    @GetMapping("/settings")
    public String settings(Model model){
        List<StdPartLineItem> stdPartLineItem = stdPartLineItemService.findAll();
        List<StdRepairLineItem> stdRepairLineItems = stdRepairLineItemService.findAll();
        model.addAttribute("stdPartLineItem", stdPartLineItem);
        model.addAttribute("stdRepairLineItem", stdRepairLineItems);
        return "settings/settings";
    }

    @PostMapping("/updateStdPartLineItem/{id}")
    public String updateStdPartLineItem(@ModelAttribute StdPartLineItem stdPartLineItem){
        stdPartLineItemService.update(stdPartLineItem);
        return "redirect:/settings";
    }

    @PostMapping("/updateStdRepairLineItem/{id}")
    public String updateStdRepairLineItem(@ModelAttribute StdRepairLineItem stdRepairLineItem) {
        stdRepairLineItemService.update(stdRepairLineItem);
        return "redirect:/settings";
    }

    //samme metode som ovenover, bør slettes
    @PostMapping("/updateStdRepairlineitem")
    public String updateStdRepairLine(@ModelAttribute StdRepairLineItem stdRepairLineItem){
        stdRepairLineItemService.update(stdRepairLineItem);
        return "redirect:/settings";
    }

    @PostMapping("/createStdPartLineItem")
    public String createStdPartLineItem(@ModelAttribute StdPartLineItem stdPartLineItem){
        stdPartLineItemService.create(stdPartLineItem);
        return "redirect:/settings";
    }

    @PostMapping("/createStdRepairLineItem")
    public String createStdRepairLineItem(@ModelAttribute StdRepairLineItem StdRepairLineItem){
        stdRepairLineItemService.create(StdRepairLineItem);
        return "redirect:/settings";
    }

    @GetMapping("/deleteStdPartLineItem/{id}")
    public String deleteStdPartLineItem(@PathVariable("id")int id)
    {
        boolean deleted = stdPartLineItemService.delete(id);
        if(deleted) {
            return "redirect:/settings";
        }
        else{
            return "redirect:/settings";
        }
    }

    @GetMapping("/deleteStdRepairLineItem/{id}")
    public String deleteStdRepairLineItem(@PathVariable("id")int id)
    {
        boolean deleted = stdRepairLineItemService.delete(id);
        if(deleted) {
            return "redirect:/settings";
        }
        else{
            return "redirect:/settings";
        }
    }
}
