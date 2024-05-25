package com.bolsaideas.springboot.dependencyinjection.app.services;

import org.springframework.stereotype.Component;

//This is a singleton and will allow us to inject into other components of our system
//This class will be a service -> business logic (DB, API REST, ETC)
//@Service
@Component("miServicioComplejo")
public class MiServicioComplejo implements IServicio {

    @Override
    public String operacion(){
        return "Ejecutando algun proceso importante complicado";
    }
}
