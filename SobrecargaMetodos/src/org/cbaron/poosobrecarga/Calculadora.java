package org.cbaron.poosobrecarga;

public class Calculadora {

    private Calculadora() {
    }

    // Using varargs to implement a simplified version of a method with different arguments
    public static int sumar(int... argumantos) {
        int total = 0;

        for (int i: argumantos) {
            total += i;
        }

        return total;
    }

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static float sumar(float a, float b) {
        return a + b;
    }

    public static float sumar(int i, float j) {
        return i + j;
    }

    public static float sumar(float i, int j) {
        return i + j;
    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static int sumar(String a, String b) {
        int resultado;

        try {
            resultado = Integer.parseInt(a) + Integer.parseInt(b);
        }catch (NumberFormatException e){
            resultado = 0;
        }
        return resultado;
    }

    public static int sumar(int a, int b, int c) {
        return a + b + c;
    }
}