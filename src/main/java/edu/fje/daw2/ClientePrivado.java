/**
 * Representa un cliente privado que utiliza la biblioteca.
 * Extiende la clase Cliente sin agregar atributos adicionales.
 */
package edu.fje.daw2;

public class ClientePrivado extends Cliente {

    /**
     * Constructor de la clase ClientePrivado.
     * @param idCliente ID único del cliente
     * @param nombre Nombre del cliente
     * @param correo Correo electrónico del cliente
     * @param telefono Teléfono del cliente
     */
    public ClientePrivado(int idCliente, String nombre, String correo, int telefono) {
        super(idCliente, nombre, correo, telefono, 1);
    }

    /**
     * Devuelve el tipo de cliente.
     * @return "Cliente Privado"
     */
    @Override
    public String tipoCliente() {
        return "Cliente Privado";
    }
}
