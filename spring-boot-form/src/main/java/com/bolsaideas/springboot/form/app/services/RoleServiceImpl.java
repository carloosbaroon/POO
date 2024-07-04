package com.bolsaideas.springboot.form.app.services;

import com.bolsaideas.springboot.form.app.models.domain.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private List<Role> roles;

    public RoleServiceImpl() {
        this.roles = new ArrayList<Role>();
        this.roles.add(new Role(1, "Administrador", "ROLE_ADMIN"));
        this.roles.add(new Role(2, "Usuario", "ROLE_USER"));
        this.roles.add(new Role(3, "Moderador", "ROLE_MODERATOR"));
    }

    @Override
    public List<Role> listar() {
        return roles;
    }

    @Override
    public Role buscar(Integer id) {
        Role resultado = null;
        for (Role role : roles) {
            if (id == role.getId()) {
                resultado = role;
                break;
            }
        }
        return resultado;
    }
}
