package EjercicioEnviosPostales;

public class Calculador {

    public static int calcularEnvio(Envio envio){

        if (envio.obtenerCantidadPaquetes()< 5){
            return 50;
        }
        else if (envio.obtenerCantidadPaquetes() < 10){
            return 80;
        }
        else{
            return 80 + ((envio.obtenerCantidadPaquetes() - 9) * 15);
        }
    }
}
