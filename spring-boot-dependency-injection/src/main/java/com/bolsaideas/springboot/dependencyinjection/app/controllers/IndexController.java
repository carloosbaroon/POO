package com.bolsaideas.springboot.dependencyinjection.app.controllers;

import com.bolsaideas.springboot.dependencyinjection.app.services.MiServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private MiServicio servicio = new MiServicio();

    @GetMapping({"/","/index"})
    public String index(Model model) {
        model.addAttribute("objecto", servicio.operacion());
        return "index";
    }
}
