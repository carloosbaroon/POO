package org.cbaron.interfaces;

import org.cbaron.interfaces.modelo.Cliente;
import org.cbaron.interfaces.repositorio.*;
import org.cbaron.interfaces.repositorio.excepciones.AccesoDatoExcepcion;
import org.cbaron.interfaces.repositorio.excepciones.EscrituraAccesoDatoExcepcion;
import org.cbaron.interfaces.repositorio.excepciones.LecturaAccesoDatoExcepcion;
import org.cbaron.interfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoExcepction;
import org.cbaron.interfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        try {
            OrdenablePaginableCrudRepositorio<Cliente> repositorio = new ClienteListRepositorio();

            repositorio.crear(new Cliente("John", "Doe"));
            repositorio.crear(new Cliente("Jane", "Test"));
            repositorio.crear(new Cliente("Aleph", "Baron"));

            Cliente carlos = new Cliente("Carlos", "Baron");
            repositorio.crear(carlos);
            repositorio.crear(carlos);

            //repositorio.crear(null);
            List<Cliente> clientes = repositorio.listar();
            clientes.forEach(System.out::println);

            System.out.println("==== PAGINABLE ====");

            List<Cliente> clientePaginable = repositorio.listar(1, 3);
            clientePaginable.forEach(System.out::println);

            System.out.println("==== ORDENAR ====");

            List<Cliente> clientesOrdenAsc = (repositorio).listar("apellido", Direccion.ASC);
            for (Cliente cliente : clientesOrdenAsc) {
                System.out.println(cliente);
            }

            System.out.println("==== EDITAR ====");

            Cliente actualizar = new Cliente("Jane", "Actualizar");
            actualizar.setId(1);
            repositorio.editar(actualizar);
            Cliente janeActualizada = repositorio.porId(1);
            System.out.println(janeActualizada);

            System.out.println("==== ELIMINAR ====");
            repositorio.eliminar(1);
            repositorio.listar().forEach(System.out::println);

            System.out.println("==== Total ====");
            System.out.println("Total registros: " + repositorio.total());
        } catch (RegistroDuplicadoAccesoDatoExcepction e) {
            System.out.println("RegistroDuplicado:" + e.getMessage());
            e.printStackTrace();
        } catch (LecturaAccesoDatoExcepcion e) {
            System.out.println("Lectura:" + e.getMessage());
            e.printStackTrace();
        } catch (EscrituraAccesoDatoExcepcion e) {
            System.out.println("Escritura:" + e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoExcepcion e) {
            System.out.println("Generica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
