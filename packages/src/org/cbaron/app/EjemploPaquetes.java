package org.cbaron.app;

import org.cbaron.app.hogar.Gato;
import org.cbaron.app.hogar.Persona;

public class EjemploPaquetes {
    public static void main(String[] args) {

        Persona p = new Persona();
        p.nombre = "Carlos";
        System.out.println("p.nombre = " + p.nombre);

        Gato g = new Gato();
    }
}
