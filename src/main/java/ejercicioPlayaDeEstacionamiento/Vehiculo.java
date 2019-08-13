package ejercicioPlayaDeEstacionamiento;

public abstract class Vehiculo {

    public boolean estacionado;

    public void cambiarEstadoEstacionado(){
        this.estacionado = !this.estacionado;
    }
}
