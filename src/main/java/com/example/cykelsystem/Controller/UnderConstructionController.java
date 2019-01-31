// Made by EB
package com.example.cykelsystem.Controller;

import com.sun.net.httpserver.HttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOError;

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
