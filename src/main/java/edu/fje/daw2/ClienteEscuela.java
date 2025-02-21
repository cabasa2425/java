/**
 * Representa un cliente de una escuela que utiliza la biblioteca.
 * Extiende la clase Cliente y añade el nombre de la escuela.
 */
package edu.fje.daw2;

public class ClienteEscuela extends Cliente {

    /** Nombre de la escuela a la que pertenece el cliente */
    private String nombreEscuela;

    /**
     * Constructor de la clase ClienteEscuela.
     * @param idCliente ID único del cliente
     * @param nombre Nombre del cliente
     * @param correo Correo electrónico del cliente
     * @param telefono Teléfono del cliente
     * @param nombreEscuela Nombre de la escuela del cliente
     */
    public ClienteEscuela(int idCliente, String nombre, String correo, int telefono, String nombreEscuela) {
        super(idCliente, nombre, correo, telefono, 1);
        this.nombreEscuela = nombreEscuela;
    }

    /**
     * Obtiene el nombre de la escuela del cliente.
     * @return Nombre de la escuela
     */
    public String getNombreEscuela() {
        return nombreEscuela;
    }

    /**
     * Establece un nuevo nombre de escuela para el cliente.
     * @param nombreEscuela Nuevo nombre de la escuela
     */
    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }

    /**
     * Devuelve el tipo de cliente.
     * @return "Cliente Escuela"
     */
    @Override
    public String tipoCliente() {
        return "Cliente Escuela";
    }
}
