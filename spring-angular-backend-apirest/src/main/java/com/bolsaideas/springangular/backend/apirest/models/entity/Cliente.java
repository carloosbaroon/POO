package com.bolsaideas.springangular.backend.apirest.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 7210048016850072064L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 4, max = 12, message = "El tamaño debe de estar entre 4 y 12 caracteres")
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 4, max = 12, message = "El tamaño debe de estar entre 4 y 12 caracteres")
    private String apellido;

    @NotEmpty(message = "No puede estar vacio")
    @Email(message = "No es una direccion de correo bien formada")
    @Column(nullable = false)
    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    public void prePersist(){
        this.createAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
