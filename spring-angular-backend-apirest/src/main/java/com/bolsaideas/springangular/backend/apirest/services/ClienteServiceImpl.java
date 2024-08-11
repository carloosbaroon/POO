package com.bolsaideas.springangular.backend.apirest.services;

import com.bolsaideas.springangular.backend.apirest.models.dao.IClienteDao;
import com.bolsaideas.springangular.backend.apirest.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (clienteDao.existsById(id)) {
            clienteDao.deleteById(id);
        } else {
            throw new EmptyResultDataAccessException("Cliente not found with ID: ".concat(String.valueOf(id)), 1);
        }
    }
}
