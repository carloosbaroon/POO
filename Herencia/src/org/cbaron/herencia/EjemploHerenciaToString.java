package org.cbaron.herencia;

public class EjemploHerenciaToString {
    public static void main(String[] args) {
        System.out.println("=============== Creando la instancia de Alumno ===============");
        Alumno alumno = new Alumno("Carlos", "Baron", 26, "Instituto Nacional");
        alumno.setNotaLenguaje(5.5);
        alumno.setNotaIngles(3.0);
        alumno.setNotaMatematica(6.0);
        alumno.setEmail("carlos@email.com");

        System.out.println("=============== Creando la instancia de Profesor ===============");
        Profesor profesor = new Profesor("Aleph", "Baron", "Matematicas");
        profesor.setEdad(47);
        profesor.setEmail("aleph@email.com");

        System.out.println("=============== Creando la instancia de AlumnoInt ===============");
        AlumnoInternacional alumnoInt = new AlumnoInternacional("Andy", "Bear", "Inglaterra");
        alumnoInt.setEdad(20);
        alumnoInt.setInstitucion("Instituto Nacional");
        alumnoInt.setNotaLenguaje(6.5);
        alumnoInt.setNotaIngles(6.0);
        alumnoInt.setNotaMatematica(6.0);
        alumnoInt.setNotaIdiomas(6.5);
        alumnoInt.setEmail("andy@email.com");

        System.out.println("==============================");
        imprimir(alumno);
        imprimir(profesor);
        imprimir(alumnoInt);

    }

    public static void imprimir(Persona persona) {
        System.out.println("==============================");
        System.out.println(persona.toString());
    }
}