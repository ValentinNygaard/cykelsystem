package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.Employee;
import com.example.cykelsystem.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl esi;

    @GetMapping("/login")
    public String updateStatus()
    {
        return "home/loginEmployee";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Employee employee){
        boolean login = esi.login(employee);
        if (login) {
            return "redirect:/";
        }
        else {
            return "home/Fejlbesked";
        }
    }
}
