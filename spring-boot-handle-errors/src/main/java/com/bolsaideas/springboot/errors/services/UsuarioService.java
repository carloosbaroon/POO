package com.bolsaideas.springboot.errors.services;

import com.bolsaideas.springboot.errors.app.models.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> listar();
    public Usuario obtenerPorId(Integer id);
}
