package org.cbaron.apiservlet.webapp.headers.assignment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/guardar-session"})
public class GuardarNombreSessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        req.getSession().setAttribute("nombre", nombre);
        resp.sendRedirect(req.getContextPath() + "/perfil-usuario");
    }
}
