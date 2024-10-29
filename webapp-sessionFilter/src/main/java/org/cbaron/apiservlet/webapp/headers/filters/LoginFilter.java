package org.cbaron.apiservlet.webapp.headers.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cbaron.apiservlet.webapp.headers.services.LoginService;
import org.cbaron.apiservlet.webapp.headers.services.LoginServiceSessionImp;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/carro/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImp();
        Optional<String> username = service.getUsername((HttpServletRequest) servletRequest);

        if (username.isPresent()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no estas autorizado a para ingresar a esta pagina");
        }
    }
}
