package org.cbaron.poointerfaces.imprenta.modelo;

public interface Imprimible {

    String VALOR_DEFECTO = "Imprimiendo un valor por defecto";

    default String imprimir() {
        return VALOR_DEFECTO;
    }
}
