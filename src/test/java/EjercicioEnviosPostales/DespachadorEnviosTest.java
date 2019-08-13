package EjercicioEnviosPostales;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DespachadorEnviosTest {

    @Mock private Envio mockEnvio;

    @Test
    public void crearPaqueteConPeso(){
        Paquete paquete = new Paquete(20);
        Assertions.assertThat(paquete.getPeso()).isEqualTo(20);
    }

    @Test
    public void calcularCostoDeEnvioPaquete(){

        when(mockEnvio.obtenerCantidadPaquetes()).thenReturn(4);
        Despachador despachador= new Despachador();
        Assertions.assertThat(despachador.obtenerCostoEnvio(mockEnvio)).isEqualTo(50);

        when(mockEnvio.obtenerCantidadPaquetes()).thenReturn(9);
        Assertions.assertThat(despachador.obtenerCostoEnvio(mockEnvio)).isEqualTo(80);

        when(mockEnvio.obtenerCantidadPaquetes()).thenReturn(22);
        Assertions.assertThat(despachador.obtenerCostoEnvio(mockEnvio)).isEqualTo(275);
    }

    @Test
    public void asignarVehiculo(){

        Despachador despachador = new Despachador();
        String vehiculoQueEnvia;

        when(mockEnvio.obtenerPesoPaquetes()).thenReturn(4);

        vehiculoQueEnvia = despachador.asignarVehiculo(mockEnvio);
        Assertions.assertThat(vehiculoQueEnvia).isEqualTo("Bicicleta");

        when(mockEnvio.obtenerPesoPaquetes()).thenReturn(49);

        vehiculoQueEnvia = despachador.asignarVehiculo(mockEnvio);
        Assertions.assertThat(vehiculoQueEnvia).isEqualTo("Auto");

        when(mockEnvio.obtenerPesoPaquetes()).thenReturn(149);

        vehiculoQueEnvia = despachador.asignarVehiculo(mockEnvio);
        Assertions.assertThat(vehiculoQueEnvia).isEqualTo("Camion");

        when(mockEnvio.obtenerPesoPaquetes()).thenReturn(151);

        vehiculoQueEnvia = despachador.asignarVehiculo(mockEnvio);
        Assertions.assertThat(vehiculoQueEnvia).isEqualTo("No hay vehículo disponible");
    }

    @Test
    public void asignarVehiculoSinMock(){
        Despachador despachador = new Despachador();
        String vehiculoQueEnvia;

        Envio envio = new Envio();
        Paquete paquete1 = new Paquete(1);
        Paquete paquete2 = new Paquete(2);

        envio.agregarPaqueteAListado(paquete1);
        envio.agregarPaqueteAListado(paquete2);

        vehiculoQueEnvia = despachador.asignarVehiculo(envio);

        Assertions.assertThat(vehiculoQueEnvia).isEqualTo("Bicicleta");

        paquete1.setPeso(9);
        vehiculoQueEnvia = despachador.asignarVehiculo(envio);

        Assertions.assertThat(vehiculoQueEnvia).isEqualTo("Auto");

        paquete1.setPeso(49);
        vehiculoQueEnvia = despachador.asignarVehiculo(envio);
        Assertions.assertThat(vehiculoQueEnvia).isEqualTo("Camion");

        paquete1.setPeso(149);
        vehiculoQueEnvia = despachador.asignarVehiculo(envio);
        Assertions.assertThat(vehiculoQueEnvia).isEqualTo("No hay vehículo disponible");



    }

}
