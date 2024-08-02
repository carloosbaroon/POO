package com.bolsaideas.springangular.backend.apirest.models.dao;

import com.bolsaideas.springangular.backend.apirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long> {
}
