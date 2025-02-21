package edu.fje.daw2;

/**
 * Representa una colección de discos que puede ser prestada e inventariada.
 * Extiende la clase Prestamos e implementa ControlInventario.
 */
public class ColeccionDisco extends Prestamos implements ControlInventario {

    /** Formato del disco (CD, VINILO, DIGITAL). */
    private FormatoDisco formato;

    /**
     * Constructor de la clase ColeccionDisco.
     * @param titulo Título de la colección de discos.
     * @param formato Formato del disco.
     */
    public ColeccionDisco(String titulo, FormatoDisco formato) {
        super(titulo);
        this.formato = formato;
    }

    /**
     * Obtiene el formato del disco.
     * @return El formato del disco.
     */
    public FormatoDisco getFormato() {
        return formato;
    }

    /**
     * Establece un nuevo formato para el disco.
     * @param formato Nuevo formato del disco.
     */
    public void setFormato(FormatoDisco formato) {
        this.formato = formato;
    }

    /**
     * Actualiza el inventario del disco.
     * Se debe llamar a este método cuando haya cambios en el stock.
     */
    @Override
    public void actualizarInventario() {
        System.out.println("Inventario actualizado para el disco: " + titulo);
    }

    /**
     * Muestra la información del inventario del disco en la consola.
     */
    @Override
    public void mostrarInventario() {
        System.out.println("Disco: " + titulo + ", Formato: " + formato +
                ", Duración promedio: " + formato.getDuracion() +
                " minutos, Disponible: " + isDisponible());
    }

    /**
     * Representación en cadena del objeto ColeccionDisco.
     * @return Una cadena con la información del disco.
     */
    @Override
    public String toString() {
        return super.toString() + "\nFormato: " + formato +
                ", Duración promedio: " + formato.getDuracion() + " minutos";
    }

    /**
     * Compara este disco con otro basado en el título.
     * @param otroDisco El otro disco a comparar.
     * @return Un valor negativo, cero o positivo si este disco es menor, igual o mayor que el otro.
     */
    public int compareTo(ColeccionDisco otroDisco) {
        return this.titulo.compareTo(otroDisco.titulo);
    }
}
