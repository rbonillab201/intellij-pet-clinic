package net.cuscatlan.intellijpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"","/","/index"})
public class IndexController {

    @GetMapping({"","/","/index"})
    public String index(Model model){
        System.out.println("aca dale prueba");
        model.addAttribute("title","Index Pet Clinic App");
        return "index";
    }

    @GetMapping("/oups")
    public String oups(Model model){
        model.addAttribute("pag","error");
        return "notimplemented";
    }
}
