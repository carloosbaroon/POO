package com.bolsaideas.springboot.dependencyinjection.app.models.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.List;

//THIS IS A POJO
@Component
//By default, the scope is singleton, here we change it to request
//This means that each user that does a request, will have a different "Factura"
@RequestScope
//@SessionScope
//Similar to singleton, but it gets saves in the servlet context
//@ApplicationScope
public class Factura implements Serializable {

    @Value("${factura.descripcion}")
    private String descripcion;
    @Autowired
    private Cliente cliente;
    @Autowired
    //@Qualifier("itemsFacturaOficina")
    private List<ItemFactura> items;

    //Really similar to a constructor, just being managed by sprint
    @PostConstruct
    public void inicializar(){
        this.cliente.setNombre(cliente.getNombre().concat(" ").concat("Post"));
        this.descripcion = this.descripcion.concat("del cliente: ").concat(this.cliente.getNombre());

    }

    //Right before our instance dies
    @PreDestroy
    public void destruir(){
        System.out.println("Destruir Factura".concat(this.descripcion));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }
}
