package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.*;
import com.example.cykelsystem.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RepairCaseController {

    @Autowired
    RepairCaseServiceImpl repairCaseService;
    @Autowired
    StatusServiceImpl statusService;
    @Autowired
    RepairLineItemServiceImpl repairLineItemService;
    @Autowired
    StdRepairLineItemServiceImpl stdRepairLineItemService;
    @Autowired
    PartLineItemServiceImpl partLineItemService;
    @Autowired
    StdPartLineItemServiceImpl stdPartLineItemService;
    @Autowired
    BicyleServiceImpl bicycleService;
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    EmployeeServiceImpl employeeService;

    ServiceService service = new ServiceService();

    private List<Bicycle> bicycleList;
    private List<Employee> employeeList;
    private List<PartLineItem> partLineList;
    private List<RepairLineItem> repairLineList;
    private List<Status> statusList;
    private List<StdRepairLineItem> stdRepairLineList;
    private List<StdPartLineItem> stdPartLineList;

    private Comment comment;
    private Customer customer = new Customer();
    private Bicycle bicycle = new Bicycle();
    private RepairCase repairCase;

    private int repaircase_id;
    private int customer_id;

    private String start_date = service.getCurrentDate().toString();
    private String end_date = service.getCurrentDateAddOneDay().toString();
    private int status_id = 1;
    private int bicycle_id = 1;
    private int customer_employee_id = 1;
    private int repair_employee_id = 1;
    private int repair_number = 1;
    private int end_time = 17;

    // Getting Customer & Bicycle info before creating and editing a new repair_case

    @GetMapping("/getCustomer")
    public String getCustomer(Model model){
        customer.setName("");
        customer.setPhone_number("");
        model.addAttribute("customer", customer);
        model.addAttribute("bicycle", bicycle);
        return "repaircase/getcustomer";
    }

    @PostMapping("/getCustomer")
    public String getCustomer(@ModelAttribute Customer customer){
        //check if customer exists
        boolean found = customerService.existsByPhone(customer.getPhone_number());
        if(found) {
            customer_id = customerService.findByPhone(customer.getPhone_number()).getCustomer_id();
            return "redirect:/getbicycle";
        }
        else{
            return "repaircase/nocustomer";
        }
    }

    @PostMapping("/createCustomerAndBicycle")
    public String createCustomerAndBicycle(@ModelAttribute Customer costumer, Bicycle bicycle){
        customerService.create(costumer);
        customer_id = customerService.lastId();
        bicycle.setCustomer_id(customer_id);
        bicycleService.create(bicycle);
        bicycle_id = bicycleService.lastId();
        createNewRepairCase();
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    @GetMapping("/noCustomer")
    public String noCustomer(Model model){
        // Identisk med getCustomer - bortset fra fejlbesked på html side - så den bruger også gettingCustomer som PostMapping
        model.addAttribute("customer",customer);
        model.addAttribute("bicycle",bicycle);
        return "repaircase/nocustomer";
    }

    @GetMapping("/getbicycle")
    public String getBicycle(Model model){
        bicycleList = bicycleService.findAllByCustomer(customer_id);
        model.addAttribute("bicycleList",bicycleList);
        customer = customerService.findById(customer_id);
        model.addAttribute("customer",customer);
        return "repaircase/getbicycle";
    }

    @PostMapping("/gotBicycle")
    public String gotBicycle(@ModelAttribute Bicycle bicycle){
        bicycle_id = bicycle.getBicycle_id();
        System.out.println("Data (id): " + bicycle_id);
        createNewRepairCase();
        repaircase_id = repairCaseService.lastId();
        System.out.println("Data (id): " + repaircase_id);
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    @PostMapping("/createNewBicycle")
    public String createBicycle(@ModelAttribute Bicycle bicycle){
        bicycle.setCustomer_id(customer_id);
        bicycleService.create(bicycle);
        bicycle_id = bicycleService.lastId();
        createNewRepairCase();
        repaircase_id = repairCaseService.lastId();
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    // Creating new repair_case row in database

    private void createNewRepairCase() {
        RepairCase newRepairCase = new RepairCase();
        newRepairCase.setStart_date(start_date);
        newRepairCase.setEnd_date(end_date);
        newRepairCase.setStatus_id(status_id);
        newRepairCase.setBicycle_id(bicycle_id);
        newRepairCase.setCustomer_employee_id(customer_employee_id);
        newRepairCase.setRepair_employee_id(repair_employee_id);
        newRepairCase.setRepair_number(repair_number);
        newRepairCase.setEnd_time(end_time);
        repairCaseService.create(newRepairCase);
        repaircase_id = repairCaseService.lastId();
    }

    // Show the repair_case for editing

    @GetMapping("/repaircasemain/{id}")
    public String repairCaseMain(@PathVariable("id")int id, Model model) {
        repaircase_id = id;
        statusList = statusService.findAll();
        model.addAttribute("statusList", statusList);
        employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        stdRepairLineList = stdRepairLineItemService.findAll();
        model.addAttribute("stdRepairLineList", stdRepairLineList);
        stdPartLineList = stdPartLineItemService.findAll();
        model.addAttribute("stdPartLineList", stdPartLineList);
        repairCase = repairCaseService.findById(id);
        model.addAttribute("repairCase",repairCase);
        bicycle = bicycleService.findById(repairCase.getBicycle_id());
        model.addAttribute("bicycle",bicycle);
        customer = customerService.findById(bicycle.getCustomer_id());
        model.addAttribute("customer",customer);
        repairLineList = repairLineItemService.findByRcId(id);
        model.addAttribute("repairLineList", repairLineList);
        partLineList = partLineItemService.findByRcId(id);
        model.addAttribute("partLineList", partLineList);
        if (commentService.existsById(id)) {
            comment = commentService.findById(id);
        } else {
            comment = new Comment();
            comment.setRepair_case_id(id);
        }
        model.addAttribute("comment",comment);
        return "repaircase/repaircasemain/"+repaircase_id;
    }

    // Handling edits to the repair_case

    @PostMapping("/updateRepairCase")
    public String updateRepairCase(@ModelAttribute RepairCase repairCase){
        repairCaseService.update(repairCase);
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    @PostMapping("/addRepairLine")
    public String addRepairLine(@ModelAttribute StdRepairLineItem srli){
        RepairLineItem rli = new RepairLineItem();
        StdRepairLineItem newSrli = stdRepairLineItemService.findById(srli.getStd_repair_line_item_id());
        rli.setDescription(newSrli.getDescription());
        rli.setTime(newSrli.getTime());
        rli.setPrice(newSrli.getPrice());
        rli.setRepair_case_id(repaircase_id);
        repairLineItemService.create(rli);
        repairLineList = repairLineItemService.findByRcId(repaircase_id);
        return "redirect:/repairCaseMain/"+repaircase_id;
    }

    @PostMapping("/updateRepairLine")
    public String updateRepairLine(@ModelAttribute RepairLineItem repairLineItem){
        repairLineItem.setRepair_case_id(repaircase_id);
        repairLineItemService.update(repairLineItem);
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    @GetMapping("/deleteRepairLine/{id}")
    public String deleteRepairLine(@PathVariable("id")int id) {
        boolean deleted = repairLineItemService.delete(id);
        repairLineList = repairLineItemService.findByRcId(repaircase_id);
        if(deleted) {
            return "redirect:/repaircasemain/"+repaircase_id;
        }
        else{
            return "redirect:/repaircasemain/"+repaircase_id;
        }
    }

    @PostMapping("/addPartLine")
    public String addPartLine(@ModelAttribute StdPartLineItem spli){
        PartLineItem pli = new PartLineItem();
        StdPartLineItem newSpli = stdPartLineItemService.findById(spli.getStd_part_line_item_id());
        pli.setDescription(newSpli.getDescription());
        pli.setPrice(newSpli.getPrice());
        pli.setRepair_case_id(repaircase_id);
        partLineItemService.create(pli);
        partLineList = partLineItemService.findByRcId(repaircase_id);
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    @PostMapping("/updatePartLine")
    public String updatePartLine(@ModelAttribute PartLineItem partLineItem){
        partLineItem.setRepair_case_id(repaircase_id);
        partLineItemService.update(partLineItem);
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    @GetMapping("/deletePartLine/{id}")
    public String deletePartLine(@PathVariable("id")int id) {
        boolean deleted = partLineItemService.delete(id);
        partLineList = partLineItemService.findByRcId(repaircase_id);
        if(deleted) {
            return "redirect:/repaircasemain/"+repaircase_id;
        }
        else{
            return "redirect:/repaircasemain/"+repaircase_id;
        }
    }

    @PostMapping("/updateComment")
    public String updateComment(@ModelAttribute Comment comment){
        if (commentService.existsById(repaircase_id)) {
            commentService.update(comment);
        } else {
            comment.setRepair_case_id(repaircase_id);
            commentService.create(comment);
        }
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    @GetMapping("/deleteComment")
    public String deleteComment() {
        boolean deleted = commentService.delete(repaircase_id);
        if(deleted) {
            return "redirect:/repaircasemain/"+repaircase_id;
        }
        else{
            return "redirect:/repaircasemain/"+repaircase_id;
        }
    }

    //System.out.println("Data (id): " + repaircase_id);

}
