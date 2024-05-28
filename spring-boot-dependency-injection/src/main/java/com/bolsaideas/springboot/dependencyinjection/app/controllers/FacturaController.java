package com.bolsaideas.springboot.dependencyinjection.app.controllers;

import com.bolsaideas.springboot.dependencyinjection.app.models.domain.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private Factura factura;

    @GetMapping("/ver")
    public String verFactura(Model model) {
        model.addAttribute("factura", factura);
        model.addAttribute("titulo", "Ejemplo Factura con inyeccion de dependencia");
        return "factura/ver";
    }
}
