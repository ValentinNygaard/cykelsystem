package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.Customer;
import com.example.cykelsystem.Service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerServiceImpl csi;

    @GetMapping("/customer")
    public String search(Model model) {
        List<Customer> customerList = csi.findAll();
        model.addAttribute("customer",customerList);
        return "customer/customer";
    }

    @PostMapping("/updateCustomer/{id}")
    public String updateCustomer(@ModelAttribute Customer customer){
        csi.update(customer);
        return "redirect:/customer";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer) {
        csi.create(customer);
        return "redirect:/customer";
    }

    @PostMapping("/searchCustomerPhone")
    public String searchCustomerPhone(@ModelAttribute Customer customer, Model model){
        String phoneNumber = customer.getPhone_number();
        List<Customer> customerList= csi.findByPhoneList(phoneNumber);
        model.addAttribute("customerSearch", customerList);
        return "customer/customersearch";
    }

    @PostMapping("updateCustomerSearch/{id}")
    public String updateCustomerPhoneSearch(@ModelAttribute Customer customer, Model model){
        csi.update(customer);
        model.addAttribute("customerSearch", customer);
        return "customer/customersearch";
    }

    @PostMapping("/searchCustomerName")
    public String searchCustomerName(@ModelAttribute Customer customer, Model model){
        String name = customer.getName();
        List<Customer> customerList= csi.findByName(name);
        model.addAttribute("customerSearch", customerList);
        return "customer/customersearch";
    }
}
