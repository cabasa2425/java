package edu.fje.daw2;

public enum FormatoDisco {
    CD(74),
    VINILO(45),
    DIGITAL(100);

    private int duracion;
    FormatoDisco(int duracion) {
        this.duracion = duracion;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void mostrarInformacion() {
        System.out.println("Formato: " + this.name() + ", Duración promedio: " + this.duracion + " minutos");
    }
}
