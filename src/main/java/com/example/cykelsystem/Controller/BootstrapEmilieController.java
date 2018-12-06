package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.Bicycle;
import com.example.cykelsystem.Model.Customer;
import com.example.cykelsystem.Model.Employee;
import com.example.cykelsystem.Model.RepairCase;
import com.example.cykelsystem.Repository.BicycleRepoImpl;
import com.example.cykelsystem.Repository.CustomerRepoImpl;
import com.example.cykelsystem.Repository.RepairCaseRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BootstrapEmilieController {

    @Autowired
    RepairCaseRepoImpl rcri;

    @Autowired
    CustomerRepoImpl cri;

    @Autowired
    BicycleRepoImpl bri;

    @GetMapping("/arbejdskort")
    public String home(Model model){
        return "bootstrapemilie/bootstraptest";
    }

    @GetMapping("/opretarbejdskort")
    public String oprearbejdskort(Model model){

        List<Bicycle> bicycles = new ArrayList<>();
        model.addAttribute("bicycle", bicycles);
        return "bootstrapemilie/opretarbejdskort";
    }

    @PostMapping("/findcykler")
    public String findcykler(@ModelAttribute Customer customer, Model model){
        Customer c = cri.findByPhone(customer.getPhone_number());
        List<Bicycle> bicycles = bri.findAllByCustomer(c.getCustomer_id());
        model.addAttribute("bicycle", bicycles);
        return "bootstrapemilie/opretarbejdskort";
    }

    @GetMapping("/choosebike/{id}")
    public String choosebike(@PathVariable("id")int id, Model model) {
        List<Bicycle> bicycles = new ArrayList<>();
        Bicycle bicycle = bri.findById(id);
        bicycles.add(bicycle);
        model.addAttribute("bicycle", bicycles);
        return "bootstrapemilie/opretarbejdskort";
    }

    @PostMapping("/choosebike")
    public String choosebike(@ModelAttribute Bicycle bicycle){
        return "bootstrapemilie/opretarbejdskort";
    }

    @GetMapping("/findarbejdskort")
    public String findarbejdskort(Model model){
        List<RepairCase> repaircases = rcri.findAll();
        model.addAttribute("repaircases", repaircases);
        return "bootstrapemilie/findarbejdskort";
    }

    @GetMapping("/kunder")
    public String kunde(Model model){
        List<Customer> customers = cri.findAll();
        model.addAttribute("customers", customers);
        return "bootstrapemilie/kunde";
    }

    @GetMapping("/kassebilag")
    public String kassebilag(Model model){
        model.addAttribute("kassebilag");
        return "bootstrapemilie/kassebilag";
    }
}
