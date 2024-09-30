package org.cbaron.appmockito.ejemplos.services;

import org.cbaron.appmockito.ejemplos.models.Examen;

import java.util.Optional;

public interface ExamenService {
    Optional<Examen> findExamenPorNumber(String nombre);
}
