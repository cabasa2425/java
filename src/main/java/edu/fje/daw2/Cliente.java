/**
 * Representa un cliente de la biblioteca.
 * Esta clase es abstracta y define atributos y métodos comunes para todos los tipos de clientes.
 */
package edu.fje.daw2;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

    /** ID único del cliente */
    protected int idCliente;

    /** Nombre del cliente */
    protected String nombre;

    /** Correo electrónico del cliente */
    protected String correo;

    /** Teléfono del cliente */
    protected int telefono;

    /** Límite de préstamos del cliente */
    protected int limitePrestamos;

    /** Lista de préstamos realizados por el cliente */
    protected List<Prestamo> prestamosRealizados;

    /**
     * Constructor de la clase Cliente.
     * @param idCliente ID único del cliente
     * @param nombre Nombre del cliente
     * @param correo Correo electrónico del cliente
     * @param telefono Teléfono del cliente
     * @param limitePrestamos Límite de préstamos permitido
     */
    public Cliente(int idCliente, String nombre, String correo, int telefono, int limitePrestamos) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.limitePrestamos = limitePrestamos;
        this.prestamosRealizados = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del cliente.
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para el cliente.
     * @param nombre Nuevo nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del cliente.
     * @return ID del cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Establece un nuevo ID para el cliente.
     * @param idCliente Nuevo ID del cliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     * @return Correo del cliente
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece un nuevo correo electrónico para el cliente.
     * @param correo Nuevo correo del cliente
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el teléfono del cliente.
     * @return Teléfono del cliente
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Establece un nuevo teléfono para el cliente.
     * @param telefono Nuevo teléfono del cliente
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Agrega un préstamo a la lista de préstamos realizados por el cliente.
     * @param prestamo Préstamo a agregar
     */
    public void agregarPrestamo(Prestamo prestamo) {
        prestamosRealizados.add(prestamo);
    }

    /**
     * Obtiene la lista de préstamos realizados por el cliente.
     * @return Lista de préstamos realizados
     */
    public List<Prestamo> getPrestamosRealizados() {
        return prestamosRealizados;
    }

    /**
     * Muestra todos los préstamos realizados por el cliente.
     */
    public void mostrarPrestamosRealizados() {
        if (prestamosRealizados.isEmpty()) {
            System.out.println("❌ No hay préstamos realizados aún.");
        } else {
            System.out.println("\n📚 TODOS LOS PRESTAMOS REALIZADOS 📚");
            for (Prestamo prestamo : prestamosRealizados) {
                System.out.println(prestamo);
                System.out.println("------------------------------");
            }
        }
    }

    /**
     * Método abstracto para obtener el tipo de cliente.
     * @return Tipo de cliente como String
     */
    public abstract String tipoCliente();

    /**
     * Representación en cadena del objeto Cliente.
     * @return Información del cliente en formato String
     */
    @Override
    public String toString() {
        return "ID Cliente: " + idCliente + "\nNombre: " + nombre + "\nCorreo: " + correo +
                "\nTeléfono: " + telefono + "\nLímite de préstamos: " + limitePrestamos +
                "\nPréstamos realizados: " + prestamosRealizados.size();
    }
}