package org.cbaron.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cbaron.apiservlet.webapp.headers.models.Producto;
import org.cbaron.apiservlet.webapp.headers.services.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = (Connection) req.getAttribute("connection");
        ProductoService service = new ProductoServiceJdbcImpl(connection);
        List<Producto> productos = service.listar();

        LoginService auth = new LoginServiceSessionImp();
        Optional<String> cookieOptional = auth.getUsername(req);

        req.setAttribute("productos", productos);
        req.setAttribute("username", cookieOptional);

        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
