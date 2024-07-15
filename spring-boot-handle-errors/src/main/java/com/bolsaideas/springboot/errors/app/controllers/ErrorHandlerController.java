package com.bolsaideas.springboot.errors.app.controllers;

import com.bolsaideas.springboot.errors.app.erros.UsuarioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ArithmeticException.class)
    public String arithmeticError(ArithmeticException ex, Model model) {
        model.addAttribute("error", "Error de aritmetica");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        //Here we could use the "generic" template
        return "error/arithmetic";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String numberFormatError(NumberFormatException ex, Model model){
        model.addAttribute("error", "Formato numero invalido!");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        //Here we could use the "generic" template
        return "error/number-format";
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public String usuarioNotFound(UsuarioNotFoundException ex, Model model){
        model.addAttribute("error", "Usuario no encontrado");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        //Here we could use the "generic" template
        return "error/generic";
    }
}
