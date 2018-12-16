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

    // We are creating some methods to navigate between different HTML sites.

    /* Here the method is filling lists of StdPartLineItem, and StdRepairLineItem.
     then adding them to model, and returning the settings page (HTML)*/
    @GetMapping("/settings")
    public String settings(Model model){
        List<StdPartLineItem> stdPartLineItem = stdPartLineItemService.findAll();
        List<StdRepairLineItem> stdRepairLineItems = stdRepairLineItemService.findAll();
        model.addAttribute("stdPartLineItem", stdPartLineItem);
        model.addAttribute("stdRepairLineItem", stdRepairLineItems);
        return "settings/settings";
    }

    /* This method is updating a StdPartLineItem, on a specific object.
      the method is taking a ModelAttribute as a parameter, to specifi that object.
     its calling the method update, in stdPartLineServiceImpl class.
     then returning the settings page(HTML)*/
    @PostMapping("/updateStdPartLineItem/{id}")
    public String updateStdPartLineItem(@ModelAttribute StdPartLineItem stdPartLineItem){
        stdPartLineItemService.update(stdPartLineItem);
        return "redirect:/settings";
    }

    // this is the same method, just with a StdRepairLineItem
    @PostMapping("/updateStdRepairLineItem/{id}")
    public String updateStdRepairLineItem(@ModelAttribute StdRepairLineItem stdRepairLineItem) {
        stdRepairLineItemService.update(stdRepairLineItem);
        return "redirect:/settings";
    }

    // This method updates a StdPartLineItem
    @PostMapping("/updateStdPartlineitem")
    public String updateStdPartLine(@ModelAttribute StdPartLineItem stdPartLineItem){
        stdPartLineItemService.update(stdPartLineItem);
        return "redirect:/settings";
    }

    // This method updates a StdRepairLineItem
    @PostMapping("/updateStdRepairlineitem")
    public String updateStdRepairLine(@ModelAttribute StdRepairLineItem stdRepairLineItem){
        stdRepairLineItemService.update(stdRepairLineItem);
        return "redirect:/settings";
    }

    // This method is creating a new StdPartLineItem, it calls the method create in the stdPartLineServiceImpl class.
    @PostMapping("/createStdPartLineItem")
    public String createStdPartLineItem(@ModelAttribute StdPartLineItem stdPartLineItem){
        stdPartLineItemService.create(stdPartLineItem);
        return "redirect:/settings";
    }

    // The same method, just for StdRepairLineItem.
    @PostMapping("/createStdRepairLineItem")
    public String createStdRepairLineItem(@ModelAttribute StdRepairLineItem StdRepairLineItem){
        stdRepairLineItemService.create(StdRepairLineItem);
        return "redirect:/settings";
    }

    /* This method is deleting a StdPartLineItem
     The method is taking a PathVariable as a parameter
     the method is looking for a id, if its there it delets the object, then returns the settings page
     if not it is returning the settings page*/
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

    //The same but for RepairLineItem
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
