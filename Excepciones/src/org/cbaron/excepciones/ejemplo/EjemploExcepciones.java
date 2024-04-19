package org.cbaron.excepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        Calculadora cal =new Calculadora();
        String numerador = JOptionPane.showInputDialog("Ingrese un entero numerador:");
        String denominador = JOptionPane.showInputDialog("Ingrese un entero denominador:");
        int divisor;
        double division;

        try {
            //divisor = Integer.parseInt(valor);
            //division = cal.dividir(10, divisor);
            //System.out.println(division);

            double division2 = cal.dividir(numerador, denominador);
            System.out.println(division2);
        } catch (NumberFormatException ne) {
            System.out.println("Ingresa un valor numerico: " + ne.getMessage());
            main(args);
        } catch (DivisionPorCeroException ae) {
            System.out.println("Capturatmos excepcion en ejecucion: " + ae.getMessage());
            main(args);
        } catch (FormatoNumeroException e) {
            System.out.println("Se detecto una excepcion, Ingrese un numero valido " + e.getMessage());
            e.printStackTrace(System.out);
            main(args);
        } finally {
            System.out.println("Finalizado");
        }

        System.out.println("Continuamos con ejecucion");

    }
}
