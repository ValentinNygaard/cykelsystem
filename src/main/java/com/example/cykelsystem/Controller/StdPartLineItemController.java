package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.StdPartItemLine;
import com.example.cykelsystem.Service.StdBicyclepartLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StdPartLineItemController {
    /*@Autowired
    StdBicyclepartLineItemService sblis;

    @GetMapping("/sbli")
    public String StdBicyclepartLineItem(Model model){
        List<StdBicyclepartLineItem> stdBicyclepartLineItem = sblis.findAll();
        model.addAttribute("stdBycycleLineItem", stdBicyclepartLineItem);
        return "stdbicyclelineitem/sbli";
    }

    @GetMapping("/viewStdBicycleLineItem/{id}")
    public String viewStdBicyclepartLineItem(@PathVariable("id")int id, Model model){
        model.addAttribute("stdbicycleLineItem", sblis.findById(id));
        return "stdbicyclelineitem/detailssbli";
    }

    @GetMapping("/deleteStdBicycleLineItem/{id}")
    public String deleteStdBicycleLineItem(@PathVariable("id")int id)
    {
        boolean deleted = sblis.delete(id);
        if(deleted) {
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/updateStdBicycleLineitem/{id}")
    public String updateStdBicycleLineitem(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("stdbicycleLineItem",sblis.findById(id));
        return "stdbicyclelineitem/updatesbli";
    }

    @PostMapping("/updateStdBicycleLineItem")
    public String updateStdBicycleLineItem(@ModelAttribute StdBicyclepartLineItem stdBicyclepartLineItem){
        sblis.update(stdBicyclepartLineItem);
        return "redirect:/";
    }

    @PostMapping("/createStdBicycleLineItem")
    public String createStdBicycleLineItem(@ModelAttribute StdBicyclepartLineItem stdBicyclepartLineItem){
        sblis.create(stdBicyclepartLineItem);
        return "redirect:/";
    }*/
}
