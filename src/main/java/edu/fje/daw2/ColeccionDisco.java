package edu.fje.daw2;

public class ColeccionDisco extends Prestamos implements ControlInventario {

    /** Formato del disco (CD, VINILO, DIGITAL) */
    private FormatoDisco formato;

    /**
     * Constructor de la clase ColeccionDisco.
     * @param titulo Título de la colección de discos
     * @param formato Formato del disco
     */
    public ColeccionDisco(String titulo, FormatoDisco formato) {
        super(titulo);
        this.formato = formato;
    }

    /**
     * Obtiene el formato del disco.
     * @return Formato del disco
     */
    public FormatoDisco getFormato() {
        return formato;
    }

    /**
     * Establece un nuevo formato para el disco.
     * @param formato Nuevo formato del disco
     */
    public void setFormato(FormatoDisco formato) {
        this.formato = formato;
    }

    /**
     * Actualiza el inventario del disco.
     */
    @Override
    public void actualizarInventario() {
        System.out.println("Inventario actualizado para el disco: " + titulo);
    }

    /**
     * Muestra la información del inventario del disco.
     */
    @Override
    public void mostrarInventario() {
        System.out.println("Disco: " + titulo + ", Formato: " + formato + ", Duración promedio: " + formato.getDuracion() + " minutos, Disponible: " + isDisponible());
    }

    /**
     * Representación en cadena del objeto ColeccionDisco.
     * @return Información del disco en formato String
     */
    @Override
    public String toString() {
        return super.toString() + "\nFormato: " + formato + ", Duración promedio: " + formato.getDuracion() + " minutos";
    }

    // Método para comparar discos por su título
    public int compareTo(ColeccionDisco otroDisco) {
        return this.titulo.compareTo(otroDisco.titulo);
    }
}
