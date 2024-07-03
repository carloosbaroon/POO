package com.bolsaideas.springboot.form.app.services;

import com.bolsaideas.springboot.form.app.models.domain.Pais;

import java.util.List;

public interface PaisService {

    public List<Pais> listar();
    public Pais buscar(Integer id);
}
