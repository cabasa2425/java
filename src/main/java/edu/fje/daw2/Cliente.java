package edu.fje.daw2;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    protected int idCliente;
    protected String nombre;
    protected String correo;
    protected int telefono;
    protected int limitePrestamos;
    protected List<Prestamo> prestamosRealizados;

    public Cliente(int idCliente, String nombre, String correo, int telefono, int limitePrestamos) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.limitePrestamos = limitePrestamos;
        this.prestamosRealizados = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamosRealizados.add(prestamo);
    }
    public List<Prestamo> getPrestamosRealizados() {
        return prestamosRealizados;
    }


    public void mostrarPrestamosRealizados() {
        if (prestamosRealizados.isEmpty()) {
            System.out.println("❌ No hay préstamos realizados aún.");
        } else {
            System.out.println("\n📚 TODOS LOS PRESTAMOS REALIZADOS 📚");
            for (Prestamo prestamo : prestamosRealizados) {
                System.out.println(prestamo);
                System.out.println("------------------------------");
            }
        }
    }

    public abstract String tipoCliente();

    @Override
    public String toString() {
        return "ID Cliente: " + idCliente + "\nNombre: " + nombre + "\nCorreo: " + correo +
                "\nTeléfono: " + telefono + "\nLímite de préstamos: " + limitePrestamos +
                "\nPréstamos realizados: " + prestamosRealizados.size();
    }
}
