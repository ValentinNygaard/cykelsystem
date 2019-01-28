// Responsible for code: VN, EB, JØ, EPS
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

    // First new objects of the needed classes is initiated.
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

    // Lists of classes is initilised
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

    // Default values is added to the RepairCase object, then later updates.
    // This is not the best way to operate, we will change this later.
    private String start_date = service.getDateForToday();
    private String end_date = service.getDateForTomorrow();
    private int status_id = 1;
    private int bicycle_id = 1;
    private int customer_employee_id = 1;
    private int repair_employee_id = 1;
    private int end_time = 17;

    // Getting Customer & Bicycle info before creating and editing a new repair_case
    @GetMapping("/getCustomer")
    public String getCustomer(Model model){
        customer.setName("");
        customer.setPhone_number("");
        bicycle.setDescription("");
        model.addAttribute("customer", customer);
        model.addAttribute("bicycle", bicycle);
        return "repaircase/getcustomer";
    }

    // This method checks if there is a customer with a specific phone_number.
    @PostMapping("/getCustomer")
    public String getCustomer(@ModelAttribute Customer customer){
        //check if customer exists
        boolean found = customerService.existsByPhone(customer.getPhone_number());
        if(found == true) {
            customer_id = customerService.findByPhone(customer.getPhone_number()).getCustomer_id();
            return "redirect:/getbicycle";
        }
        else{
            customer.setPhone_number("");
            System.out.println(found + customer.getPhone_number());
            return "redirect:/nocustomer";
        }
    }

    // This method creates a customer with a biclycle
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

    // This method returns the HTML site if there is no customer
    @GetMapping("/nocustomer")
    public String noCustomer(Model model){
        // Identisk med getCustomer - bortset fra fejlbesked på html side - så den bruger også gettingCustomer som PostMapping
        model.addAttribute("customer",customer);
        model.addAttribute("bicycle",bicycle);
        return "repaircase/nocustomer";
    }

    // This method selects a bicycle on a customer_id.
    @GetMapping("/getbicycle")
    public String getBicycle(Model model){
        bicycleList = bicycleService.findAllByCustomer(customer_id);
        model.addAttribute("bicycleList",bicycleList);
        customer = customerService.findById(customer_id);
        model.addAttribute("customer",customer);
        return "repaircase/getbicycle";
    }

    // This method creates a new repair case with the bicycle
    @PostMapping("/gotBicycle")
    public String gotBicycle(@ModelAttribute Bicycle bicycle){
        bicycle_id = bicycle.getBicycle_id();
        createNewRepairCase();
        repaircase_id = repairCaseService.lastId();
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    // This method creates a new bicycle
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
        newRepairCase.setRepair_number(repairCaseService.lastRepairNumber()+1);
        newRepairCase.setEnd_time(end_time);
        repairCaseService.create(newRepairCase);
        repaircase_id = repairCaseService.lastId();
    }

    // Show the repair_case for editing

    @RequestMapping("/repaircasemain/{id}")
    public String repairCaseMain(@PathVariable("id")int id, Model model) {
        repaircase_id = id;
        repairCase = repairCaseService.findById(id);
        model.addAttribute("repairCase",repairCase);
        statusList = statusService.findAll();
        model.addAttribute("statusList", statusList);
        employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        stdRepairLineList = stdRepairLineItemService.findAll();
        model.addAttribute("stdRepairLineList", stdRepairLineList);
        stdPartLineList = stdPartLineItemService.findAll();
        model.addAttribute("stdPartLineList", stdPartLineList);
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
        return "repaircase/repaircasemain";
    }

    // Handling edits to the repair_case

    @PostMapping("/updateRepairCase")
    public String updateRepairCase(@ModelAttribute RepairCase repairCase){
        repairCase.setRepair_case_id(repaircase_id);
        repairCaseService.update(repairCase);
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    // This mehtod adds a repairLine
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
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    // This method updates the repairLine, returns the repaircaseman site with the specific repaircase_id
    @PostMapping("/updateRepairLine")
    public String updateRepairLine(@ModelAttribute RepairLineItem repairLineItem){
        repairLineItem.setRepair_case_id(repaircase_id);
        repairLineItemService.update(repairLineItem);
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    // This method deletes a repairLine with a specific id
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

    // This method adds a partLine
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

    // This method updates partLine
    @PostMapping("/updatePartLine")
    public String updatePartLine(@ModelAttribute PartLineItem partLineItem){
        partLineItem.setRepair_case_id(repaircase_id);
        partLineItemService.update(partLineItem);
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    // This method deletes a partLine on a specific id.
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

    // This method updates a comment, if the repaircase_id mathes the one given.
    @PostMapping("/updateComment")
    public String updateComment(@ModelAttribute Comment comment){
        comment.setRepair_case_id(repaircase_id);
        if (commentService.existsById(repaircase_id)) {
            commentService.update(comment);
        } else {
            comment.setRepair_case_id(repaircase_id);
            commentService.create(comment);
        }
        return "redirect:/repaircasemain/"+repaircase_id;
    }

    // THis method deletes a comment, if it finds the repaircase_id.
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
}
