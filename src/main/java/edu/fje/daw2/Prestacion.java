/**
 * Interfaz que define las operaciones de préstamo y devolución de libros.
 */
package edu.fje.daw2;

public interface Prestacion {

    /**
     * Intenta prestar un libro.
     * @return true si el préstamo es exitoso, false en caso contrario
     */
    public boolean prestar();

    /**
     * Devuelve un libro prestado.
     */
    public void devolver();

    /**
     * Verifica si el libro está disponible para préstamo.
     * @return true si el libro está disponible, false si está prestado
     */
    public boolean isDisponible();
}
