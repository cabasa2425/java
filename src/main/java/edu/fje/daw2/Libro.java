package edu.fje.daw2;

public abstract class Libro extends Prestamos {
    protected String autor;
    protected String isbn;

    public Libro(String titulo, String autor, String isbn) {
        super(titulo);
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void actualizarInventario() {
        System.out.println("✅ Inventario actualizado para el libro: " + titulo);
    }

    @Override
    public void mostrarInventario() {
        System.out.println("📚 Libro: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Disponible: " + isDisponible());
    }

    @Override
    public String toString() {
        return super.toString() + "\nAutor: " + autor + "\nISBN: " + isbn;
    }
}
