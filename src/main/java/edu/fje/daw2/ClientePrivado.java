package edu.fje.daw2;

public class ClientePrivado extends Cliente {
    public ClientePrivado(int idCliente, String nombre, String correo, int telefono) {
        super(idCliente, nombre, correo, telefono, 1);
    }

    @Override
    public String tipoCliente() {
        return "Cliente Privado";
    }

    public void prestarLibro(Libro libro) {
        if (prestamosRealizados.size() < limitePrestamos && libro.prestar()) {
            Prestamo prestamoLibro = new Prestamo(this, libro);
            prestamosRealizados.add(prestamoLibro);
            System.out.println(nombre + " ha pedido el libro: " + libro.getTitulo());
        } else {
            System.out.println("No se puede prestar el libro '" + libro.getTitulo() + "' a " + nombre);
        }
    }

    public void devolverLibro(Libro libro) {
        Prestamo prestamo = null;
        for (Prestamo p : prestamosRealizados) {
            if (p.getProducto() == libro) {
                prestamo = p;
                break;
            }
        }

        if (prestamo != null) {
            prestamo.devolver();
            prestamosRealizados.remove(prestamo);
            System.out.println(nombre + " ha devuelto el libro: " + libro.getTitulo());
        } else {
            System.out.println(nombre + " no tiene el libro '" + libro.getTitulo() + "' prestado.");
        }
    }
}
