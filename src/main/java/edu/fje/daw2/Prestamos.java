package edu.fje.daw2;

import java.time.LocalDate;

/**
 * Representa un préstamo realizado por un cliente en la biblioteca.
 * Contiene información sobre el producto prestado, su disponibilidad y las fechas de préstamo y devolución.
 */
public abstract class Prestamos implements PrestacionLibro {

    /** Título del producto prestado. */
    protected String titulo;

    /** Indica si el producto está disponible para préstamo. */
    protected boolean disponible;

    /** Fecha en la que se realizó el préstamo, null si aún no se ha prestado. */
    protected LocalDate fechaPrestamo;

    /** Fecha en la que se devolvió el producto, null si aún no se ha devuelto. */
    protected LocalDate fechaDevolucion;

    /**
     * Constructor de la clase Prestamos.
     * Inicializa el título y establece el producto como disponible.
     * @param titulo Título del producto prestado.
     */
    public Prestamos(String titulo) {
        this.titulo = titulo;
        this.disponible = true;
    }

    /**
     * Intenta prestar el producto si está disponible.
     * @return {@code true} si el préstamo es exitoso, {@code false} si ya está prestado.
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
     * Devuelve el producto, lo marca como disponible y registra la fecha de devolución.
     */
    @Override
    public void devolver() {
        disponible = true;
        fechaDevolucion = LocalDate.now();
    }

    /**
     * Verifica si el producto está disponible para préstamo.
     * @return {@code true} si está disponible, {@code false} si está prestado.
     */
    @Override
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Obtiene la fecha en la que se realizó el préstamo.
     * @return La fecha de préstamo o {@code null} si aún no ha sido prestado.
     */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Obtiene la fecha de devolución del producto.
     * @return La fecha de devolución o {@code null} si aún no ha sido devuelto.
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Obtiene el título del producto prestado.
     * @return El título del producto prestado.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece un nuevo título para el producto prestado.
     * @param titulo El nuevo título del producto prestado.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Representación en cadena del objeto Prestamos.
     * @return Información del préstamo en formato de texto.
     */
    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nDisponible: " + disponible +
                "\nFecha de Préstamo: " + (fechaPrestamo != null ? fechaPrestamo : "No ha sido prestado") +
                "\nFecha de Devolución: " + (fechaDevolucion != null ? fechaDevolucion : "No devuelto");
    }
}
