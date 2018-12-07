package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Service.PartLineItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.cykelsystem.Model.PartLineItem;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PartLineItemController {

    @Autowired
    PartLineItemServiceImpl plisi;

    @GetMapping("/partLineItem")
    public String partLineItem(Model model){
        List<PartLineItem>  partLineItems = plisi.findAll();
        model.addAttribute("partLineItem", partLineItems);
        return "partlineitem/partlineitem";
    }

    @GetMapping("/detailsPartLineItem/{id}")
    public String detailsPartLineItem(@PathVariable("id") int id, Model model){
        model.addAttribute("partLineItem", plisi.findById(id));
        return "partlineitem/detailspartlineitem";
    }

    @GetMapping("deletePartLineItem/{id}")
    public String deletePartLineItem(@PathVariable("id")int id)
    {
        boolean deleted = plisi.delete(id);
        if(deleted) {
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/updatePartlineItem/{id}")
    public String updatePartLineItem(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("partLineItem",plisi.findById(id));
        return "partlineitem/updatepartlineitem";
    }

    @PostMapping("/updatePartLineItem")
    public String updatePartLineItem(@ModelAttribute PartLineItem partLineItem){
        plisi.update(partLineItem);
        return "redirect:/";
    }

    @PostMapping("/createPartLineItem")
    public String createPartLineItem(@ModelAttribute PartLineItem partLineItem){
        plisi.create(partLineItem);
        return "redirect:/";
    }
}
