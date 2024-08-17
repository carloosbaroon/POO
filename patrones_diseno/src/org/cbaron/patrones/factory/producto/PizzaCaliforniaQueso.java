package org.cbaron.patrones.factory.producto;

import org.cbaron.patrones.factory.PizzaProducto;

public class PizzaCaliforniaQueso extends PizzaProducto {

    public PizzaCaliforniaQueso() {
        super();
        nombre = "Pizza California Queso";
        masa = "Masa delgada a la piedra";
        salsa = "Salsa tomate rucula";
        ingredientes.add("Extra Queso mozzarella");
        ingredientes.add("Cebolla");
        ingredientes.add("Queso azul");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando a 35min. a 100C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequenos triangulos");
    }
}
