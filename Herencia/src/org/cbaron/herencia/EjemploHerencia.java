package org.cbaron.herencia;

public class EjemploHerencia {
    public static void main(String[] args) {
        System.out.println("=============== Creando la instancia de Alumno ===============");
        Alumno alumno = new Alumno();
        System.out.println("=============== Creando la instancia de Profesor ===============");
        Profesor profesor = new Profesor();
        System.out.println("=============== Creando la instancia de AlumnoInt ===============");
        AlumnoInternacional alumnoInt = new AlumnoInternacional();

        System.out.println("==============================");

        alumno.setNombre("Carlos");
        alumno.setApellido("Baron");
        alumno.setNotaLenguaje(5.5);
        alumno.setNotaIngles(3.0);
        alumno.setNotaMatematica(6.0);

        profesor.setNombre("Aleph");
        profesor.setApellido("Baron");
        profesor.setAsignatura("Matematicas");

        // Alumno has access to all the public/protected methods&attributes of its hierarchy -> Alumno & Persona
        alumnoInt.setNombre("Andy");
        alumnoInt.setApellido("Bear");
        alumnoInt.setPais("Inglaterra");
        alumnoInt.setEdad(20);
        alumnoInt.setInstitucion("Instituto Nacional");
        alumnoInt.setNotaLenguaje(6.5);
        alumnoInt.setNotaIngles(6.0);
        alumnoInt.setNotaMatematica(6.0);
        alumnoInt.setNotaIdiomas(6.5);


        System.out.println(alumno.getNombre() + " " + alumno.getApellido());
        System.out.println(alumnoInt.getNombre() + " " + alumnoInt.getApellido() + " " + alumnoInt.getPais());
        System.out.println("Profesor " + profesor.getAsignatura() + ": " + profesor.getNombre() );

        Class claseAlumnoInt = alumnoInt.getClass();

        while(claseAlumnoInt.getSuperclass() != null) {
            String hija = claseAlumnoInt.getName();
            String padre = claseAlumnoInt.getSuperclass().getName();

            System.out.println(hija + " es una clase hija de la clase padre: " + padre);
            claseAlumnoInt = claseAlumnoInt.getSuperclass();

        }

    }
}