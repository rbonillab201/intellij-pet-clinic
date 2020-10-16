package net.cuscatlan.intellijpetclinic.controllers;

import net.cuscatlan.intellijpetclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping({"/vets"})
public class VetController {

    VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }
    @GetMapping({"/vets/","/vets","/vets.html"})
    public String listar(Model model){
        model.addAttribute("title","Vets List");
        model.addAttribute("vets", vetService.findAll());
        return "vets/list";
    }
}
