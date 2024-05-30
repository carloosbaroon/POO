package com.bolsaideas.springboot.form.app.controllers;

import com.bolsaideas.springboot.form.app.models.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
//This will allow us to get values that are not in the form for the post (Usuario.id)
@SessionAttributes("usuario")
public class FormController {

    //To load the info into the form/browser
    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Aleph");
        usuario.setApellido("Baron");
        usuario.setId("123.456.789-K");
        model.addAttribute("titulo", "Formulario usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    //We can map the "usuario" with the form since it has the exact same attributes in the class and form.html
    //@Valid validates the attributes of "usuario" and BindingResult will provide us the result of that validation
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status){

        model.addAttribute("titulo", "Resultado del form");

        //Here we are passing also the Class Usuario but with lower case -> "usuario" to the view form.html -> th:object="${usuario}"
        //If we want to use a different name, we should use @ModelAttribute("user") and change it also in the view
        if (result.hasErrors()) {
            return "form";
        }

        model.addAttribute("usuario", usuario);
        status.setComplete();
        return "resultado";
    }
}
