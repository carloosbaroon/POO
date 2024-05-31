package com.bolsaideas.springboot.form.app.validation;

import com.bolsaideas.springboot.form.app.models.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//So we can inject it in the future
@Component
public class UsuarioValidator implements Validator {

    //Here we specify the class to validate
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.usuario.nombre");

        if(!usuario.getId().matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")) {
            errors.rejectValue("id", "Pattern.usuario.id");
        }
    }
}
