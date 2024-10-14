package org.cbaron.apiservlet.webapp.assignment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet({"/crear"})
public class RegistroProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String nombre = req.getParameter("nombre");

        String fabricante = req.getParameter("fabricante");

        Integer precio = null;
        try {
            precio = Integer.valueOf(req.getParameter("precio"));
        } catch (NumberFormatException e) {
        }

        Integer categoria = null;
        try {
            categoria = Integer.valueOf(req.getParameter("categoria"));
        } catch (NumberFormatException e) {
        }

        Map<String, String> errores = new HashMap<>();

        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "el nombre es requerido!");
        }

        if (fabricante == null || fabricante.isBlank()) {
            errores.put("fabricante", "el fabricante no puede ser vacío!");
        } else if( !(fabricante.length() >= 4) || !(fabricante.length() <= 10)){
            errores.put("fabricante", "el fabricante tiene que tener entre 4 y 10 caracteres!");
        }

        if (precio == null || precio < 1) {
            errores.put("precio", "el precio es requerido y debe ser un entero positivo.");
        }

        if (categoria == null || categoria < 1) {
            errores.put("categoria", "debe seleccionar una categoria.");
        }

        if (errores.isEmpty()) {
            try ( PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Resultado form</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Resultado form!</h1>");
                out.println("        <ul>");
                out.println("            <li>Producto: " + nombre + "</li>");
                out.println("            <li>Precio: " + precio + "</li>");
                out.println("            <li>Fabricante: " + fabricante + "</li>");
                out.println("            <li>Categoria id: " + categoria + "</li>");
                out.println("        </ul>");
                out.println("    </body>");
                out.println("</html>");
            }
        } else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
        }
    }
}
