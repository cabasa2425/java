package edu.fje.daw2;

public class Papel extends Libro {
    private int numPaginas;

    public Papel(String titulo, String autor, String isbn, int numPaginas) {
        super(titulo, autor, isbn);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNúmero de páginas: " + numPaginas;
    }
}
