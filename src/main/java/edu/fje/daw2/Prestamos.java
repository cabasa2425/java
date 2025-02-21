package edu.fje.daw2;

import java.time.LocalDate;

public abstract class Prestamos implements PrestacionLibro {
    protected String titulo;
    protected boolean disponible;
    protected LocalDate fechaPrestamo;
    protected LocalDate fechaDevolucion;

    public Prestamos(String titulo) {
        this.titulo = titulo;
        this.disponible = true;
    }

    @Override
    public boolean prestar() {
        if (disponible) {
            disponible = false;
            fechaPrestamo = LocalDate.now();
            return true;
        }
        return false;
    }

    @Override
    public void devolver() {
        disponible = true;
        fechaDevolucion = LocalDate.now();
    }

    @Override
    public boolean isDisponible() {
        return disponible;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nDisponible: " + disponible
          /*      "\nFecha de Préstamo: " + (fechaPrestamo != null ? fechaPrestamo : "No ha sido prestado") +
                "\nFecha de Devolución: " + (fechaDevolucion != null ? fechaDevolucion : "No devuelto") */;
    }
}
