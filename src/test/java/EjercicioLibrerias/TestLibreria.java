package EjercicioLibrerias;

import org.junit.Assert;
import org.junit.Before;
import org.assertj.core.api.Assertions;
import org.junit.Test;


import java.time.LocalDateTime;

public class TestLibreria {

    @Before
    public void LimpiarAlquileresDeLibreria(){
        Libreria libreria = Libreria.getInstance();
        libreria.listadoAlquileres.clear();
    }
    @Test
    public void AsignarAlquilerALibreria(){
        Libreria libreria = Libreria.getInstance();
        Novela novela = new Novela("Nacho", "MercadoLibre");
        boolean estadoInicialDeAlquiler = novela.obtenerEstadoAlquilado();
        int cantidadDeLibrosIniciales = libreria.obtenerCantidadLibrosAlquilados();
        novela.alquilarLibro();
        boolean estadoFinalDeAlquiler = novela.obtenerEstadoAlquilado();
        int cantidadDeLibrosFinales = libreria.obtenerCantidadLibrosAlquilados();
        Assertions.assertThat(estadoFinalDeAlquiler).isNotEqualTo(estadoInicialDeAlquiler);
        Assertions.assertThat(cantidadDeLibrosFinales).isGreaterThan(cantidadDeLibrosIniciales);


    }

    @Test
    public void AsignarAlquilerALibreriaConLibroAlquilado(){
        Libreria libreria = Libreria.getInstance();
        Novela novela = new Novela("Nacho", "MercadoLibre");
        novela.alquilarLibro();
        boolean estadoInicialDeAlquiler = novela.obtenerEstadoAlquilado();
        int cantidadDeLibrosIniciales = libreria.obtenerCantidadLibrosAlquilados();
        novela.alquilarLibro();
        boolean estadoFinalDeAlquiler = novela.obtenerEstadoAlquilado();
        int cantidadDeLibrosFinales = libreria.obtenerCantidadLibrosAlquilados();

        Assertions.assertThat(estadoFinalDeAlquiler).isEqualTo(estadoInicialDeAlquiler);
        Assertions.assertThat(cantidadDeLibrosFinales).isEqualTo(cantidadDeLibrosIniciales);
    }

    @Test
    public void DevolverAlquilerALibreria(){
        Libreria libreria = Libreria.getInstance();
        Novela novela = new Novela("Nacho", "MercadoLibre");
        novela.alquilarLibro();
        boolean estadoInicialDeAlquiler = novela.obtenerEstadoAlquilado();
        int cantidadDeLibrosIniciales = libreria.obtenerCantidadLibrosAlquilados();
        novela.devolverLibro();
        boolean estadoFinalDeAlquiler = novela.obtenerEstadoAlquilado();
        int cantidadDeLibrosFinales = libreria.obtenerCantidadLibrosAlquilados();
        Assertions.assertThat(estadoFinalDeAlquiler).isNotEqualTo(estadoInicialDeAlquiler);
        Assertions.assertThat(cantidadDeLibrosFinales).isLessThan(cantidadDeLibrosIniciales);


    }

    @Test
    public void crearNovelaConAlquiler(){
        Libreria libreria = Libreria.getInstance();
        Novela novela = new Novela("Nacho", "MercadoLibre");
        Alquiler alquiler = new Alquiler(novela, LocalDateTime.now());


    }

}
