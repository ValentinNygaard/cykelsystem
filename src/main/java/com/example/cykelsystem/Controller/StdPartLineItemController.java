package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.StdPartLineItem;
import com.example.cykelsystem.Repository.StdPartLineItemRepoImpl;
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

    @Autowired
    StdPartLineItemRepoImpl splipi;

    @GetMapping("/spli")
    public String StdPartLineItem(Model model){
        List<StdPartLineItem> stdPartLineItem = splipi.findAll();
        model.addAttribute("stdPartLineItem", stdPartLineItem);
        return "stdpartlineitem/spli";
    }

    @GetMapping("/viewStdPartLineItem/{id}")
    public String viewStdPartLineItem(@PathVariable("id")int id, Model model){
        model.addAttribute("stdPartLineItem", splipi.findById(id));
        return "stdpartlineitem/detailsspli";
    }

    @GetMapping("/deleteStdPartLineItem/{id}")
    public String deleteStdPartLineItem(@PathVariable("id")int id)
    {
        boolean deleted = splipi.delete(id);
        if(deleted) {
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/updateStdPartLineitem/{id}")
    public String updateStdPartLineitem(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("stdPartLineItem", splipi.findById(id));
        return "stdPartlineitem/updatespli";
    }

    @PostMapping("/updateStdPartLineItem")
    public String updateStdPartLineItem(@ModelAttribute StdPartLineItem stdPartLineItem){
        splipi.update(stdPartLineItem);
        return "redirect:/";
    }

    @PostMapping("/createStdPartLineItem")
    public String createStdPartLineItem(@ModelAttribute StdPartLineItem stdPartLineItem){
        splipi.create(stdPartLineItem);
        return "redirect:/";
    }
}
