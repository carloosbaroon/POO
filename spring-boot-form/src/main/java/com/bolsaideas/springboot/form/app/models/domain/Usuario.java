package com.bolsaideas.springboot.form.app.models.domain;

//This is an entity or POJO
//We mustn't inject these values
public class Usuario {

    //This attributes should match the ones in our views (html)
    private String username;
    private String password;
    private String email;

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
