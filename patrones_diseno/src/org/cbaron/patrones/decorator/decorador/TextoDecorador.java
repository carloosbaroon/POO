package org.cbaron.patrones.decorator.decorador;

import org.cbaron.patrones.decorator.Formateable;

abstract public class TextoDecorador implements Formateable {

    protected Formateable texto;

    public TextoDecorador(Formateable texto) {
        this.texto = texto;
    }
}
