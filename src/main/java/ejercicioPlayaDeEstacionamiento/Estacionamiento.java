package ejercicioPlayaDeEstacionamiento;

import java.util.LinkedList;

public class Estacionamiento {

    private static Estacionamiento estacionamientoUnico = new Estacionamiento();
    public LinkedList<Vehiculo> listadoVehiculos;

    public static Estacionamiento getInstance() {
        return estacionamientoUnico;
    }

    public Estacionamiento(){
        listadoVehiculos = new LinkedList();
    }

    public void estacionarVehiculo(Vehiculo vehiculo){
        if (!listadoVehiculos.contains(vehiculo) && !vehiculo.estacionado){
            listadoVehiculos.add(vehiculo);
            vehiculo.cambiarEstadoEstacionado();
        }
    }

    public boolean vehiculoEstaEstacionado(Vehiculo vehiculo){
        return listadoVehiculos.contains(vehiculo);
    }

    public void desestacionarVehiculo(Vehiculo vehiculo){
        if (listadoVehiculos.contains(vehiculo)){
            listadoVehiculos.remove(vehiculo);
            vehiculo.cambiarEstadoEstacionado();
        }

    }
}
