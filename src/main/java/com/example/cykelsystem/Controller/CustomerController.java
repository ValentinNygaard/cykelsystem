package com.example.cykelsystem.Controller;


import com.example.cykelsystem.Model.Customer;
import com.example.cykelsystem.Service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerServiceImpl csi;

    @GetMapping("/customer")
    public String customer(Model model){
        List<Customer> customers = csi.findAll();
        model.addAttribute("customer", customers);
        return "customer/customer";
    }

    @GetMapping("/detailsCustomer/{id}")
    public String detailsCustomer(@PathVariable("id")int id, Model model){
        model.addAttribute("customer", csi.findById(id));
        return "customer/detailscustomer";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id")int id)
    {
        boolean deleted = csi.delete(id);
        if(deleted) {
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("customer",csi.findById(id));
        return "customer/updatecustomer";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer){
        csi.update(customer);
        return "redirect:/";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer){
        csi.create(customer);
        return "redirect:/";
    }
}
