package org.cbaron.poointerfaces.imprenta.tarea;

import java.util.Date;

public interface ILibro {
    Date getFechaPublicacion();
    String getAutor();
    String getTitulo();
    String getEditorial();
}
