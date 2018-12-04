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
        return "employee/loginEmployee";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Employee employee){
        boolean login = esi.login(employee);
        if (login) {
            return "employee/employee";
        }
        else {
            return "employee/Fejlbesked";
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


    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id")int id)
    {
        boolean deleted = esi.delete(id);
        if(deleted) {
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("employee",esi.findById(id));
        return "employee/updateemployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute Employee employee){
        esi.update(employee);
        return "redirect:/employee";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(@ModelAttribute Employee employee){
        esi.create(employee);
        return "redirect:/";
    }
}
