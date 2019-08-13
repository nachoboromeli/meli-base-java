package EjercicioLibrerias;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Libreria {
    private static Libreria instance = new Libreria();
    public LinkedList<Alquiler> listadoAlquileres= new LinkedList<>();

    public static Libreria getInstance(){
        return instance;
    }

    public void agregarAlquilerALista(Alquiler alquiler){
        listadoAlquileres.add(alquiler);
    }

    public int obtenerCantidadLibrosAlquilados(){
        return this.listadoAlquileres.size();
    }

    public Alquiler buscar(String titulo){

        Predicate<Alquiler> buscarAlquilerPorLibro = alquiler -> alquiler.getLibroAlquilado().equals(titulo);
        Optional<Alquiler> alquilerADevolver = listadoAlquileres.stream().filter(buscarAlquilerPorLibro).findFirst();
        return alquilerADevolver.isPresent() ? alquilerADevolver.get() : new Alquiler(null, null);
    }

}
