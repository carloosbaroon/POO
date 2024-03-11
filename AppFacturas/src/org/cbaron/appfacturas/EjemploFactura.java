package org.cbaron.appfacturas;

import org.cbaron.appfacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNif("12334-123");
        cliente.setNombre("Carlos");

        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese la descripcion de la factura: ");

        Factura factura = new Factura(s.nextLine(), cliente);

        Producto producto;

        System.out.println();

        for (int i = 0; i < 2; i++) {
            producto = new Producto();
            System.out.print("Ingrese producto no " + producto.getId() + ": " );
            producto.setNombre(s.next());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.print("Ingrese la cantidad: ");
            factura.addItemFactura(new ItemFactura(s.nextInt(), producto));

            System.out.println();
        }
        System.out.println(factura);
    }
}
