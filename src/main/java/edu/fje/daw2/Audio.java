/**
 * Representa un audiolibro, que es una extensión de la clase Libro.
 */
package edu.fje.daw2;

public class Audio extends Libro {

    /** Duración del audiolibro en minutos */
    private int duracionMinutos;

    /**
     * Constructor de la clase AudioLibro.
     * @param titulo Título del audiolibro
     * @param autor Autor del audiolibro
     * @param isbn Código ISBN del audiolibro
     * @param duracionMinutos Duración total en minutos
     */
    public Audio(String titulo, String autor, String isbn, int duracionMinutos) {
        super(titulo, autor, isbn);
        this.duracionMinutos = duracionMinutos;
    }

    /**
     * Obtiene la duración del audiolibro en minutos.
     * @return Duración en minutos
     */
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    /**
     * Establece una nueva duración para el audiolibro.
     * @param duracionMinutos Nueva duración en minutos
     */
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    /**
     * Representación en cadena del objeto AudioLibro.
     * @return Información del audiolibro en formato String
     */
    @Override
    public String toString() {
        return super.toString() + "\nDuración en minutos: " + duracionMinutos;
    }
}
