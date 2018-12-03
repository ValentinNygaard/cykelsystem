package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.Bicycle;
import com.example.cykelsystem.Service.BicyleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BicycleController {
    @Autowired
    BicyleServiceImpl bsi;

    @GetMapping("/bicycle")
    public String bicycle(Model model){
        List<Bicycle> bicycles = bsi.findAll();
        model.addAttribute("bicycle", bicycles);
        return "home/bicycle";
    }

    @GetMapping("/Bicycle/{id}")
    public String bicycle(@PathVariable("id")int id, Model model){
        model.addAttribute("bicycle", bsi.findById(id));
        return "home/bicyclefind";
    }

    /*@GetMapping("/deleteStatus/{id}")
    public String deleteStatus(@PathVariable("id")int id)
    {
        boolean deleted = bsi.delete(id);
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
        model.addAttribute("status",bsi.findById(id));
        return "home/updatestatus";
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@ModelAttribute Bicycle status){
        bsi.update(status);
        return "redirect:/";
    }

    @PostMapping("/createStatus")
    public String createStatus(@ModelAttribute Bicycle status){
        bsi.create(status);
        return "redirect:/";
    }*/
}
