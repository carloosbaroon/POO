package org.cbaron.appmockito.ejemplos.services;

import org.cbaron.appmockito.ejemplos.models.Examen;
import org.cbaron.appmockito.ejemplos.repositories.ExamenRepository;

import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{

    private ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Examen findExamenPorNumber(String nombre) {
        Optional<Examen> examenOptional = examenRepository.findAll()
                .stream()
                .filter(examen -> examen.getNombre()
                .contains(nombre))
                .findFirst();

        Examen examen = null;

        if (examenOptional.isPresent()) {
            examen = examenOptional.orElseThrow();
        }
        return examen;
    }
}
