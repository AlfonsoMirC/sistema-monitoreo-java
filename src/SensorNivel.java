public class SensorNivel {
    private String id;
    private double valor_medio;
    private double lim_minimo;
    private double lim_maximo;

    public SensorNivel(String id,  double valor_medio, double lim_minimo, double lim_maximo) {
        this.id = id;
        this.valor_medio = 0;
        this.lim_minimo = lim_minimo;
        this.lim_maximo = lim_maximo;
    }

    public String getId() {
        return id;
    }
    public void  lectura_sensor(double nivel_tanque){
        this.valor_medio = nivel_tanque;
    }
    public double getValor_medio() {
        return valor_medio;
    }
    punlic boolean lec_valida(){
        return valor_medio >= lim_minimo && valor_medio <= lim_maximo;
    }
}