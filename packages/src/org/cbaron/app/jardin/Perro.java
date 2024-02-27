package org.cbaron.app.jardin;

import org.cbaron.app.hogar.Persona;

public class Perro {
    protected String nombre;
    protected String raza;

    String jugar(Persona persona){
        return persona.lanzarPelota();
    }
}