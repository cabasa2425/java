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
        System.out.println("Disco: " + titulo + ", Formato: " + formato + ", Duración promedio: " + formato.getDuracion() + " minutos, Disponible: " + isDisponible());
    }

    @Override
    public String toString() {
        return super.toString() + "\nFormato: " + formato + ", Duración promedio: " + formato.getDuracion() + " minutos";
    }

    // Método para comparar discos por su título
    public int compareTo(ColeccionDisco otroDisco) {
        return this.titulo.compareTo(otroDisco.titulo);
    }
}
