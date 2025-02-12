package org.cbaron.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.cbaron.apiservlet.webapp.headers.services.LoginService;
import org.cbaron.apiservlet.webapp.headers.services.LoginServiceCookieImp;
import org.cbaron.apiservlet.webapp.headers.services.LoginServiceSessionImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {

    final static String USERNAME = "ADMIN";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceSessionImp();
        Optional<String> cookieOptional = auth.getUsername(req);

        if (cookieOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("     <head>");
                out.println("         <meta charset=\"UTF-8\">");
                out.println("         <title>Hola" + cookieOptional.get()+ "</title>");
                out.println("     </head>");
                out.println("     <body>");
                out.println("         <h1>Hola " + cookieOptional.get() + " has iniciado con exito!</h1>");
                out.println("<p><a href='" + req.getContextPath() + "/index.html'>volver</a><p>");
                out.println("<p><a href='" + req.getContextPath() + "/logout'>cerrar sesion</a><p>");
                out.println("     </body>");
                out.println("</html>");
            }
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {

            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            resp.sendRedirect(req.getContextPath() + "/login.html");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos, no esta autorizado para ingresar a esta pagina");
        }
    }
}
