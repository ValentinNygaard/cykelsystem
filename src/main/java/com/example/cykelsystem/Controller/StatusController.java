package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.Status;
import com.example.cykelsystem.Service.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StatusController {

    @Autowired
    StatusServiceImpl ssi;

    @GetMapping("/staTus/{id}")
    public String staTus(@PathVariable("id")int id, Model model){
        model.addAttribute("status", ssi.findById(id));
        return "home/status";
    }

    @GetMapping("/deleteStatus/{id}")
    public String deleteStatus(@PathVariable("id")int id)
    {
        boolean deleted = ssi.delete(id);
        if(deleted) {
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/updateStatus/{id}")
    public String updateStatus(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("status",ssi.findById(id));
        return "home/updatestatus";
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@ModelAttribute Status status){
        ssi.update(status);
        return "redirect:/";
    }

    @PostMapping("/createStatus")
    public String createStatus(@ModelAttribute Status status){
        ssi.create(status);
        return "redirect:/";
    }
}
