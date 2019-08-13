package EjercicioEnviosPostales;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Envio {

    private List<Paquete> listadoPaquetes = new LinkedList<>();

    public void agregarPaqueteAListado(Paquete paquete){
        this.listadoPaquetes.add(paquete);
    }

    public int obtenerCantidadPaquetes() {
        return this.listadoPaquetes.size();
    }

    public int obtenerPesoPaquetes() {
        return this.listadoPaquetes.stream().map(e -> e.getPeso()).reduce((a, b) -> a + b).get();
    }
}
