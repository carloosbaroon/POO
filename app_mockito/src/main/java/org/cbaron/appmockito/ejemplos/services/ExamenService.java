package org.cbaron.appmockito.ejemplos.services;

import org.cbaron.appmockito.ejemplos.models.Examen;

public interface ExamenService {
    Examen findExamenPorNumber(String nombre);
}
