package com.bolsaideas.springboot.app.models.dao;

import com.bolsaideas.springboot.app.models.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class, id);
    }


    @Override
    public void save(Cliente cliente) {
        if (cliente.getId() != null && cliente.getId() > 0) {
            em.merge(cliente);
        } else {
            em.persist(cliente);
        }

    }

    @Override
    public void delete(Long id) {
        Cliente cliente = findOne(id);
        em.remove(cliente);
    }
}
