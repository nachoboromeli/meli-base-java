package ejercicioPlayaDeEstacionamiento;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class EstacionamientoTest {

    @Test
    public void CrearEstacionamiento(){
        Estacionamiento estacionamiento = new Estacionamiento();
        Assertions.assertThat(estacionamiento).isNotNull();
    }

    @Test
    public void CrearPlayaDeCarga(){
        PlayaCarga playaCarga = new PlayaCarga();
        Assertions.assertThat(playaCarga).isNotNull();
    }

    @Test
    public void CrearAuto(){

        Auto auto = new Auto();
        Assertions.assertThat(auto).isNotNull();
    }

    @Test
    public void CrearCamion(){
        Camion camion = new Camion(50);
        Assertions.assertThat(camion).isNotNull();
    }

    @Test
    public void CrearCamioneta(){
        Camioneta camioneta = new Camioneta(50);
        Assertions.assertThat(camioneta).isNotNull();
    }

    @Test
    public void CrearCarga(){
        Carga carga = new Carga(50);
        Assertions.assertThat(carga).isNotNull();
    }

    @Test
    public void EstacionarAutoNoEstacionado(){

        Estacionamiento estacionamiento = new Estacionamiento();
        Auto auto = new Auto();
        boolean elAutoEstaEstacionadoInicialmente = estacionamiento.vehiculoEstaEstacionado(auto);
        Assertions.assertThat(elAutoEstaEstacionadoInicialmente).isFalse();
        estacionamiento.estacionarVehiculo(auto);
        boolean elAutoEstaEstacionadoFinalmente = estacionamiento.vehiculoEstaEstacionado(auto);
        Assertions.assertThat(elAutoEstaEstacionadoFinalmente).isTrue();
    }

    @Test
    public void EstacionarAutoEstacionado() {
        Estacionamiento estacionamiento = new Estacionamiento();
        Auto auto = new Auto();
        estacionamiento.estacionarVehiculo(auto);
        boolean elAutoEstaEstacionadoInicialmente = estacionamiento.vehiculoEstaEstacionado(auto);
        Assertions.assertThat(elAutoEstaEstacionadoInicialmente).isTrue();
        estacionamiento.estacionarVehiculo(auto);
        Assertions.assertThat(auto.estacionado).isTrue();
    }

    @Test
    public void DesestacionarAuto(){

        Estacionamiento estacionamiento = new Estacionamiento();
        Auto auto = new Auto();
        estacionamiento.estacionarVehiculo(auto);
        boolean elAutoEstaEstacionado = estacionamiento.vehiculoEstaEstacionado(auto);
        Assertions.assertThat(elAutoEstaEstacionado).isTrue();
        estacionamiento.desestacionarVehiculo(auto);
        boolean elAutoFueDesestacionado = estacionamiento.vehiculoEstaEstacionado(auto);
        Assertions.assertThat(elAutoFueDesestacionado).isFalse();
    }

    @Test
    public void CargarAuto(){
        Estacionamiento estacionamiento = new Estacionamiento();
        Auto auto = new Auto();
        estacionamiento.estacionarVehiculo(auto);
        boolean elAutoEstaEstacionado = estacionamiento.vehiculoEstaEstacionado(auto);
        Assertions.assertThat(elAutoEstaEstacionado).isTrue();
        estacionamiento.desestacionarVehiculo(auto);
        boolean elAutoFueDesestacionado = estacionamiento.vehiculoEstaEstacionado(auto);
        Assertions.assertThat(elAutoFueDesestacionado).isFalse();
    }

    @Test
    public void AsignarCarga(){
        PlayaCarga playaCarga = new PlayaCarga();
        Carga carga = new Carga(50);
        boolean playaContieneCargaInicialmente = playaCarga.playaContieneCarga(carga);
        Assertions.assertThat(playaContieneCargaInicialmente).isFalse();
        playaCarga.agregarCarga(carga);
        boolean playaContieneCargaFinalmente = playaCarga.playaContieneCarga(carga);
        Assertions.assertThat(playaContieneCargaFinalmente).isTrue();
    }

    @Test
    public void AsignarCargaDuplicada(){
        PlayaCarga playaCarga = new PlayaCarga();
        Carga carga = new Carga(50);
        playaCarga.agregarCarga(carga);
        int cantidadInicialDeCargas = playaCarga.listadoDeCargas.size();
        playaCarga.agregarCarga(carga);
        int cantidadFinalDeCargas = playaCarga.listadoDeCargas.size();
        Assertions.assertThat(cantidadFinalDeCargas).isEqualTo(cantidadInicialDeCargas);

    }

    @Test
    public void QuitarCarga(){
        PlayaCarga playaCarga = new PlayaCarga();
        Carga carga = new Carga(50);
        playaCarga.agregarCarga(carga);
        boolean playaContieneCargaInicialmente = playaCarga.playaContieneCarga(carga);
        Assertions.assertThat(playaContieneCargaInicialmente).isTrue();
        playaCarga.quitarCarga(carga);
        boolean playaContieneCargaFinalmente = playaCarga.playaContieneCarga(carga);
        Assertions.assertThat(playaContieneCargaFinalmente).isFalse();
    }

    @Test
    public void QuitarCargaInexistente(){
        PlayaCarga playaCarga = new PlayaCarga();
        Carga carga = new Carga(50);
        boolean playaContieneCargaInicialmente = playaCarga.playaContieneCarga(carga);
        int cantidadInicialDeCargas = playaCarga.listadoDeCargas.size();
        Assertions.assertThat(playaContieneCargaInicialmente).isFalse();
        playaCarga.quitarCarga(carga);
        int cantidadFinalDeCargas = playaCarga.listadoDeCargas.size();
        boolean playaContieneCargaFinalmente = playaCarga.playaContieneCarga(carga);
        Assertions.assertThat(playaContieneCargaFinalmente).isFalse();
        Assertions.assertThat(cantidadFinalDeCargas).isEqualTo(cantidadInicialDeCargas);
    }

    @Test
    public void AgregarUtilitario(){
        PlayaCarga playaCarga = new PlayaCarga();
        Camioneta camioneta = new Camioneta(50);
        boolean playaContieneCamionetaInicialmente = playaCarga.playaContieneUtilitario(camioneta);
        Assertions.assertThat(playaContieneCamionetaInicialmente).isFalse();
        playaCarga.agregarUtilitario(camioneta);
        boolean playaContieneCamionetaFinalmente = playaCarga.playaContieneUtilitario(camioneta);
        Assertions.assertThat(playaContieneCamionetaFinalmente).isTrue();
    }

    @Test
    public void AgregarUtilitarioDuplicado(){
        PlayaCarga playaCarga = new PlayaCarga();
        Camioneta camioneta = new Camioneta(50);
        playaCarga.agregarUtilitario(camioneta);
        boolean playaContieneCamionetaInicialmente = playaCarga.playaContieneUtilitario(camioneta);
        int cantidadInicialDeUtilitarios = playaCarga.listadoUtilitarios.size();
        Assertions.assertThat(playaContieneCamionetaInicialmente).isTrue();
        playaCarga.agregarUtilitario(camioneta);
        boolean playaContieneCamionetaFinalmente = playaCarga.playaContieneUtilitario(camioneta);
        int cantidadFinalDeUtilitarios = playaCarga.listadoUtilitarios.size();
        Assertions.assertThat(playaContieneCamionetaFinalmente).isTrue();
        Assertions.assertThat(cantidadFinalDeUtilitarios).isEqualTo(cantidadInicialDeUtilitarios);
    }

    @Test
    public void QuitarUtilitario(){
        PlayaCarga playaCarga = new PlayaCarga();
        Camioneta camioneta = new Camioneta(50);
        playaCarga.agregarUtilitario(camioneta);
        boolean playaContieneCamionetaInicialmente = playaCarga.playaContieneUtilitario(camioneta);
        Assertions.assertThat(playaContieneCamionetaInicialmente).isTrue();
        playaCarga.quitarUtilitario(camioneta);
        boolean playaContieneCamionetaFinalmente = playaCarga.playaContieneUtilitario(camioneta);
        Assertions.assertThat(playaContieneCamionetaFinalmente).isFalse();
    }

    @Test
    public void QuitarUtilitarioInexistente(){
        PlayaCarga playaCarga = new PlayaCarga();
        Camioneta camioneta = new Camioneta(50);
        boolean playaContieneCamionetaInicialmente = playaCarga.playaContieneUtilitario(camioneta);
        Assertions.assertThat(playaContieneCamionetaInicialmente).isFalse();
        int cantidadFinalDeUtilitarios = playaCarga.listadoUtilitarios.size();
        playaCarga.quitarUtilitario(camioneta);
        boolean playaContieneCamionetaFinalmente = playaCarga.playaContieneUtilitario(camioneta);
        Assertions.assertThat(playaContieneCamionetaFinalmente).isFalse();
        int cantidadFinalDeUtilitariosRenew = playaCarga.listadoUtilitarios.size();
        Assertions.assertThat(cantidadFinalDeUtilitarios).isEqualTo(cantidadFinalDeUtilitariosRenew);
    }

    @Test
    public void AsignarCargaUtilitario(){
        PlayaCarga playaCarga = new PlayaCarga();
        Camioneta camioneta = new Camioneta(70);
        Carga carga = new Carga(30);
        camioneta.agregarCarga(carga);
        Assertions.assertThat(camioneta.getKilosCargaActual()).isEqualTo(carga.kilos);
    }

    @Test
    public void AsignarCargaUtilitarioYDespacharCargaPlaya(){
        PlayaCarga playaCarga = new PlayaCarga();
        Camioneta camioneta = new Camioneta(70);
        Carga carga = new Carga(30);
        int cargaPrevia=playaCarga.cargaDespachada;

        playaCarga.agregarCarga(carga);
        camioneta.agregarCarga(carga);
        playaCarga.quitarCarga(carga);
        //Asignar carga utilitario
        Assertions.assertThat(camioneta.getKilosCargaActual()).isEqualTo(carga.kilos);
        //carga Playa
        Assertions.assertThat(playaCarga.cargaDespachada).isEqualTo(cargaPrevia+carga.kilos);

    }


}
