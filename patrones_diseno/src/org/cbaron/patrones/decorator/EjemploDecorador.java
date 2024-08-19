package org.cbaron.patrones.decorator;

import org.cbaron.patrones.decorator.decorador.MayusculasDecorador;
import org.cbaron.patrones.decorator.decorador.ReversaDecorador;
import org.cbaron.patrones.decorator.decorador.SubrayadoDecorador;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola que tal Aleph");

        MayusculasDecorador mayusculasDecorador = new MayusculasDecorador(texto);
        ReversaDecorador reversaDecorador = new ReversaDecorador(mayusculasDecorador);
        SubrayadoDecorador subrayadoDecorador = new SubrayadoDecorador(reversaDecorador);

        System.out.println("subrayadoDecorador.darFormato() = " + subrayadoDecorador.darFormato());
    }
}
