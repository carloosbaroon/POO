package com.bolsaideas.springboot.web.app.controllers;

import com.bolsaideas.springboot.web.app.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
//Agregando una ruta base al controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    //Agregando una ruta al metodo i.e./app/index...
    @GetMapping({"/index", "/", "/home"})
    public String index(Model model){
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Aleph");
        usuario.setApellido("Baron");
        usuario.setEmail("aleph@gmail.com");

        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
        model.addAttribute("usuario", usuario);

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){

        model.addAttribute("titulo", textoListar);
        return "listar";
    }

    //usuarios will be available in all the views "/listar", "/perfil", etc from this controller
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(new Usuario("Aleph", "Baron", "aleph@gmail.com"),
                new Usuario("Carlos", "Baron", "carlos@gmail.com"),
                new Usuario("Luis", "Baron", "luis@gmail.com"),
                new Usuario("John", "Doe", "john@gmail.com"));

        return usuarios;
    }
}
