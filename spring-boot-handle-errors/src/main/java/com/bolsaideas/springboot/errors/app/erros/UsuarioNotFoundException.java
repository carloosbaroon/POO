package com.bolsaideas.springboot.errors.app.erros;

public class UsuarioNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 767754767738180500L;

    public UsuarioNotFoundException(String id) {
        super("Usuario con ID: ".concat(id).concat(" no existe en el sistema"));
    }
}
