package com.bolsaideas.springboot.dependencyinjection.app.controllers;

import com.bolsaideas.springboot.dependencyinjection.app.services.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    //To inject an object that is registered in Spring's container
    @Autowired
    //@Qualifier will allow us to inject a service with its own name
    @Qualifier("miServicioSimple")
    private IServicio servicio;

    //We can omit the @Autowired annotation only in the constructor
    /*@Autowired
    public IndexController(IServicio servicio) {
        this.servicio = servicio;
    }*/

    @GetMapping({"/","/index"})
    public String index(Model model) {
        model.addAttribute("objecto", servicio.operacion());
        return "index";
    }

    //Another way to inject a dependency using the setter
    /*@Autowired
    public void setServicio(IServicio servicio) {
        this.servicio = servicio;
    }*/
}
