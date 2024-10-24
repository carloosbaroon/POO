package org.cbaron.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.cbaron.apiservlet.webapp.headers.services.LoginService;
import org.cbaron.apiservlet.webapp.headers.services.LoginServiceCookieImp;
import org.cbaron.apiservlet.webapp.headers.services.LoginServiceSessionImp;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService auth = new LoginServiceSessionImp();
        Optional<String> username = auth.getUsername(req);

        if (username.isPresent()) {
            HttpSession session = req.getSession();
            session.invalidate();
        }

        resp.sendRedirect(req.getContextPath() + "/login.html");
    }
}
