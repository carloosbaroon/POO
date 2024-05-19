package org.cbaron.api.stream.ejemplos;

import org.cbaron.api.stream.ejemplos.models.Factura;
import org.cbaron.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {

        Usuario u1 = new Usuario("Aleph", "Baron");
        Usuario u2 = new Usuario("Carlos", "Baron");

        u1.addFactura(new Factura("Compras tecnologia"));
        u1.addFactura(new Factura("Compras muebles"));

        u2.addFactura(new Factura("Bicicleta"));
        u2.addFactura(new Factura("Laptop"));

        List<Usuario> usuarios = Arrays.asList(u1, u2);

        usuarios.stream().flatMap(u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion().concat(" : Cliente ")
                        .concat(f.getUsuario().toString())));
    }
}
