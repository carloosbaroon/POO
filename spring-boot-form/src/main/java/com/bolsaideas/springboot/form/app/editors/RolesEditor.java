package com.bolsaideas.springboot.form.app.editors;

import com.bolsaideas.springboot.form.app.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class RolesEditor extends PropertyEditorSupport {

    @Autowired
    private RoleService roleService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Integer id = Integer.parseInt(text);
            setValue(roleService.buscar(id));
        } catch (NumberFormatException e) {
            setValue(null);
        }
    }
}
