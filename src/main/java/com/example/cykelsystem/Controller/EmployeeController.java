package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.Employee;
import com.example.cykelsystem.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/employee")
    public String employee(Model model){
        List<Employee> employee = esi.findAll();
        model.addAttribute("employee", employee);
        return "employee/employee";
    }


    @GetMapping("/employee/{id}")
    public String employee(@PathVariable("id")int id, Model model){
        model.addAttribute("employee", esi.findById(id));
        return "employee/detailsemployee";
    }

    @GetMapping("/deleteemployee/{id}")
    public String deleteemployee(@PathVariable("id")int id)
    {
        boolean deleted = esi.delete(id);
        if(deleted) {
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/updateemployee/{id}")
    public String updateemployee(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("employee",esi.findById(id));
        return "employee/updateemployee";
    }

    @PostMapping("/updateemployee")
    public String updateemployee(@ModelAttribute Employee employee){
        esi.update(employee);
        return "redirect:/";
    }

    @PostMapping("/createemployee")
    public String createemployee(@ModelAttribute Employee employee){
        esi.create(employee);
        return "redirect:/";
    }
}
