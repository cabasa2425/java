package edu.fje.daw2;

import java.time.LocalDate;

/**
 * Representa un préstamo realizado por un cliente en la biblioteca.
 * Contiene información sobre el cliente, el producto prestado y las fechas de préstamo y devolución.
 * Un préstamo se crea con una fecha de inicio y una fecha de devolución prevista de una semana después.
 */
public class DetallesPrestamo {

    /** Cliente que realiza el préstamo. */
    private Cliente cliente;

    /** Producto prestado, que puede ser un libro o un disco. */
    private Object producto;

    /** Fecha en la que se realizó el préstamo. */
    private LocalDate fechaInicio;

    /** Fecha prevista para la devolución del producto. */
    private LocalDate fechaDevolucionPrevista;

    /** Fecha real en la que se devolvió el producto, o {@code null} si aún no ha sido devuelto. */
    private LocalDate fechaDevolucionReal;

    /**
     * Constructor de la clase Prestamo.
     * Crea un nuevo préstamo con la fecha de inicio actual y una fecha de devolución prevista de una semana.
     *
     * @param cliente Cliente que realiza el préstamo.
     * @param producto Producto prestado (puede ser un libro o un disco).
     */
    public DetallesPrestamo(Cliente cliente, Object producto) {
        this.cliente = cliente;
        this.producto = producto;
        this.fechaInicio = LocalDate.now();
        this.fechaDevolucionPrevista = fechaInicio.plusWeeks(1);
        this.fechaDevolucionReal = null;
    }

    /**
     * Obtiene el cliente que realizó el préstamo.
     * @return Cliente que realizó el préstamo.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Obtiene el producto prestado.
     * @return Producto prestado (libro o disco).
     */
    public Object getProducto() {
        return producto;
    }

    /**
     * Obtiene la fecha de inicio del préstamo.
     * @return Fecha de inicio del préstamo.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Obtiene la fecha prevista para la devolución del producto.
     * @return Fecha prevista de devolución.
     */
    public LocalDate getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }

    /**
     * Obtiene la fecha real de devolución del producto.
     * @return Fecha de devolución real o {@code null} si aún no ha sido devuelto.
     */
    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    /**
     * Marca el producto como devuelto si aún no ha sido devuelto previamente.
     * Si ya ha sido devuelto, muestra un mensaje indicando que la devolución ya se realizó.
     */
    public void devolver() {
        if (fechaDevolucionReal == null) {
            fechaDevolucionReal = LocalDate.now();
            System.out.println("El producto ha sido devuelto.");
        } else {
            System.out.println("El producto ya ha sido devuelto anteriormente.");
        }
    }

    /**
     * Representación en cadena del objeto Prestamo.
     * @return Información del préstamo en formato String.
     */
    @Override
    public String toString() {
        return "Cliente: " + cliente.getNombre() +
                "\nProducto: " + producto +
                "\nFecha de Inicio: " + fechaInicio +
                "\nFecha de Devolución Prevista: " + fechaDevolucionPrevista +
                (fechaDevolucionReal != null ? "\nFecha de Devolución Real: " + fechaDevolucionReal : "\nNo devuelto aún");
    }
}
