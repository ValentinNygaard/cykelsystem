package com.example.cykelsystem.Controller;

import com.example.cykelsystem.Model.*;
import com.example.cykelsystem.Service.RepBarLineService;
import com.example.cykelsystem.Service.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    RepBarLineService rbls;

    @Autowired
    StatusServiceImpl ssi;

    @GetMapping("/search")
    public String search(Model model) {
        List<Status> statusList = ssi.findAll();
        model.addAttribute("status",statusList);
        return "underconstruction/search";
    }

    @PostMapping("/searchPhone")
    public String searchPhone(@ModelAttribute Customer customer, Model model){
        String phoneNumber = customer.getPhone_number();
        List<RepBarLine> repBarLines = rbls.findByPhoneNumber(phoneNumber);
        model.addAttribute("repBarLine", repBarLines);
        return "searches/searchoverview";
    }

    @PostMapping("/searchCustomer")
    public String searchCustomer(@ModelAttribute Customer customer, Model model){
        List<RepBarLine> repBarLines = rbls.findByCustomerName(customer.getName());
        model.addAttribute("repBarLine", repBarLines);
        return "searches/searchoverview";
    }

    @PostMapping("searchBetweenDates")
    public String searchBetweenDates(@ModelAttribute RepairCase repairCase, Model model){
        List<RepBarLine> repBarLines = rbls.findRepbarsWithStatusBetweenDates(1, 6, repairCase.getStart_date(), repairCase.getEnd_date());
        model.addAttribute("repBarLine", repBarLines);
        return "searches/searchoverview";
    }

    @PostMapping("searchBetweenStartDates")
    public String searchBetweenStartDates(@ModelAttribute RepairCase repairCase, Model model){
        List<RepBarLine> repBarLines = rbls.findByStartDate(repairCase.getStart_date(), repairCase.getEnd_date());
        model.addAttribute("repBarLine", repBarLines);
        return "searches/searchoverview";
    }

    @PostMapping("searchOnStatus")
    public String searchOnStatus(@ModelAttribute Status status, Model model){
        List<RepBarLine> repBarLines = rbls.findRepBarsWithStatus(status.getStatus_id(), status.getStatus_id());
        model.addAttribute("repBarLine", repBarLines);
        return "searches/searchoverview";
    }

    @PostMapping("searchOnRepairEmployee")
    public String searchOnRepairEmployee(@ModelAttribute RepairCase repairCase, Employee employee, Model model) {
        List<RepBarLine> repBarLines = rbls.findByRepairEmployeeNameAndDate(employee.getName(), repairCase.getStart_date(), repairCase.getEnd_date());
        model.addAttribute("repBarLine", repBarLines);
        return "searches/searchoverview";
    }

    @PostMapping("searchOnCreateEmployee")
    public String searchOnCreateEmployee(@ModelAttribute RepairCase repairCase, Employee employee, Model model) {
        List<RepBarLine> repBarLines = rbls.findByCreateEmployeeNameAndDate(employee.getName(), repairCase.getStart_date(), repairCase.getEnd_date());
        model.addAttribute("repBarLine", repBarLines);
        return "searches/searchoverview";
    }

}
