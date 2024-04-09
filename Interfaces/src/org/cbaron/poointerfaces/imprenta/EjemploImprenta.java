package org.cbaron.poointerfaces.imprenta;

import org.cbaron.poointerfaces.imprenta.modelo.*;

public class EjemploImprenta {
    public static void main(String[] args) {

        Curriculo cv = new Curriculo(new Persona("Carlos", "Baron"), "ISC", "Resumen laboral...");
        cv.addExperiencia("Java")
                .addExperiencia("Python")
                .addExperiencia("Oracle DBA")
                .addExperiencia("SQL Server");

        Libro libro = new Libro(new Persona("Erich", "Gamma"), "Patrones de diseno POO", Genero.PROGRAMACION);
        libro.addPagina(new Pagina("Patron Singleton"))
                .addPagina(new Pagina("Patron Observador"))
                .addPagina(new Pagina("Patron Factory"))
                .addPagina(new Pagina("Patron Composi"));

        Informe informe = new Informe(new Persona("Martin", "Fowler"), new Persona("James", "Goslin"), "Estudio sobre microservicios");
        imprimir(cv);
        imprimir(informe);
        imprimir(libro);

        System.out.println(Imprimible.VALOR_DEFECTO);
    }

    public static void imprimir(Imprimible imprimible) {
        System.out.println(imprimible.imprimir());
    }
}
