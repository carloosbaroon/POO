package com.bolsaideas.springangular.backend.apirest.services;

import com.bolsaideas.springangular.backend.apirest.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> findAll();
}
