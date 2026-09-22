public class Tanque {

    private final String id;
    private final double capacidadMaxima;
    private double nivelActual;
    private EstadoTanque estado;

    public Tanque(String id, double capacidadMaxima) {
        this.id = id;
        this.capacidadMaxima = capacidadMaxima;
        this.nivelActual = 0.0;
        this.estado = EstadoTanque.DETENIDO;
    }

    public void llenar(double cantidad) {
        this.estado = EstadoTanque.LLENANDO;
        double nuevoNivel = this.nivelActual + cantidad;
        if (nuevoNivel > this.capacidadMaxima) {
            nuevoNivel = this.capacidadMaxima;
        }
        this.nivelActual = nuevoNivel;
    }


    public void vaciar(double cantidad) {
        this.estado = EstadoTanque.VACIANDO;
        double nuevoNivel = this.nivelActual - cantidad;
        if (nuevoNivel < 0) {
            nuevoNivel = 0;
        }
        this.nivelActual = nuevoNivel;
    }

    public void detener() {
        this.estado = EstadoTanque.DETENIDO;
    }

    public double consultarNivel() {
        return this.nivelActual;
    }

    public double calcularOcupacion() {
        return (this.nivelActual / this.capacidadMaxima) * 100;
    }

    public EstadoTanque getEstado() {
        return this.estado;
    }


    public String describirNivel() {
        return this.estado.describir(this.nivelActual, this.capacidadMaxima);
    }

    public String getId() {
        return this.id;
    }

    public double getCapacidadMaxima() {
        return this.capacidadMaxima;
    }
}