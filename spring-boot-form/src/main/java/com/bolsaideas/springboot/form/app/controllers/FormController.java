package com.bolsaideas.springboot.form.app.controllers;

import com.bolsaideas.springboot.form.app.models.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    //To load the info into the form/browser
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("titulo", "Formulario usuarios");
        return "form";
    }

    @PostMapping("/form")
    //We can map the "usuario" with the form since it has the exact same attributes in the class and form.html
    public String procesar(Usuario usuario, Model model){
        model.addAttribute("titulo", "Resultado del form");
        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}
