/**
 * Representa un libro en formato físico (papel) con un número determinado de páginas.
 * Extiende la clase Libro.
 */
package edu.fje.daw2;

public class Papel extends Libro {

    /** Número de páginas del libro en papel */
    private int numPaginas;

    /**
     * Constructor de la clase Papel.
     * @param titulo Título del libro
     * @param autor Autor del libro
     * @param isbn Código ISBN del libro
     * @param numPaginas Número de páginas del libro
     */
    public Papel(String titulo, String autor, String isbn, int numPaginas) {
        super(titulo, autor, isbn);
        this.numPaginas = numPaginas;
    }

    /**
     * Obtiene el número de páginas del libro.
     * @return Número de páginas
     */
    public int getNumPaginas() {
        return numPaginas;
    }

    /**
     * Establece un nuevo número de páginas para el libro.
     * @param numPaginas Nuevo número de páginas
     */
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    /**
     * Representación en cadena del objeto Papel.
     * @return Información del libro en papel en formato String
     */
    @Override
    public String toString() {
        return super.toString() + "\nNúmero de páginas: " + numPaginas;
    }
}