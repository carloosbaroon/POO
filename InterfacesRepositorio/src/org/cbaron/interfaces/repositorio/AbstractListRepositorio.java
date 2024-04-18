package org.cbaron.interfaces.repositorio;

import org.cbaron.interfaces.modelo.BaseEntity;

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
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public T porId(Integer id) {
        T cliente = null;
        for (T c : dataSource) {
            if (c.getId() != null && c.getId().equals(id)) {
                cliente = c;
                break;
            }
        }
        return cliente;
    }

    @Override
    public void eliminar(Integer id) {
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
