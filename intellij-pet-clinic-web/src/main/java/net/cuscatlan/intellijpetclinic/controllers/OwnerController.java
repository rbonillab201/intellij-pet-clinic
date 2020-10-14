package net.cuscatlan.intellijpetclinic.controllers;

import net.cuscatlan.intellijpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/owner"})
@Controller
public class OwnerController {

    OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"","/","/list"})
    public String listar(Model model){
        model.addAttribute("title","Owner List");
        model.addAttribute("owners", ownerService.findAll());
        return "owners/list";
    }

}
