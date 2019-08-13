package EjercicioTragamonedas;

import java.util.Random;

public class Tambor {

    int posicion;

    public void girar() {
        Random r = new Random();
        this.posicion = r.nextInt(8) + 1;
    }

    public int obtenerPosicion(){
        System.out.println(this.posicion);
        return this.posicion;
    }
}
