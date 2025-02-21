/**
 * Representa un libro que puede ser prestado en la biblioteca.
 * Es una clase abstracta que extiende Prestamos e implementa ControlInventario.
 */
package edu.fje.daw2;

public abstract class Libro extends Prestamos implements ControlInventario {

    /** Autor del libro */
    protected String autor;

    /** Código ISBN del libro */
    protected String isbn;

    /**
     * Constructor de la clase Libro.
     * @param titulo Título del libro
     * @param autor Autor del libro
     * @param isbn Código ISBN del libro
     */
    public Libro(String titulo, String autor, String isbn) {
        super(titulo);
        this.autor = autor;
        this.isbn = isbn;
    }

    /**
     * Obtiene el autor del libro.
     * @return Autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Obtiene el código ISBN del libro.
     * @return Código ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece un nuevo autor para el libro.
     * @param autor Nuevo autor del libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Establece un nuevo código ISBN para el libro.
     * @param isbn Nuevo código ISBN del libro
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Actualiza el inventario del libro.
     */
    @Override
    public void actualizarInventario() {
        System.out.println("✅ Inventario actualizado para el libro: " + titulo);
    }

    /**
     * Muestra la información del inventario del libro.
     */
    @Override
    public void mostrarInventario() {
        System.out.println("📚 Libro: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Disponible: " + isDisponible());
    }

    /**
     * Representación en cadena del objeto Libro.
     * @return Información del libro en formato String
     */
    @Override
    public String toString() {
        return super.toString() + "\nAutor: " + autor + "\nISBN: " + isbn;
    }
}
