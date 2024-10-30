package org.cbaron.apiservlet.webapp.headers.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.cbaron.apiservlet.webapp.headers.services.ServiceJdbcException;
import org.cbaron.apiservlet.webapp.headers.util.ConnectionJDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConnectionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try (Connection connection = ConnectionJDBC.getConnection()) {
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                servletRequest.setAttribute("connection", connection);
                //This will return the call to the doGet, doPost, etc. of the Servlet!
                filterChain.doFilter(servletRequest, servletResponse);
                connection.commit();
            } catch (SQLException | ServiceJdbcException e) {
                connection.rollback();
                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
