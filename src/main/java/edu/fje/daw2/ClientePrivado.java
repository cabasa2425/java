package edu.fje.daw2;

public class ClientePrivado extends Cliente {
    public ClientePrivado(int idCliente, String nombre, String correo, int telefono) {
        super(idCliente, nombre, correo, telefono, 1);
    }

    @Override
    public String tipoCliente() {
        return "Cliente Privado";
    }

}
