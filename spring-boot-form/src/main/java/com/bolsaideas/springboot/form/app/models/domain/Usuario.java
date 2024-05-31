package com.bolsaideas.springboot.form.app.models.domain;

import jakarta.validation.constraints.*;

//This is an entity or POJO
//We mustn't inject these values
public class Usuario {

    //@Pattern(regexp = "[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")
    private String id;

    //This attributes should match the ones in our views (html)
    //@NotEmpty(message = "nombre can not be empty")
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
