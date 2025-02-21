package edu.fje.daw2;

public class ClienteEscuela extends Cliente {
    private String nombreEscuela;

    public ClienteEscuela(int idCliente, String nombre, String correo, int telefono, String nombreEscuela) {
        super(idCliente, nombre, correo, telefono, 1);
        this.nombreEscuela = nombreEscuela;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }

    @Override
    public String tipoCliente() {
        return "Cliente Escuela";
    }

}
