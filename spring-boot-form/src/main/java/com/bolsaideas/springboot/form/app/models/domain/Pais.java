package com.bolsaideas.springboot.form.app.models.domain;

public class Pais {

    private Integer id;
    private String codigo;
    private String nombre;

    public Pais() {
    }

    public Pais(Integer id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //We do this so ThymeLeaf can compare the th:value="${pais.id} instead of the complete object Pais
    @Override
    public String toString() {
        return this.id.toString();
    }
}
