package edu.fje.daw2;

import java.time.LocalDate;

public class Prestamo {
    private Cliente cliente;
    private Object producto;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucionPrevista;
    private LocalDate fechaDevolucionReal;

    public Prestamo(Cliente cliente, Object producto) {
        this.cliente = cliente;
        this.producto = producto;
        this.fechaInicio = LocalDate.now();
        this.fechaDevolucionPrevista = LocalDate.now().plusWeeks(1);
        this.fechaDevolucionReal = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Object getProducto() {
        return producto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }

    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void devolver() {
        if (fechaDevolucionReal == null) {
            this.fechaDevolucionReal = LocalDate.now();
            System.out.println("El producto ha sido devuelto.");
        } else {
            System.out.println("El producto ya ha sido devuelto.");
        }
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNombre() +
                "\nProducto: " + producto +
                "\nFecha de Inicio: " + fechaInicio +
                "\nFecha de Devolución Prevista: " + fechaDevolucionPrevista +
                (fechaDevolucionReal != null ? "\nFecha de Devolución Real: " + fechaDevolucionReal : "\nNo devuelto aún");
    }
}
