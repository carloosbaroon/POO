package org.cbaron.patrones.factory.producto;

import org.cbaron.patrones.factory.PizzaProducto;

public class PizzaNewYorkItaliana extends PizzaProducto {

    public PizzaNewYorkItaliana() {
        super();
        nombre = "Pizza Italiana New York";
        masa = "Masa gruesa";
        salsa = "Salsa de tomate italiano con carne";
        ingredientes.add("Queso mozzarella");
        ingredientes.add("Jamon");
        ingredientes.add("Aceitunas");
        ingredientes.add("Chorizo");
        ingredientes.add("Champinones");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 30min. a 120C");

    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triangulos grandes");
    }
}
