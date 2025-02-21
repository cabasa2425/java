/**
 * Enumeración que representa los distintos formatos de discos disponibles en la biblioteca.
 * Cada formato tiene una duración promedio en minutos.
 */
package edu.fje.daw2;

public enum FormatoDisco {

    /** Formato de disco CD con una duración promedio de 74 minutos */
    CD(74),

    /** Formato de disco VINILO con una duración promedio de 45 minutos */
    VINILO(45),

    /** Formato de disco DIGITAL con una duración promedio de 100 minutos */
    DIGITAL(100);

    /** Duración promedio del formato en minutos */
    private int duracion;

    /**
     * Constructor de la enumeración FormatoDisco.
     * @param duracion Duración promedio en minutos
     */
    FormatoDisco(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Obtiene la duración promedio del formato de disco.
     * @return Duración en minutos
     */
    public int getDuracion() {
        return this.duracion;
    }

    /**
     * Muestra información sobre el formato de disco.
     */
    public void mostrarInformacion() {
        System.out.println("Formato: " + this.name() + ", Duración promedio: " + this.duracion + " minutos");
    }
}