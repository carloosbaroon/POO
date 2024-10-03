package org.cbaron.wepapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hola-mundo")
public class HolaMundoServlet extends HttpServlet {

    /*This class will be only one instance for all users!
    * that means we'll not create any attributes with states in this class!
    * Only the do methods will be different for each user*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("     <head>");
        out.println("         <meta charset=\"UTF-8\">");
        out.println("         <title>Hola Mundo Servlet</title>");
        out.println("     </head>");
        out.println("     <body>");
        out.println("         <h1>Hola Mundo Servlet!</h1>");
        out.println("     </body>");
        out.println("</html>");

        out.close();
    }
}
