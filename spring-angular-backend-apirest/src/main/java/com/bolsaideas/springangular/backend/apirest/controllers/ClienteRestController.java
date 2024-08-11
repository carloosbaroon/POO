package com.bolsaideas.springangular.backend.apirest.controllers;

import com.bolsaideas.springangular.backend.apirest.models.entity.Cliente;
import com.bolsaideas.springangular.backend.apirest.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = {"http://localhost:4200/"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clienteService.findAll();
    }

    @GetMapping("clientes/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        Cliente cliente = null;
        Map<String, Object> response = new HashMap<>();

        try {
            cliente = clienteService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulata a la DB");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (cliente == null) {
            response.put("mensaje", "El cliente id: ".concat(id.toString().concat("No existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> create(@RequestBody Cliente cliente) {

        Cliente clienteNew = null;
        Map<String, Object> response = new HashMap<>();

        try {
            clienteNew = clienteService.save(cliente);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al guardar en la DB");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ha sido creado con exito");
        response.put("cliente", clienteNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable Long id) {

        Cliente clientesActual = clienteService.findById(id);
        Cliente clienteUpdated = null;

        Map<String, Object> response = new HashMap<>();

        if (clientesActual == null) {
            response.put("mensaje", "Error: no se pudo editar el cliente id: ".concat(id.toString().concat(" No existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            clientesActual.setApellido(cliente.getApellido());
            clientesActual.setNombre(cliente.getNombre());
            clientesActual.setEmail(cliente.getEmail());
            clientesActual.setCreateAt(cliente.getCreateAt());

            clienteUpdated = clienteService.save(clientesActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar en la DB");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ha sido actualizado con exito");
        response.put("cliente", clienteUpdated);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        Map<String, Object> response = new HashMap<>();

        try {
            clienteService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar en la DB");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ha sido elimnado con exito");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

}
