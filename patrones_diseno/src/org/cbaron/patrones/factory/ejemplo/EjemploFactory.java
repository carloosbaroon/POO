package org.cbaron.patrones.factory.ejemplo;

import org.cbaron.patrones.factory.PizzaProducto;
import org.cbaron.patrones.factory.PizzeriaCaliforniaFactory;
import org.cbaron.patrones.factory.PizzeriaNewYorkFactory;
import org.cbaron.patrones.factory.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzeriaZonaAbstractFactory nyPizzeria = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory californiaPizzeria = new PizzeriaCaliforniaFactory();

        PizzaProducto pizza = californiaPizzeria.ordenarPizza("queso");
        System.out.println("Aleph ordena la pizza: " + pizza.getNombre());

        pizza = nyPizzeria.ordenarPizza("pepperoni");
        System.out.println("Carlos ordena la pizza: " + pizza.getNombre());

        pizza = californiaPizzeria.ordenarPizza("vegetariana");
        System.out.println("Aleph ordena la pizza: " + pizza.getNombre());

        pizza = nyPizzeria.ordenarPizza("vegetariana");
        System.out.println("Carlos ordena la pizza: " + pizza.getNombre());

        pizza = californiaPizzeria.ordenarPizza("pepperoni");
        System.out.println("Aleph ordena la pizza: " + pizza.getNombre());

        System.out.println("pizza = " + pizza);
    }
}
