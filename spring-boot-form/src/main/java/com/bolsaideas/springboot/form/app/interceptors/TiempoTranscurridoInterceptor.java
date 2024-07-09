package com.bolsaideas.springboot.form.app.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getMethod().equalsIgnoreCase("post")) {
            return true;
        }

        //Obtain method's controller we are intercepting
        if (handler instanceof HandlerMethod) {
            HandlerMethod metodo = (HandlerMethod) handler;
            logger.info("Es un metodo del controlador: " + metodo.getMethod().getName());
        }

        logger.info("TiempoTranscurridoInterceptor: preHandle() entrando...");
        logger.info("Interceptando: " + handler);
        long tiempoInicial = System.currentTimeMillis();
        request.setAttribute("tiempoInicial", tiempoInicial);

        Random random = new Random();
        Integer delay = random.nextInt(500);
        Thread.sleep(delay);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if (!request.getMethod().equalsIgnoreCase("post")) {

            long tiempoFinal = System.currentTimeMillis();
            long tiempoInicio = (Long) request.getAttribute("tiempoInicial");
            long tiempoTrancurrido = tiempoFinal - tiempoInicio;

            //This validation is very important!!! (Can be either/both one of these below)
            if (handler instanceof HandlerMethod && modelAndView != null) {
                modelAndView.addObject("tiempoTrancurrido", tiempoTrancurrido);
            }

            logger.info("Tiempo transcurrido: " + tiempoTrancurrido);
            logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo...");
        }
    }
}
