package org.cbaron.herencia.tareas.personasCampania;

public class PersonaCampania {
    private String numeroFiscal;
    private String nombre;
    private String apellido;
    private String direccion;

    public PersonaCampania(String numeroFiscal, String nombre, String apellido, String direccion) {
        this.numeroFiscal = numeroFiscal;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public String getNumeroFiscal() {
        return numeroFiscal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "numeroFiscal=" + numeroFiscal + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion;
    }
}
