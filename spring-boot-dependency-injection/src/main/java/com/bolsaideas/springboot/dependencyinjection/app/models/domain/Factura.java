package com.bolsaideas.springboot.dependencyinjection.app.models.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

//THIS IS A POJO
@Component
public class Factura {

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
        this.descripcion = this.descripcion.concat("PostContruct");

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
