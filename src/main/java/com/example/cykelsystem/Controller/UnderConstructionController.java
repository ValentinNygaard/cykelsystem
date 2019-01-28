// Made by EB
package com.example.cykelsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnderConstructionController {

    // We are creating some methods to navigate between different HTML sites.
    // all these sites are not complete, but under construction.
    @GetMapping("/kassebilag")
    public String overview(Model model){
        return "underconstruction/kassebilag";
    }

    @GetMapping("/help")
    public String help(Model model){
        return "underconstruction/help";
    }
}
