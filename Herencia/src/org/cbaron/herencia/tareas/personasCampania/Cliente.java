package org.cbaron.herencia.tareas.personasCampania;

public class Cliente extends PersonaCampania {
    private int clienteId;

    public Cliente(int clienteId, String numeroFiscal, String nombre, String apellido, String direccion) {
        super(numeroFiscal, nombre, apellido, direccion);
        this.clienteId = clienteId;
    }

    public int getClienteId() {
        return clienteId;
    }

    @Override
    public String toString() {
        return "clienteId=" + clienteId + ", " + super.toString();
    }
}
