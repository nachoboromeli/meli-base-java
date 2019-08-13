package EjercicioTragamonedas;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TragamonedasTest {

    @Test
    public void CrearTragaMonedasYTambores(){
        Tragamonedas tragamonedas = new Tragamonedas();
        for(int i=1;i<=3;i++){
            Tambor tambor = new Tambor();
            tragamonedas.agregarTamborALista(tambor);
        }

        Assertions.assertThat(tragamonedas.cantidadTambores()).isEqualTo(3);
    }

    @Test
    public void girarTambor(){
        Tambor tambor = new Tambor();
        tambor.girar();
        Assertions.assertThat(tambor.obtenerPosicion()).isBetween(1, 8);
    }

    @Test
    public void activarTragaMonedas(){
        Tragamonedas tragamonedas = new Tragamonedas();

        for(int i=1;i<=3;i++){
            Tambor tambor = new Tambor();
            tragamonedas.agregarTamborALista(tambor);
        }

        tragamonedas.activar();
        for (Tambor tambor: tragamonedas.getListadoTambores()) {
           Assertions.assertThat(tambor.obtenerPosicion()).isBetween(1, 8);
        }
    }

    @Test
    public void ganarTragamonedas(){
        Tragamonedas tragamonedas = new Tragamonedas();

        for(int i=1;i<=3;i++){
            FakeTambor tambor = new FakeTambor();
            tragamonedas.agregarTamborALista(tambor);
        }

        tragamonedas.activar();
        for (Tambor tambor: tragamonedas.getListadoTambores()) {
            Assertions.assertThat(tambor.obtenerPosicion()).isEqualTo(1);
        }
        Assertions.assertThat(tragamonedas.entregaPremio()).isTrue();
    }
}
