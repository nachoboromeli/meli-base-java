package EjercicioEnviosPostales;

public class Despachador {

    /*public Calculador calculador;
    public Asignador asignador;*/

    public Despachador(){

    }

    public int obtenerCostoEnvio(Envio envio){
        return Calculador.calcularEnvio(envio);
    }
    public String asignarVehiculo(Envio envio){
        return Asignador.asignarEnvio(envio);
    }
}
