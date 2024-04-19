package org.cbaron.excepciones.ejemplo;

public class Calculadora {

    public double dividir(int numerador, int denominador) throws DivisionPorCeroException {
        if (denominador == 0) {
            throw new DivisionPorCeroException("No de puede dividir por cero!");
        }
        return numerador /(double)denominador;
    }

    public double dividir(String numerador, String denominador)
            throws DivisionPorCeroException, FormatoNumeroException {
        try {
            int numeradorInt = Integer.parseInt(numerador);
            int denominadorInt = Integer.parseInt(denominador);
            return this.dividir(numeradorInt, denominadorInt);
        } catch (NumberFormatException e) {
            throw new FormatoNumeroException("Debe ingresar un numero para numerador y denomidor");
        }
    }
}
