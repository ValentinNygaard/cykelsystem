package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.*;
import com.example.cykelsystem.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RepairCaseControllerVN {

    @Autowired
    RepairCaseServiceImpl rcsi;
    @Autowired
    StatusServiceImpl ssi;
    @Autowired
    RepairLineItemServiceImpl rlisi;
    @Autowired
    StdRepairLineItemServiceImpl srlisi;
    @Autowired
    PartLineItemServiceImpl plisi;
    @Autowired
    StdPartLineItemServiceImpl splisi;
    @Autowired
    EmployeeServiceImpl esi;
    @Autowired
    CommentServiceImpl csi;

    private int rc_id;

    private RepairCase repairCase;
    private List<RepairCase> repairCaseList;
    private List<Status> statusList;
    private List<Employee> employeeList;
    private List<StdRepairLineItem> stdRepairLineList;
    private List<RepairLineItem> repairLineList;
    private List<StdPartLineItem> stdPartLineList;
    private List<PartLineItem> partLineList;
    private Comment comment;

    private boolean needinit = true;

    @RequestMapping ("/repairCaseCreate")
    public String repairCaseCreate(Model model) {


        RepairCase newRepairCase = new RepairCase();
        newRepairCase.setStart_date("2018-12-04");
        newRepairCase.setEnd_date("2018-12-04");
        newRepairCase.setStatus_id(1);
        newRepairCase.setBicycle_id(1);
        newRepairCase.setCustomer_employee_id(1);
        newRepairCase.setRepair_employee_id(2);
        newRepairCase.setRepair_number(445);
        rcsi.create(newRepairCase);
        int nrc_id = newRepairCase.getRepair_case_id();
        System.out.println("nrc_id: " + nrc_id);


        rc_id = rcsi.nextId();
        System.out.println("rc_id: " + rc_id);

        repairCase = rcsi.findById(rc_id);
        model.addAttribute("repairCase",repairCase);
        repairCaseList = rcsi.findAll();
        model.addAttribute("repairCaseList", repairCaseList);
        statusList = ssi.findAll();
        model.addAttribute("statusList", statusList);
        employeeList = esi.findAll();
        model.addAttribute("employeeList", employeeList);
        stdRepairLineList = srlisi.findAll();
        model.addAttribute("stdRepairLineList", stdRepairLineList);
        repairLineList = rlisi.findByRcId(rc_id);
        model.addAttribute("repairLineList", repairLineList);
        stdPartLineList = splisi.findAll();
        model.addAttribute("stdPartLineList", stdPartLineList);
        partLineList = plisi.findByRcId(rc_id);
        model.addAttribute("partLineList", partLineList);
        if (csi.existsById(rc_id)) {
            comment = csi.findById(rc_id);
        } else {
            comment = new Comment();
            comment.setRepair_case_id(rc_id);
        }
        model.addAttribute("comment",comment);
        return "repaircase/repaircasemain";
    }

    @RequestMapping ("/repairCaseMain")
    public String repairCaseMain(Model model) {

        if (needinit) {
            RepairCase newRepairCase = new RepairCase();
            newRepairCase.setStart_date("2018-12-04");
            newRepairCase.setEnd_date("2018-12-04");
            newRepairCase.setStatus_id(1);
            newRepairCase.setBicycle_id(1);
            newRepairCase.setCustomer_employee_id(1);
            newRepairCase.setRepair_employee_id(2);
            newRepairCase.setRepair_number(445);
            rcsi.create(newRepairCase);
            needinit = false;
        }

        rc_id = rcsi.nextId();
        System.out.println("rc_id: " + rc_id);

        repairCase = rcsi.findById(rc_id);
        model.addAttribute("repairCase",repairCase);
        repairCaseList = rcsi.findAll();
        model.addAttribute("repairCaseList", repairCaseList);
        statusList = ssi.findAll();
        model.addAttribute("statusList", statusList);
        employeeList = esi.findAll();
        model.addAttribute("employeeList", employeeList);
        stdRepairLineList = srlisi.findAll();
        model.addAttribute("stdRepairLineList", stdRepairLineList);
        repairLineList = rlisi.findByRcId(rc_id);
        model.addAttribute("repairLineList", repairLineList);
        stdPartLineList = splisi.findAll();
        model.addAttribute("stdPartLineList", stdPartLineList);
        partLineList = plisi.findByRcId(rc_id);
        model.addAttribute("partLineList", partLineList);
        if (csi.existsById(rc_id)) {
            comment = csi.findById(rc_id);
        } else {
            comment = new Comment();
            comment.setRepair_case_id(rc_id);
        }
        model.addAttribute("comment",comment);
        return "repaircase/repaircasemain";
    }

    @GetMapping("/detailsRepairCase/{id}")
    public String detailsrepaircase(@PathVariable("id")int id, Model model){
        model.addAttribute("repairCase", rcsi.findById(id));
        return "repaircase/repaircasemain";
    }

    @GetMapping("/deleteRepairCase/{id}")
    public String deleteRepairCase(@PathVariable("id")int id)
    {
        boolean deleted = rcsi.delete(id);
        if(deleted) {
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @PostMapping("/updateRepairCase")
    public String updateRepairCase(@ModelAttribute RepairCase repairCase){
        rcsi.update(repairCase);
        return "redirect:/repairCaseMain";
    }

    @PostMapping("/addRepairLine")
    public String addRepairLine(@ModelAttribute StdRepairLineItem srli){
        System.out.println("Data: " + srli.getStd_repair_line_item_id());
        System.out.println("Data: " + srli.getDescription());
        RepairLineItem rli = new RepairLineItem();
        StdRepairLineItem newSrli = srlisi.findById(srli.getStd_repair_line_item_id());
        rli.setDescription(newSrli.getDescription());
        rli.setTime(newSrli.getTime());
        rli.setPrice(newSrli.getPrice());
        rli.setRepair_case_id(rc_id);
        rlisi.create(rli);
        repairLineList = rlisi.findByRcId(rc_id);
        return "redirect:/repairCaseMain";
    }

    @PostMapping("/updateRepairLine")
    public String updateRepairLine(@ModelAttribute RepairLineItem repairLineItem){
        System.out.println("Data: " + repairLineItem.getRepair_line_item_id());
        repairLineItem.setRepair_case_id(rc_id);
        System.out.println("Data: " + repairLineItem.getDescription());
        rlisi.update(repairLineItem);
        return "redirect:/repairCaseMain";
    }

    @GetMapping("/deleteRepairLine/{id}")
    public String deleteRepairLine(@PathVariable("id")int id)
    {
        boolean deleted = rlisi.delete(id);
        repairLineList = rlisi.findByRcId(rc_id);
        if(deleted) {
            return "redirect:/repairCaseMain";
        }
        else{
            return "redirect:/repairCaseMain";
        }
    }

    @PostMapping("/addPartLine")
    public String addPartLine(@ModelAttribute StdPartLineItem spli){
        PartLineItem pli = new PartLineItem();
        StdPartLineItem newSpli = splisi.findById(spli.getStd_part_line_item_id());
        pli.setDescription(newSpli.getDescription());
        pli.setPrice(newSpli.getPrice());
        pli.setRepair_case_id(rc_id);
        plisi.create(pli);
        partLineList = plisi.findByRcId(rc_id);
        return "redirect:/repairCaseMain";
    }

    @PostMapping("/updatePartLine")
    public String updatePartLine(@ModelAttribute PartLineItem partLineItem){
        partLineItem.setRepair_case_id(rc_id);
        plisi.update(partLineItem);
        return "redirect:/repairCaseMain";
    }

    @GetMapping("/deletePartLine/{id}")
    public String deletePartLine(@PathVariable("id")int id)
    {
        boolean deleted = plisi.delete(id);
        partLineList = plisi.findByRcId(rc_id);
        if(deleted) {
            return "redirect:/repairCaseMain";
        }
        else{
            return "redirect:/repairCaseMain";
        }
    }

    @PostMapping("/updateComment")
    public String updateComment(@ModelAttribute Comment comment){
        System.out.println("Her!");
        if (csi.existsById(rc_id)) {
            csi.update(comment);
            System.out.println("Her! 1!");
        } else {
            comment.setRepair_case_id(rc_id);
            csi.create(comment);
            System.out.println("Her! 2!");
        }
        return "redirect:/repairCaseMain";
    }

    @GetMapping("/deleteComment")
    public String deleteComment()
    {
        boolean deleted = csi.delete(rc_id);
        if(deleted) {
            return "redirect:/repairCaseMain";
        }
        else{
            return "redirect:/repairCaseMain";
        }
    }




}
