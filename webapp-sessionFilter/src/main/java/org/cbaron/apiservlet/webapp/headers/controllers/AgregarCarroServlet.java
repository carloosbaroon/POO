package org.cbaron.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.cbaron.apiservlet.webapp.headers.models.Carro;
import org.cbaron.apiservlet.webapp.headers.models.ItemCarro;
import org.cbaron.apiservlet.webapp.headers.models.Producto;
import org.cbaron.apiservlet.webapp.headers.services.ProductoService;
import org.cbaron.apiservlet.webapp.headers.services.ProductoServiceImpl;
import org.cbaron.apiservlet.webapp.headers.services.ProductoServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        Connection connection = (Connection) req.getAttribute("connection");
        ProductoService service = new ProductoServiceJdbcImpl(connection);
        Optional<Producto> producto = service.getById(id);

        if (producto.isPresent()) {
            ItemCarro item = new ItemCarro(1, producto.get());
            HttpSession session = req.getSession();
            Carro carro = (Carro) session.getAttribute("carro");
            carro.addItem(item);
        }
        resp.sendRedirect(req.getContextPath() + "/carro/ver");
    }
}
