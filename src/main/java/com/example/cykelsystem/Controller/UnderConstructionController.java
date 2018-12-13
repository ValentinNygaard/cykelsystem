package com.example.cykelsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnderConstructionController {

    @GetMapping("/kassebilag")
    public String overview(Model model){
        return "underconstruction/kassebilag";
    }

    @GetMapping("/kunder")
    public String kunder(Model model){
        return "underconstruction/kunde";
    }

    @GetMapping("/search")
    public String search(Model model){
        return "underconstruction/search";
    }

    @GetMapping("/help")
    public String help(Model model){
        return "underconstruction/help";
    }
}