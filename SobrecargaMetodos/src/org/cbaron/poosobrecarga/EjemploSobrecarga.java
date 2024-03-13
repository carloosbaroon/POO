package org.cbaron.poosobrecarga;

public class EjemploSobrecarga {
    public static void main(String[] args) {

        System.out.println("Sumar int : " + Calculadora.sumar(10, 5));
        System.out.println("Sumar float : " + Calculadora.sumar(10.0F, 5.0F));
        System.out.println("Sumar float-int : " + Calculadora.sumar(10.0F, 5));
        System.out.println("Sumar int : " + Calculadora.sumar(10, 5, 5,6,7));
    }
}
