package com.bolsaideas.springboot.form.app.controllers;

import com.bolsaideas.springboot.form.app.editors.NombreMayusculaEditor;
import com.bolsaideas.springboot.form.app.editors.PaisPropertyEditor;
import com.bolsaideas.springboot.form.app.editors.RolesEditor;
import com.bolsaideas.springboot.form.app.models.domain.Pais;
import com.bolsaideas.springboot.form.app.models.domain.Role;
import com.bolsaideas.springboot.form.app.models.domain.Usuario;
import com.bolsaideas.springboot.form.app.services.PaisService;
import com.bolsaideas.springboot.form.app.services.RoleService;
import com.bolsaideas.springboot.form.app.validation.UsuarioValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
//This will allow us to get values that are not in the form for the post (Usuario.id)
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidator validator;

    @Autowired
    private PaisService paisService;

    @Autowired
    private PaisPropertyEditor paisEditor;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolesEditor rolesEditor;

    //This will allow us to validate from the @Valid
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);

        //To manually bind/parse our FechaNacimiento(Date)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

        //Using our own filter
        binder.registerCustomEditor(String.class, "nombre" ,new NombreMayusculaEditor());
        binder.registerCustomEditor(String.class, "apellido" ,new NombreMayusculaEditor());

        binder.registerCustomEditor(Pais.class, "pais" ,paisEditor);
        binder.registerCustomEditor(Role.class, "roles" ,rolesEditor);
    }

    @ModelAttribute("genero")
    public List<String> genero(){
        return Arrays.asList("Masculino", "Feminino");
    }

    @ModelAttribute("listaRoles")
    public List<Role> listaRoles() {
        return this.roleService.listar();
    }

    //"paises" is how we are sending it to the View
    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises(){
        return paisService.listar();
    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRolesString(){
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");

        return roles;
    }

    @ModelAttribute("listaRolesMap")
    public Map<String, String> listaRolesMap(){
        Map<String, String> roles = new HashMap<String, String>();
        roles.put("ROLE_ADMIN", "Administrador");
        roles.put("ROLE_USER", "Usuario");
        roles.put("ROLE_MODERATOR", "Moderador");

        return roles;
    }

    //"paises" is how we are sending it to the View
    @ModelAttribute("paises")
    public List<String> paises(){
        return Arrays.asList("España", "Mexico", "Chile", "Argentina", "Colombia");
    }

    //"paisesMap" is how we are sending it to the View
    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap(){
        Map<String, String> paisesMap = new HashMap<String, String>();
        paisesMap.put("ES", "España");
        paisesMap.put("MX", "Mexico");
        paisesMap.put("CL", "Chile");
        paisesMap.put("AR", "Argentina");
        paisesMap.put("CO", "Colombia");

        return paisesMap;
    }


    //To load the info into the form/browser
    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Aleph");
        usuario.setApellido("Baron");
        usuario.setId("123.456.789-K");
        usuario.setHabilitar(true);
        model.addAttribute("titulo", "Formulario usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    //We can map the "usuario" with the form since it has the exact same attributes in the class and form.html
    //@Valid validates the attributes of "usuario" and BindingResult will provide us the result of that validation
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status){

        //validator.validate(usuario, result);

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
