package org.cbaron.patrones.factory;

abstract public class PizzeriaZonaAbstractFactory {

    public PizzaProducto ordenarPizza(String tipo){
        PizzaProducto pizza = crearPizza(tipo);

        System.out.println("------------- Fabricando la pizza ------------- " + pizza.getNombre() + " -------------");
        pizza.preparar();
        pizza.cocinar();
        pizza.cocinar();
        pizza.empaquetar();

        return pizza;
    }

    abstract PizzaProducto crearPizza(String tipo);

}
