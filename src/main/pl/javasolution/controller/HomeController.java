package main.pl.javasolution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String welcome(Model model){
        model.addAttribute("greeting","Witaj w sklepie internetowym");
        model.addAttribute("tagline","Wyjatkowym i jedynym sklepie internetowym");
        return "welcome";
    }

    @RequestMapping(value = "/welcome/greeting",method = RequestMethod.GET)
    public String greeting(){
        return "welcome";
    }
}
