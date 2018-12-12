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

    @GetMapping("/updateStdPartLineItemFromSettings/{id}")
    public String updateStdPartLineItemFromSettings(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("stdPartLineItem", stdPartLineItemService.findById(id));
        return "settings/updatestdpartlineitemJens";
    }

    @PostMapping("/updateStdPartLineItemFromSettings")
    public String updateCustomer(@ModelAttribute StdPartLineItem stdPartLineItem){
        stdPartLineItemService.update(stdPartLineItem);
        return "redirect:/settings";
    }

    @GetMapping("/updateStdRepairLineItemFromSettings/{id}")
    public String updateStdRepairLineItemFromSettings(@PathVariable("id")int id, Model model) {
        model.addAttribute("stdRepairLineItem", stdRepairLineItemService.findById(id));
        return "settings/updatestdrepairlineitemJens";
    }

    @PostMapping("/updateStdRepairlineitemFromSettings")
    public String updateStdRepairLineFromSettings(@ModelAttribute StdRepairLineItem stdRepairLineItem){
        stdRepairLineItemService.update(stdRepairLineItem);
        return "redirect:/settings";
    }

    @PostMapping("/createStdPartLineItemFromSettings")
    public String createStdPartLineItemFromSettings(@ModelAttribute StdPartLineItem stdPartLineItem){
        stdPartLineItemService.create(stdPartLineItem);
        return "redirect:/settings";
    }

    @PostMapping("/createStdRepairLineItemFromSettings")
    public String createStdRepairLineItemFromSettings(@ModelAttribute StdRepairLineItem StdRepairLineItem){
        stdRepairLineItemService.create(StdRepairLineItem);
        return "redirect:/settings";
    }

    @GetMapping("/deleteStdPartLineItemFromSettings/{id}")
    public String deleteStdPartLineItemFromSettings(@PathVariable("id")int id)
    {
        boolean deleted = stdPartLineItemService.delete(id);
        if(deleted) {
            return "redirect:/settings";
        }
        else{
            return "redirect:/settings";
        }
    }

    @GetMapping("/deleteStdRepairLineItemFromSettings/{id}")
    public String deleteStdRepairLineItemFromSettings(@PathVariable("id")int id)
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
