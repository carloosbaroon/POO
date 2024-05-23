package com.bolsaideas.springboot.web.app.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(Model model) {
        return "params/index";
    }


    @GetMapping("/string")
    //We capture the values in the url using @RequestParam
    public String param(@RequestParam(required = false, defaultValue = "algun valor") String texto, Model model) {

        model.addAttribute("resultado", "El parametro enviado es: "+ texto);

        //We need a new dir inside /templates called params
        return "params/ver";
    }

    //Here we recieve two params: saludo & numero
    @GetMapping("/mix-params")
    //We capture the values in the url using @RequestParam
    public String param(@RequestParam() String saludo, @RequestParam() Integer numero, Model model) {

        model.addAttribute("resultado", "El saludo enviado es: "+ saludo + "' y el numero es:'" + numero);

        //We need a new dir inside /templates called params
        return "params/ver";
    }

    //Here we recieve two params: saludo & numero
    @GetMapping("/mix-params-request")
    //We capture the values in the url using @RequestParam
    public String param(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = 0;
        }

        model.addAttribute("resultado", "El saludo enviado es: "+ saludo + "' y el numero es:'" + numero);

        //We need a new dir inside /templates called params
        return "params/ver";
    }
}
