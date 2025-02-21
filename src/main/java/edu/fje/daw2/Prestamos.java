/**
 * Representa un préstamo realizado por un cliente en la biblioteca.
 * Contiene información sobre el cliente, el producto prestado y las fechas de préstamo y devolución.
 */
package edu.fje.daw2;

import java.time.LocalDate;

public abstract class Prestamos implements PrestacionLibro {

    /** Título del préstamo */
    protected String titulo;

    /** Indica si el producto está disponible para préstamo */
    protected boolean disponible;

    /** Fecha en la que se realizó el préstamo */
    protected LocalDate fechaPrestamo;

    /** Fecha en la que se devolvió el producto */
    protected LocalDate fechaDevolucion;

    /**
     * Constructor de la clase Prestamos.
     * @param titulo Título del producto prestado
     */
    public Prestamos(String titulo) {
        this.titulo = titulo;
        this.disponible = true;
    }

    /**
     * Intenta prestar el producto si está disponible.
     * @return true si el préstamo es exitoso, false en caso contrario
     */
    @Override
    public boolean prestar() {
        if (disponible) {
            disponible = false;
            fechaPrestamo = LocalDate.now();
            return true;
        }
        return false;
    }

    /**
     * Devuelve el producto y lo marca como disponible nuevamente.
     */
    @Override
    public void devolver() {
        disponible = true;
        fechaDevolucion = LocalDate.now();
    }

    /**
     * Verifica si el producto está disponible para préstamo.
     * @return true si está disponible, false si está prestado
     */
    @Override
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Obtiene la fecha en la que se realizó el préstamo.
     * @return Fecha de préstamo
     */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Obtiene la fecha de devolución del producto.
     * @return Fecha de devolución
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Obtiene el título del préstamo.
     * @return Título del producto prestado
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece un nuevo título para el préstamo.
     * @param titulo Nuevo título del producto prestado
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Representación en cadena del objeto Prestamos.
     * @return Información del préstamo en formato String
     */
    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nDisponible: " + disponible
          /*      "\nFecha de Préstamo: " + (fechaPrestamo != null ? fechaPrestamo : "No ha sido prestado") +
                "\nFecha de Devolución: " + (fechaDevolucion != null ? fechaDevolucion : "No devuelto") */;
    }
}
