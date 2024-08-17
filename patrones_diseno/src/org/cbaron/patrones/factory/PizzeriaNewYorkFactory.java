package org.cbaron.patrones.factory;

import org.cbaron.patrones.factory.producto.PizzaNewYorkItaliana;
import org.cbaron.patrones.factory.producto.PizzaNewYorkPeperoni;
import org.cbaron.patrones.factory.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {

        return switch (tipo) {
            case "vegetariana" -> new PizzaNewYorkVegetariana();
            case "pepperoni" -> new PizzaNewYorkPeperoni();
            case "italiana" -> new PizzaNewYorkItaliana();
            default -> null;
        };
    }
}
