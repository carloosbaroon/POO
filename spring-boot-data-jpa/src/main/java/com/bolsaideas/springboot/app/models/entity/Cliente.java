package com.bolsaideas.springboot.app.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//With @Entity, we specify this is a POJO class
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    //Serialize an attribute means convert it to some bytes and transfer it using JSON, HTTP sessions, DBs, etc.
    private static final long serialVersionUID = 9159025912261177506L;

    @Id
    //We use IDENTITY Because for this project we are using H2/MySQL
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //So we can customize the name of the field in the DB
    // @Column(name = "nombre_cliente", length = "")
    @NotEmpty
    @Size(min = 3, max = 12)
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    /*@PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }*/

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
