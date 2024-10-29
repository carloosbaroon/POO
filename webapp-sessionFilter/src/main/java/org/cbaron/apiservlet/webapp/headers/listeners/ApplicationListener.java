package org.cbaron.apiservlet.webapp.headers.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.cbaron.apiservlet.webapp.headers.models.Carro;

@WebListener
public class ApplicationListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {

    private ServletContext servletContext;

    //For the whole app
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Inicializando la aplicacion");
        servletContext = sce.getServletContext();
        //This is a singleton
        servletContext.setAttribute("mensaje", "algun valor global!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().log("Destruyendo la aplicacion");
    }

    //Only for the request
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        sre.getServletContext().log("Inicializando el request");
        sre.getServletRequest().setAttribute("mensaje", "guardando algun valor para el request");
        sre.getServletRequest().setAttribute("nombreCompleto", "Aleph Baron");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        sre.getServletContext().log("Inicializando el request");
    }

    //Only for the session
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("Inicializando la sesion http");
        Carro carro = new Carro();
        HttpSession session = se.getSession();
        session.setAttribute("carro", carro);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("Destruyendo la sesion http");
    }
}
