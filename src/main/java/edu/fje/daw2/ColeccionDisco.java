package edu.fje.daw2;

public class ColeccionDisco extends Prestamos implements ControlInventario {
    private FormatoDisco formato;

    public ColeccionDisco(String titulo, FormatoDisco formato) {
        super(titulo);
        this.formato = formato;
    }

    public FormatoDisco getFormato() {
        return formato;
    }

    public void setFormato(FormatoDisco formato) {
        this.formato = formato;
    }

    @Override
    public void actualizarInventario() {
        System.out.println("Inventario actualizado para el disco: " + titulo);
    }

    @Override
    public void mostrarInventario() {
        System.out.println("Disco: " + titulo + ", Formato: " + formato + ", Disponible: " + isDisponible());
    }

    public int compareTo(ColeccionDisco otroDisco) {

        return this.titulo.compareTo(otroDisco.titulo);
    }

    @Override
    public String toString() {
        return super.toString() + "\nFormato: " + formato;
    }
}
