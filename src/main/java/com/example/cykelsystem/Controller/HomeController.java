package com.example.cykelsystem.Controller;


import com.example.cykelsystem.Model.StdRepairLineItem;
import com.example.cykelsystem.Service.IService;
import com.example.cykelsystem.Service.StatusServiceImpl;
import com.example.cykelsystem.Service.StdRepairLineItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.cykelsystem.Model.Status;

import java.util.List;

@Controller
public class HomeController {

   @Autowired
   StatusServiceImpl ssi;
   @Autowired
   StdRepairLineItemServiceImpl srli;


   @GetMapping("/")
    public String home(Model model){
       List<Status> status = ssi.findAll();
       model.addAttribute("status", status);
       List<StdRepairLineItem> stdRep = srli.findAll();
       model.addAttribute("stdRep", stdRep);
       return "home/index";
    }




}
