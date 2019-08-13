package ejercicioPlayaDeEstacionamiento;

public abstract class Utilitarios extends Vehiculo {

    public int kilosCargaMaxima;
    public int kilosCargaActual;

    public Utilitarios(int kilosCarga){
        kilosCargaMaxima = kilosCarga;
        kilosCargaActual = 0;
    }

    public int getKilosCargaActual() {
        return kilosCargaActual;
    }

    public void agregarCarga(Carga carga){
        if(carga.kilos+this.kilosCargaActual<=kilosCargaMaxima)
            this.kilosCargaActual += carga.kilos;
    }
}
