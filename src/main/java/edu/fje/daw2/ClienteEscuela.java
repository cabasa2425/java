package edu.fje.daw2;

public class ClienteEscuela extends Cliente {
    private String nombreEscuela;

    public ClienteEscuela(int idCliente, String nombre, String correo, int telefono, String nombreEscuela) {
        super(idCliente, nombre, correo, telefono, 1);
        this.nombreEscuela = nombreEscuela;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }

    @Override
    public String tipoCliente() {
        return "Cliente Escuela";
    }

    public void pedirDisco(ColeccionDisco disco) {
        if (prestamosRealizados.size() < limitePrestamos && disco.prestar()) {
            Prestamo prestamoDisco = new Prestamo(this, disco);
            prestamosRealizados.add(prestamoDisco);
            System.out.println(nombre + " le ha pedido la colección de discos: " + disco.getTitulo());
        } else {
            System.out.println("No se puede pedir la colección de discos '" + disco.getTitulo() + "' a " + nombre);
        }
    }

    public void devolverDisco(ColeccionDisco disco) {
        Prestamo prestamo = null;
        for (Prestamo p : prestamosRealizados) {
            if (p.getProducto() == disco) {
                prestamo = p;
                break;
            }
        }

        if (prestamo != null) {
            prestamo.devolver();
            prestamosRealizados.remove(prestamo);
            System.out.println(nombre + " ha devuelto la colección de discos: " + disco.getTitulo());
        } else {
            System.out.println(nombre + " no tiene la colección de discos '" + disco.getTitulo() + "' prestada.");
        }
    }
}
