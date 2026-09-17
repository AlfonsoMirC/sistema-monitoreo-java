
public enum EstadoTanque {
    DETENIDO,
    LLENANDO,
    VACIANDO;


    public String describir(double nivelActual, double capacidadMaxima) {
        if (nivelActual <= 0) {
            return "Vacío";
        } else if (nivelActual >= capacidadMaxima) {
            return "Lleno";
        } else if (this == LLENANDO) {
            return "Llenando";
        } else if (this == VACIANDO) {
            return "Vaciando";
        } else {
            return "Parcialmente lleno";
        }
    }
}