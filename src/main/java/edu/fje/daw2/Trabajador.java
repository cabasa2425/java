package edu.fje.daw2;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {
    private int id;
    private String nombre;
    private List<DetallesPrestamo> prestamosRealizados;

    public Trabajador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.prestamosRealizados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void prestar(Cliente cliente, Libro libro, ColeccionDisco disco) {
        if (cliente instanceof ClientePrivado) {
            if (libro != null && libro.prestar()) {
                DetallesPrestamo detallesPrestamo = new DetallesPrestamo(cliente, libro);
                prestamosRealizados.add(detallesPrestamo);
                cliente.agregarPrestamo(detallesPrestamo);
                System.out.println("El libro ha sido prestado a " + cliente.getNombre() + "hasta el" + detallesPrestamo.getFechaDevolucionPrevista());
            } else {
                System.out.println("El libro no está disponible para préstamo.");
            }
        } else if (cliente instanceof ClienteEscuela) {
            if (disco != null && disco.prestar()) {
                DetallesPrestamo detallesPrestamo = new DetallesPrestamo(cliente, disco);
                prestamosRealizados.add(detallesPrestamo);
                cliente.agregarPrestamo(detallesPrestamo);
                System.out.println("La colección de discos ha sido prestada a " + cliente.getNombre() + "hasta el" + detallesPrestamo.getFechaDevolucionPrevista());
            } else {
                System.out.println("La colección de discos no está disponible para préstamo.");
            }
        } else {
            System.out.println("Solo los clientes privados pueden tomar libros prestados.");
        }
    }

    public void recibirDevolucion(Cliente cliente, Libro libro, ColeccionDisco disco) {
        if (cliente instanceof ClientePrivado) {
            if (libro != null && !libro.isDisponible()) {
                libro.devolver();
                DetallesPrestamo detallesPrestamo = null;
                for (DetallesPrestamo p : cliente.getPrestamosRealizados()) {
                    if (p.getProducto() == libro) {
                        detallesPrestamo = p;
                        break;
                    }
                }
                if (detallesPrestamo != null) {
                    detallesPrestamo.devolver();
                    cliente.getPrestamosRealizados().remove(detallesPrestamo);
                    System.out.println("El libro ha sido devuelto por " + cliente.getNombre());
                }
            } else {
                System.out.println("El libro ya ha sido devuelto o no fue prestado.");
            }
        } else if (cliente instanceof ClienteEscuela) {
            if (disco != null && !disco.isDisponible()) {
                disco.devolver();
                DetallesPrestamo detallesPrestamo = null;
                for (DetallesPrestamo p : cliente.getPrestamosRealizados()) {
                    if (p.getProducto() == disco) {
                        detallesPrestamo = p;
                        break;
                    }
                }
                if (detallesPrestamo != null) {
                    detallesPrestamo.devolver();
                    cliente.getPrestamosRealizados().remove(detallesPrestamo);
                    System.out.println("La colección de discos ha sido devuelta por " + cliente.getNombre());
                }
            } else {
                System.out.println("La colección de discos ya ha sido devuelta o no fue prestada.");
            }
        } else {
            System.out.println("Solo los clientes privados pueden devolver libros.");
        }
    }

    public void mostrarPrestamosRealizados() {
        if (prestamosRealizados.isEmpty()) {
            System.out.println("No hay préstamos realizados aún.");
        } else {
            System.out.println("\nTODOS LOS PRESTAMOS REALIZADOS");
            for (DetallesPrestamo detallesPrestamo : prestamosRealizados) {
                System.out.println(detallesPrestamo);
                System.out.println("------------------------------");
            }
        }
    }
}
