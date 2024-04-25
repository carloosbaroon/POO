package org.cbaron.ejemplos.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EjemploHashMap {
    public static void main(String[] args) {

        Map<String, Object> persona = new HashMap<>();

        System.out.println("Contiene elementos:" + !persona.isEmpty());

        persona.put(null, "123");

        persona.put("nombre", "Aleph");
        persona.put("apellido", "Baron");
        persona.put("correo", "aleph.b@email.com");
        persona.put("Edad", "9");

        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        persona.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("numero", "55555555");

        persona.put("direccion", direccion);

        System.out.println("persona: " + persona);

        String nombre = (String) persona.get("nombre");
        System.out.println("nombre: " + nombre);

        Map<String, String> direccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = direccionPersona.get("pais");
        String estado = direccionPersona.get("estado");
        String ciudad = direccionPersona.get("ciudad");
        String barrio = direccionPersona.getOrDefault("barrio", "La Playa");
        System.out.println("El pais de:" + nombre + " es: " + pais);
        System.out.println("El estado de:" + nombre + " es: " + estado);
        System.out.println("La ciudad de:" + nombre + " es: " + ciudad);
        System.out.println("El barrio de:" + nombre + " es: " + barrio);

        String valorCorreo = (String) persona.remove("correo");
        System.out.println("Eliminado correo: " + valorCorreo);
        System.out.println("persona: " + persona);

        boolean b = persona.containsKey("correo");
        System.out.println("b: " + b);

        boolean b2 = persona.containsValue("aleph.b@email.com");
        System.out.println("b2: " + b2);

        Collection<Object> valores = persona.values();
        for (Object valor : valores) {
            System.out.println("valor: " + valor);
        }

        Set<String> llaves = persona.keySet();
        for (String llave : llaves) {
            Object valor = persona.get(llave);
            if (valor instanceof Map) {
                Map<String, String> direccionMap = (Map<String, String>) valor;

                for (Map.Entry<String, String> entry : direccionMap.entrySet()) {
                    System.out.println("KEY: " + entry.getKey() + " value: " + entry.getValue());
                }
                System.out.println("El pais de: " + persona.get("nombre") + " es: " + direccionMap.get("pais"));
                System.out.println("El estado es: " + direccionMap.get("estado"));
                System.out.println("La ciudad es: " + direccionMap.get("ciudad"));
                System.out.println("La calle es: " + direccionMap.get("calle"));
                System.out.println("El numero es: " + direccionMap.get("numero"));

            } else {
                System.out.println("llave: " + llave);
            }

        }

        for (Map.Entry<String, Object> par : persona.entrySet()) {
            System.out.println(par.getKey() + ": " + par.getValue());
        }

        for (String llave : persona.keySet()) {
            Object valor = persona.get(llave);
            System.out.println(llave + " => " + valor);
        }
        //Usando expresiones lambda
        persona.forEach((k, v) -> System.out.println(k + " => " + v));

        System.out.println("Total: " + persona.size());
        System.out.println("Contiene elementos:" + !persona.isEmpty());

        persona.replace(null, "4321");
        System.out.println(persona);

    }
}
