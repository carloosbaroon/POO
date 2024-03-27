package org.cbaron.herencia;

public class Alumno extends Persona {
    private String institucion;
    private double notaMatematicas;
    private double notaLenguaje;
    private double notaIngles;

    public Alumno() {
        System.out.println("Alumno: Inicializando constructor");
    }

    public Alumno(String nombre, String apellido) {
        super(nombre, apellido);
    }
    
    public Alumno(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }
    
    public Alumno(String nombre, String apellido, int edad, String institucion) {
        //Here we could also use this() to call the constructor of this class with 3 parameters
        super(nombre, apellido, edad);
        this.institucion = institucion;
    }

    public Alumno(String nombre, String apellido, int edad, String institucion, double notaMatematicas, double notaIngles, double notaLenguaje) {
        this(nombre, apellido, edad, institucion);
        this.notaMatematicas = notaMatematicas;
        this.notaLenguaje = notaLenguaje;
        this.notaIngles = notaIngles;
    }


    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public double getNotaMatematica() {
        return notaMatematicas;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematicas = notaMatematica;
    }

    public double getNotaLenguaje() {
        return notaLenguaje;
    }

    public void setNotaLenguaje(double notaLenguaje) {
        this.notaLenguaje = notaLenguaje;
    }

    public double getNotaIngles() {
        return notaIngles;
    }

    public void setNotaIngles(double notaIngles) {
        this.notaIngles = notaIngles;
    }

    @Override
    public String saludar() {
        String saludar = super.saludar();
        return saludar + "soy un alumno y mi nombre es: " + getNombre();
    }

    public double calcularPromedio() {
        //System.out.println("calcularPromedio " + Alumno.class.getCanonicalName());
        return (notaIngles + notaLenguaje + notaMatematicas)/3;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ninstitucion='" + institucion + '\'' +
                ", notaMatematicas=" + notaMatematicas +
                ", notaLenguaje=" + notaLenguaje +
                ", notaIngles=" + notaIngles +
                ", promedio=" + this.calcularPromedio();
    }
}
