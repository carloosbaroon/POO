package com.bolsaideas.springboot.form.app.services;

import com.bolsaideas.springboot.form.app.models.domain.Pais;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PaisServiceImpl implements PaisService {

    private List<Pais> lista;

    public PaisServiceImpl() {
        this.lista = Arrays.asList(
                new Pais(1, "ES","España"),
                new Pais(2, "MX","Mexico"),
                new Pais(3, "CL","Chile"),
                new Pais(4, "AR","Argentina"),
                new Pais(5, "CO","Colombia"));
    }

    @Override
    public List<Pais> listar() {
        return lista;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado = null;
        for (Pais pais : this.lista) {
            if (pais.getId().equals(id)) {
                resultado = pais;
                break;
            }
        }

        return resultado;
    }
}
