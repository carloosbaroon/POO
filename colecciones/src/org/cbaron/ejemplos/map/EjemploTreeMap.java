package org.cbaron.ejemplos.map;

import java.util.*;

public class EjemploTreeMap {
    public static void main(String[] args) {

        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length).reversed());

        //In TreeMaps we can't have null values
        //persona.put(null, "123");

        persona.put("nombre", "Aleph");
        persona.put("apellido", "Baron");
        persona.put("email", "aleph.b@email.com");
        persona.put("edad", "9");

        Map<String, String> direccion = new TreeMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        persona.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("numero", "55555555");

        persona.put("direccion", direccion);

        System.out.println("Persona: " + persona);

        for (Map.Entry<String, Object> entry : persona.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
