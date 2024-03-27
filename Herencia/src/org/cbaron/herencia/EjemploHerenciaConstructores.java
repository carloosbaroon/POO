package org.cbaron.herencia;

public class EjemploHerenciaConstructores {
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
        System.out.println("Imprimiendo Persona:");
        System.out.println("Nombre: " + persona.getNombre()
                + ", Apellido: " + persona.getApellido()
                + ", Edad: " + persona.getEdad()
                + ", Email: " + persona.getEmail());
        if (persona instanceof Alumno) {
            System.out.println("Imprimiendo Alumno:");
            System.out.println("Institucion: " + ((Alumno) persona).getInstitucion());
            System.out.println("Nota matematicas: " + ((Alumno) persona).getNotaMatematica());
            System.out.println("Nota Lenguaje: " + ((Alumno) persona).getNotaLenguaje());

            if (persona instanceof AlumnoInternacional) {
                System.out.println("Imprimiendo AlumnoInternacional:");
                System.out.println("Notas idiomas: " + ((AlumnoInternacional) persona).getNotaLenguaje());
                System.out.println("Pais: " + ((AlumnoInternacional) persona).getPais());
            }
            System.out.println("=============Sobre escritura calcularPromedio()=================");
            System.out.println("Promedio:" + ((Alumno) persona).calcularPromedio());
        }

        if (persona instanceof Profesor) {
            System.out.println("Imprimiendo Profesor:");
            System.out.println("Asignatura: " + ((Profesor) persona).getAsignatura());
        }
        System.out.println("=============Sobre escritura saludar()=================");
        System.out.println(persona.saludar());

        System.out.println("==============================");
    }
}