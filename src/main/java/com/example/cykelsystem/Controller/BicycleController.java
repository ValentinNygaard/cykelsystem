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
        List<Bicycle> bicycle = bsi.findAll();
        model.addAttribute("bicycle", bicycle);
        return "home/bicycle";
    }

    @GetMapping("/Bicycle/{id}")
    public String bicycle(@PathVariable("id")int id, Model model){
        model.addAttribute("bicycle", bsi.findById(id));
        return "home/bicyclefind";
    }

    @GetMapping("/deletebicycle/{id}")
    public String deleteBicycle(@PathVariable("id")int id)
    {
        boolean deleted = bsi.delete(id);
        if(deleted) {
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/updatebicycle/{id}")
    public String updateBicycle(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("bicycle",bsi.findById(id));
        return "home/updatebicycle";
    }

    @PostMapping("/updatebicycle")
    public String updateBicycle(@ModelAttribute Bicycle bicycle){
        bsi.update(bicycle);
        return "redirect:/";
    }

    @PostMapping("/createBicycle")
    public String createBicycle(@ModelAttribute Bicycle bicycle){
        bsi.create(bicycle);
        return "redirect:/";
    }
}
