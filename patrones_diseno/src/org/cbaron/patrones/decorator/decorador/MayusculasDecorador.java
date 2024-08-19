package org.cbaron.patrones.decorator.decorador;

import org.cbaron.patrones.decorator.Formateable;

public class MayusculasDecorador extends TextoDecorador{


    public MayusculasDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().toUpperCase();
    }
}
