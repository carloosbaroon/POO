package org.cbaron.clasesabstractas.form.elementos;

import org.cbaron.clasesabstractas.form.validador.LargoValidador;
import org.cbaron.clasesabstractas.form.validador.Validador;
import org.cbaron.clasesabstractas.form.validador.mensaje.IMensajeFormateable;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm {

    protected String valor;
    protected String nombre;

    private List<Validador> validadores;
    private List<String> errores;

    public ElementoForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public ElementoForm addValidador(Validador validador) {
        this.validadores.add(validador);
        return this;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean esValido() {
        for (Validador v : validadores) {
            if (!v.esValido(this.valor)) {
                if (v instanceof IMensajeFormateable) {
                    this.errores.add(((IMensajeFormateable) v).getMensajeFormat(this.nombre));
                } else {
                    this.errores.add(String.format(v.getMensaje(), nombre));
                }
            }
        }
        return this.errores.isEmpty();
    }

    abstract public String dibujarHtml();
}
