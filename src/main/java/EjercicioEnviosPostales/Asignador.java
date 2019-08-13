package EjercicioEnviosPostales;

public class Asignador {

    public static String asignarEnvio(Envio envio) {
        if (envio.obtenerPesoPaquetes()< 5){
            return "Bicicleta";
        }
        else if (envio.obtenerPesoPaquetes() < 50){
            return "Auto";
        }
        else if (envio.obtenerPesoPaquetes() <= 150){
            return "Camion";
        }
        else{
            return "No hay vehículo disponible";
        }
    }
}
