package org.cbaron.patrones.factory.producto;

import org.cbaron.patrones.factory.PizzaProducto;

public class PizzaCaliforniaPepperoni extends PizzaProducto {

    public PizzaCaliforniaPepperoni() {
        super();
        nombre = "Pizza California Pepperoni";
        masa = "Masa a la piedra gruesa";
        salsa = "Salsa BBQ light";
        ingredientes.add("extra queso mozzarella");
        ingredientes.add("Pepperoni");
        ingredientes.add("Aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 50min. a 55C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequenos rectangulos");
    }
}
