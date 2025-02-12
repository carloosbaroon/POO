package com.bolsaideas.springboot.errors.app.services;

import com.bolsaideas.springboot.errors.app.models.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario> listar();
    public Usuario obtenerPorId(Integer id);
    public Optional<Usuario> obtenerPorIdOptional(Integer id);
}
