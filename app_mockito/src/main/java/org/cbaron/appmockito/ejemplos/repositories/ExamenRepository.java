package org.cbaron.appmockito.ejemplos.repositories;

import org.cbaron.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {
    List<Examen> findAll();
}
