package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.Customer;
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
    EmployeeServiceImpl ess;

    @GetMapping("/employee")
    public String employee(Model model) {
        List<Employee> employeeList = ess.findAll();
        model.addAttribute("employee",employeeList);
        return "employee/employee";
    }

    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@ModelAttribute Employee employee){
        ess.update(employee);
        return "redirect:/employee";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(@ModelAttribute Employee employee) {
        ess.create(employee);
        return "redirect:/employee";
    }

    @PostMapping("/activateEmployee")
    public String activateEmployee(@ModelAttribute Employee employee){
        employee.setActive(1);
        System.out.println(employee.getActive());
        ess.update(employee);
        return "redirect:/employee";
    }

    @PostMapping("/deactivateEmployee")
    public String deactivateEmployee(@ModelAttribute Employee employee){
        employee.setActive(0);
        System.out.println(employee.getActive());
        ess.update(employee);
        return "redirect:/employee";
    }
}
