package org.cbaron.interfaces.repositorio;

import org.cbaron.interfaces.modelo.BaseEntity;
import org.cbaron.interfaces.repositorio.excepciones.EscrituraAccesoDatoExcepcion;
import org.cbaron.interfaces.repositorio.excepciones.LecturaAccesoDatoExcepcion;
import org.cbaron.interfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoExcepction;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T> {

    protected List<T> dataSource;

    public AbstractListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoExcepcion {
        if (t == null){
            throw new EscrituraAccesoDatoExcepcion("Error al insertar el objecto null");
        }
        if (this.dataSource.contains(t)){
            throw new RegistroDuplicadoAccesoDatoExcepction("Error el objecto con id: "
                    + t.getId() + " ya existe");
        }
        this.dataSource.add(t);
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoExcepcion {

        if (id == null || id <= 0) {
            throw new LecturaAccesoDatoExcepcion("Id invalido, tiene que ser > 0");
        }

        T cliente = null;
        for (T c : dataSource) {
            if (c.getId() != null && c.getId().equals(id)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            throw new LecturaAccesoDatoExcepcion("No existe el registro con el id:" + id);
        }
        return cliente;
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoExcepcion{
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
