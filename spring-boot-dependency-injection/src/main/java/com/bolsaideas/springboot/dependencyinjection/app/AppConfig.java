/*
* THIS FILES NEEDS TO BE IN THE ROOT PACKAGE IN ORDER TO WORK
* IF WE WANT TO USE CLASSES FROM 3rd party APIs/FRAMEWORKS WE USE THIS APPROACH
*/

package com.bolsaideas.springboot.dependencyinjection.app;

import com.bolsaideas.springboot.dependencyinjection.app.models.domain.ItemFactura;
import com.bolsaideas.springboot.dependencyinjection.app.models.domain.Producto;
import com.bolsaideas.springboot.dependencyinjection.app.models.services.IServicio;
import com.bolsaideas.springboot.dependencyinjection.app.models.services.MiServicio;
import com.bolsaideas.springboot.dependencyinjection.app.models.services.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

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

    @Bean("itemsFactura")
    @Primary
    public List<ItemFactura> registrarItemFacturas(){
        Producto producto1 = new Producto("Premios 1", 100);
        Producto producto2 = new Producto("Premios 2", 200);
        Producto producto3 = new Producto("Premios 3", 300);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 4);
        ItemFactura linea3 = new ItemFactura(producto3, 6);

        //This is similar to create an instance of ArrayList and add them
        return Arrays.asList(linea1, linea2, linea3);
    }

    @Bean("itemsFacturaOficina")
    public List<ItemFactura> registrarItemFacturasOficina(){
        Producto producto1 = new Producto("Monito LF LCD", 250);
        Producto producto2 = new Producto("Notebook Asus", 500);
        Producto producto3 = new Producto("Impresora HP", 400);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 2);
        ItemFactura linea3 = new ItemFactura(producto3, 1);

        //This is similar to create an instance of ArrayList and add them
        return Arrays.asList(linea1, linea2, linea3);
    }
}
