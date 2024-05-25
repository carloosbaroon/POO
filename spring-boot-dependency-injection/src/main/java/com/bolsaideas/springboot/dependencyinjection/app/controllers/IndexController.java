package com.bolsaideas.springboot.dependencyinjection.app.controllers;

import com.bolsaideas.springboot.dependencyinjection.app.services.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    //To inject an object that is registered in Spring's container
    @Autowired
    private IServicio servicio;

    @GetMapping({"/","/index"})
    public String index(Model model) {
        model.addAttribute("objecto", servicio.operacion());
        return "index";
    }
}
