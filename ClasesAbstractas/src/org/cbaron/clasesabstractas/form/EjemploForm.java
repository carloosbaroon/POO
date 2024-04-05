package org.cbaron.clasesabstractas.form;

import org.cbaron.clasesabstractas.form.elementos.ElementoForm;
import org.cbaron.clasesabstractas.form.elementos.InputForm;
import org.cbaron.clasesabstractas.form.elementos.SelectForm;
import org.cbaron.clasesabstractas.form.elementos.TextareaForm;
import org.cbaron.clasesabstractas.form.elementos.select.Opcion;
import org.cbaron.clasesabstractas.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());
        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));
        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());
        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());
        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());
        Opcion java = new Opcion("1", "Java");

        lenguaje.addOpcion(java)
            .addOpcion(new Opcion("2", "Python"))
            .addOpcion(new Opcion("3", "JavaScript"))
            .addOpcion(new Opcion("4", "TypeScript"));

        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='" +this.nombre+"' value=" +this.valor+">";
            }
        };
        saludar.setValor("Hola que tal este campo esta deshabilitado");
        username.setValor("carlos.baron");
        password.setValor("12345");
        email.setValor("cbarontest.com");
        edad.setValor("25");
        experiencia.setValor("...mucha experiencia...");
        java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(username,
                password,
                email,
                edad,
                experiencia,
                lenguaje,
                saludar);

        for (ElementoForm e: elementos) {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }
        elementos.forEach(e -> {
            if (!e.esValido()){
                e.getErrores().forEach(System.out::println);
            }
        });

    }
}
