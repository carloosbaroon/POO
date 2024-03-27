package org.cbaron.herencia.tareas.personasCampania;

public class EjemploPersonaCampania {

    public static void main(String[] args) {
        Gerente gerente = new Gerente(57000.00, 25, 2000.00, "12.345.678-9", "John", "Roe", "Agustinas 2233");
        gerente.aumentarRemuneracion(15);
        gerente.setPresupuesto(77000.00);
        System.out.println(gerente);
    }
}
