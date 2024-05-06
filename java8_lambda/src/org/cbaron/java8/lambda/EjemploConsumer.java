package org.cbaron.java8.lambda;

import org.cbaron.java8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {

        Consumer<Date> consumidor = fecha -> {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(formato.format(fecha));
        };

        consumidor.accept(new Date());

        BiConsumer<String, Integer> biConsumidor = (nombre, edad) -> {
            System.out.println("nombre: " + nombre + ", edad: " + edad);
        };

        biConsumidor.accept("Aleph", 9);

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola mundo!");

        List<String> nombres = Arrays.asList("Aleph", "Carlos", "Andres");
        nombres.forEach(consumidor2);

        Supplier<Usuario> supplierUsuario = Usuario::new;
        Usuario usuario = supplierUsuario.get();

        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;

        asignarNombre.accept(usuario, "Aleph");
        System.out.println("Nombre usuario: " + usuario.getNombre());

        Supplier<String> proveedor = () -> "Hola mundo desde supplier!";

        System.out.println(proveedor.get());
    }
}
