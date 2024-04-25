package org.cbaron.ejemplos.tarea;

import java.util.Date;

public class Vuelo {

    private String nombre;
    private String origen;
    private String destino;
    private Date fechayHoraLlegada;
    private int numeroPasajeros;

    public Vuelo(String nombre, String origen, String destino, Date fechayHoraLlegada, int numeroPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechayHoraLlegada = fechayHoraLlegada;
        this.numeroPasajeros = numeroPasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public Date getFechayHoraLlegada() {
        return fechayHoraLlegada;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    @Override
    public String toString() {
        return "Vuelo: " + "nombre=" + nombre + ", origen=" + origen + ", destino=" + destino + ", fechayHoraLlegada=" + fechayHoraLlegada + ", numeroPasajeros=" + numeroPasajeros;
    }
}
