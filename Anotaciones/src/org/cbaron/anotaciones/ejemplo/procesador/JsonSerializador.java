package org.cbaron.anotaciones.ejemplo.procesador;

import org.cbaron.anotaciones.ejemplo.Init;
import org.cbaron.anotaciones.ejemplo.JsonAtributo;
import org.cbaron.anotaciones.ejemplo.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializador {

    public static void inicializarObjecto(Object object){
        if(Objects.isNull(object)){
            throw new JsonSerializadorException("El objeto no puede ser nulo");
        }

        Method[] metodos = object.getClass().getDeclaredMethods();
        Arrays.stream(metodos).filter(m -> m.isAnnotationPresent(Init.class))
                .forEach(m -> {
                    m.setAccessible(true);
                    try {
                        m.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializadorException("Error al serializar, no se puede iniciar el objeto"
                                + e.getMessage());
                    }
                });
    }

    public static String convertirJson(Object object){

        if(Objects.isNull(object)){
            throw new JsonSerializadorException("El objeto no puede ser nulo");
        }
        inicializarObjecto(object);
        Field[] atributos = object.getClass().getDeclaredFields();
        return Arrays.stream(atributos)
                .filter(f -> f.isAnnotationPresent(JsonAtributo.class))
                .map(f -> {
                    f.setAccessible(true);
                    String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("")
                            ? f.getName()
                            :  f.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        Object value = f.get(object);
                        if(f.getAnnotation(JsonAtributo.class).capitalizar()
                        && value instanceof String){
                            String newValue = (String) value;
                            newValue = Arrays.stream(newValue.split(" "))
                                    .map(palabra -> palabra.substring(0,1).toUpperCase()
                                    + palabra.substring(1).toLowerCase())
                                    .collect(Collectors.joining(" "));
                            f.set(object, newValue);
                        }
                        return "\"" + nombre + "\":\"" + f.get(object) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializadorException("Error al serializar el json " + e.getMessage());
                    }
                })
                .reduce("{", (a, b) -> {
                    if("{".equals(a)) {
                        return a + b;
                    }
                    return a + "," + b;
                }).concat("}");
    }
}
