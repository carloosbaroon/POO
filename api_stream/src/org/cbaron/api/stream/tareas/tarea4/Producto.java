package org.cbaron.api.stream.tareas.tarea4;

public class Producto {
    private double precio;
    private double cantidad;

    public Producto(double precio, double cantidad) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public double getCantidad() {
        return cantidad;
    }
}
