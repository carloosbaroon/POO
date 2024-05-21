package org.cbaron.anotaciones.ejemplo;


import java.lang.annotation.*;

@Documented
//A quien se le va a aplicar esta anotacion
@Target(ElementType.FIELD)
//En que contexto se va a ejecutar
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAtributo {
    String nombre() default "";
    boolean capitalizar() default false;
}
