package org.cbaron.poointerfaces.imprenta.tarea;

public abstract class Producto implements IProducto{

    private int precio;

    public Producto(int precio) {
        this.precio = precio;
    }

    @Override
    public int getPrecio() {
        return precio;
    }
}
