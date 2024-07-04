package com.bolsaideas.springboot.form.app.services;

import com.bolsaideas.springboot.form.app.models.domain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> listar();
    public Role buscar(Integer id);
}
