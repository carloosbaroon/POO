package org.cbaron.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cbaron.apiservlet.webapp.headers.models.Categoria;
import org.cbaron.apiservlet.webapp.headers.services.ProductoService;
import org.cbaron.apiservlet.webapp.headers.services.ProductoServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/productos/form")
public class ProductoFormServlet extends HttpServlet {

    private static final Logger logger =  Logger.getLogger("TiempoTranscurridoFilter");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Are we reaching the servlet?");
        Connection connection = (Connection) req.getAttribute("connection");
        ProductoService service = new ProductoServiceJdbcImpl(connection);
        List<Categoria> categorias = service.listarCategoria();
        System.out.println(categorias);
        req.setAttribute("categorias", service.listarCategoria());
        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
