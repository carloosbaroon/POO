package org.cbaron.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T> {

    private List<T> objectos;
    private int max;

    public Camion(int max) {
        this.max = max;
        this.objectos = new ArrayList<>();
    }

    public void add(T objeto) {
        if (this.objectos.size() <= this.max) {
            this.objectos.add(objeto);
        } else {
            throw new RuntimeException("No hay mas espacio en el camion!");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.objectos.iterator();
    }
}
