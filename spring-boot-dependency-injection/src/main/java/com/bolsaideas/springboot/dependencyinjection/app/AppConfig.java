/*
* THIS FILES NEEDS TO BE IN THE ROOT PACKAGE IN ORDER TO WORK
* IF WE WANT TO USE CLASSES FROM 3rd party APIs/FRAMEWORKS WE USE THIS APPROACH
*/

package com.bolsaideas.springboot.dependencyinjection.app;

import com.bolsaideas.springboot.dependencyinjection.app.services.IServicio;
import com.bolsaideas.springboot.dependencyinjection.app.services.MiServicio;
import com.bolsaideas.springboot.dependencyinjection.app.services.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    //These methods will created the spring components and instances
    @Bean("miServicioSimple")
    public IServicio registrarMiServicio(){
        return new MiServicio();
    }

    @Bean("miServicioComplejo")
    @Primary
    public IServicio registrarMiServicioComplejo(){
        return new MiServicioComplejo();
    }
}
