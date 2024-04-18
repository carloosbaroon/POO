package org.cbaron.genericsclass;

public class EjemploGenericos {

    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Caballo1", "Caballo"));
        transporteCaballos.add(new Animal("Caballo2", "Caballo"));
        transporteCaballos.add(new Animal("Caballo3", "Caballo"));
        transporteCaballos.add(new Animal("Caballo4", "Caballo"));
        transporteCaballos.add(new Animal("Caballo5", "Caballo"));

        Camion<Maquinaria> transporteMaquinas = new Camion<>(3);
        transporteMaquinas.add(new Maquinaria("Bulldozer"));
        transporteMaquinas.add(new Maquinaria("Bulldozer1"));
        transporteMaquinas.add(new Maquinaria("Bulldozer2"));

        Camion<Automovil> transporteAutomovil = new Camion<>(4);
        transporteAutomovil.add(new Automovil("Audi"));
        transporteAutomovil.add(new Automovil("Audi2"));
        transporteAutomovil.add(new Automovil("Audi3"));
        transporteAutomovil.add(new Automovil("Audi4"));

        ImprimirCamion(transporteCaballos);
        ImprimirCamion(transporteMaquinas);
        ImprimirCamion(transporteAutomovil);
    }

    public static <T> void ImprimirCamion(Camion<T> camion) {
        for (T a : camion) {
            if (a instanceof Animal) {
                System.out.println(((Animal)a).getNombre() + " tipo: " + ((Animal)a).getTipo());
            } else if (a instanceof Maquinaria) {
                System.out.println(((Maquinaria)a).getTipo());
            } else if (a instanceof Automovil) {
                System.out.println(((Automovil)a).getMarca());
            }
        }

    }
}
