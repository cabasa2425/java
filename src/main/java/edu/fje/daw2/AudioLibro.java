package edu.fje.daw2;

public class AudioLibro extends Libro {
    private int duracionMinutos;

    public AudioLibro(String titulo, String autor, String isbn, int duracionMinutos) {
        super(titulo, autor, isbn);
        this.duracionMinutos = duracionMinutos;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDuración en minutos: " + duracionMinutos;
    }
}
