package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.*;
import com.example.cykelsystem.Service.*;
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
    BicyleServiceImpl bsi;

    @Autowired
    RepairCaseServiceImpl rcsi;

    @Autowired
    CustomerServiceImpl csi;

    @Autowired
    EmployeeServiceImpl esi;

    @Autowired
    StatusServiceImpl ssi;

    @Autowired
    StdRepairLineItemServiceImpl srlisi;

    @Autowired
    RepairLineItemServiceImpl rlisi;

    private List<Bicycle> bicycles = new ArrayList<>();
    private List<Bicycle> bicyclesbyphone = new ArrayList<>();
    private List<Bicycle> bicyclechosen = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<Employee> employeechosen = new ArrayList<>();
    private List<Status> statuses = new ArrayList<>();
    private List<Status> statuseschosen = new ArrayList<>();
    private List<StdRepairLineItem> stsreplines = new ArrayList<>();
    private List<RepairLineItem> replines = new ArrayList<>();
    private Bicycle bicycle = new Bicycle();


    @GetMapping("/arbejdskort")
    public String home(Model model){
        return "bootstrapemilie/bootstraptest";
    }

    @GetMapping("/opretarbejdskort")
    public String oprearbejdskort(Model model){

        //List<Bicycle> bicycles = new ArrayList<>();
        stsreplines = srlisi.findAll();
        model.addAttribute("bicycle2", bicycle);
        model.addAttribute("bicycle", bicycles);
        model.addAttribute("stdrepline", stsreplines);
        return "bootstrapemilie/opretarbejdskort";
    }

    @PostMapping("/findcykler")
    public String findcykler(@ModelAttribute Customer customer, Model model){
        Customer c = csi.findByPhone(customer.getPhone_number());
        if(c.getPhone_number()==null){

            if (customer.getName()== null) {
                customer.setName("ukendt");
            }
            csi.create(customer);

        }else{

            bicyclesbyphone = bsi.findAllByCustomer(c.getCustomer_id());
        }
        model.addAttribute("stdrepline", stsreplines);
        model.addAttribute("bicycle2", bicycle);
        model.addAttribute("bicycle1", bicyclesbyphone);
        return "bootstrapemilie/opretarbejdskort";
    }

    @GetMapping("/choosebike/{id}")
    public String choosebike(@PathVariable("id")int id, Model model) {

        bicycle = bsi.findById(id);
        bicyclechosen.add(bicycle);
        model.addAttribute("bicycle2", bicycle);
        model.addAttribute("bicycle1", bicyclesbyphone);
        statuses = ssi.findAll();
        for(Status s : statuses){

        System.out.println(s.getStatus_title());}
        model.addAttribute("status", statuses);

        employees = esi.findAll();
        model.addAttribute("employee", employees);
        model.addAttribute("stdrepline", stsreplines);
        return "bootstrapemilie/opretarbejdskort";
    }

    @PostMapping("/choosebike")
    public String choosebike(@ModelAttribute Bicycle bicycle){
        return "bootstrapemilie/opretarbejdskort";
    }

    @PostMapping("/morestdrepline")
    public String morestdrepline(@ModelAttribute RepairLineItem r, Model model){
        r.setRepair_case_id(4);
        rlisi.create(r);
        replines.add(r);
        model.addAttribute("repline", replines);
        model.addAttribute("bicycle2", bicycle);
        model.addAttribute("bicycle1", bicyclesbyphone);
        model.addAttribute("employee", employees);
        model.addAttribute("stdrepline", stsreplines);
        model.addAttribute("status", statuses);

        return "bootstrapemilie/opretarbejdskort";

    }


    @GetMapping("/chooseemployee/{id}")
    public String chooseemployee(@PathVariable("id")int id, Model model) {

        Employee employee = esi.findById(id);
        employeechosen.add(employee);
        //model.addAttribute("status2", statuseschosen);
        //model.addAttribute("medarbejder2", employeechosen);
        model.addAttribute("bicycle2", bicyclechosen);
        return "bootstrapemilie/opretarbejdskort";
    }

    @GetMapping("/choosestatus/{id}")
    public String choosestatus(@PathVariable("id")int id, Model model) {

        Status status = ssi.findById(id);
        statuseschosen.add(status);
       // model.addAttribute("status2", status);
        //model.addAttribute("medarbejder2", employeechosen);
        model.addAttribute("bicycle2", bicyclechosen);
        return "bootstrapemilie/opretarbejdskort";
    }

    @PostMapping("/createrepaircase")
    public String createrepaircase(@ModelAttribute RepairCase repairCase, Model model) {
        System.out.println(repairCase.toString());
        rcsi.create(repairCase);
        model.addAttribute("repaircase", repairCase);

        //hvis vi kan returnere et id kan vi overveje at vente med at create replines til her
        return "bootstrapemilie/opretarbejdskort";
    }

    @GetMapping("/findarbejdskort")
    public String findarbejdskort(Model model){
        List<RepairCase> repaircases = rcsi.findAll();
        model.addAttribute("repaircases", repaircases);
        return "bootstrapemilie/findarbejdskort";
    }

    @GetMapping("/kunder")
    public String kunde(Model model){
        List<Customer> customers = csi.findAll();
        model.addAttribute("customers", customers);
        return "bootstrapemilie/kunde";
    }

    @GetMapping("/kassebilag")
    public String kassebilag(Model model){
        model.addAttribute("kassebilag");
        return "bootstrapemilie/kassebilag";
    }
}
