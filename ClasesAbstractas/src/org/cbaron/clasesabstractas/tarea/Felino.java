package org.cbaron.clasesabstractas.tarea;

abstract public class Felino extends Mamifero{

    protected float tamanoGarras;
    protected int velocidad;

    public Felino(float tamanoGarras, int velocidad, String habitat, float altura, float largo, float peso) {
        super(habitat, altura, largo, peso);
        this.tamanoGarras = tamanoGarras;
        this.velocidad = velocidad;
    }

    public float getTamanoGarras() {
        return tamanoGarras;
    }

    public int getVelocidad() {
        return velocidad;
    }
}