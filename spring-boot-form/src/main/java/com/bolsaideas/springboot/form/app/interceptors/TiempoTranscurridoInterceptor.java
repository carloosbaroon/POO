package com.bolsaideas.springboot.form.app.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Component
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("TiempoTranscurridoInterceptor: preHandle() entrando...");
        long tiempoInicial = System.currentTimeMillis();
        request.setAttribute("tiempoInicial", tiempoInicial);

        Random random = new Random();
        Integer delay = random.nextInt(500);
        Thread.sleep(delay);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        long tiempoFinal = System.currentTimeMillis();
        long tiempoInicio = (Long) request.getAttribute("tiempoInicial");
        long tiempoTrancurrido = tiempoFinal - tiempoInicio;

        if (modelAndView != null) {
            modelAndView.addObject("tiempoTrancurrido", tiempoTrancurrido);
        }

        logger.info("Tiempo transcurrido: " + tiempoTrancurrido);
        logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo...");
    }
}
