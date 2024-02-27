package org.cbaron.app.jardin;

import static org.cbaron.app.hogar.ColorPelo.*;
import org.cbaron.app.hogar.Persona;
import static org.cbaron.app.hogar.Persona.saludar;
import static org.cbaron.app.hogar.Persona.GENERO_FEMENINO;
import static org.cbaron.app.hogar.Persona.GENERO_MASCULINO;

public class EjemploPaquetes {
    public static void main(String[] args) {

        Persona p = new Persona();
        p.setNombre("Carlos");
        p.setApellido("Baron");
        System.out.println("p.nombre = " + p.getNombre());
        p.setColorPelo(CAFE);

        Perro perro = new Perro();
        
        perro.nombre = "Aleph";
        perro.raza = "Bulldog";
        
        String jugando = perro.jugar(p);
        System.out.println("jugando = " + jugando);

        String saludo = saludar();
        System.out.println("saludo = " + saludo);

        String generoMujer = GENERO_FEMENINO;
        String generoMasculino = GENERO_MASCULINO;
    }
}
