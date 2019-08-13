package EjercicioLibrerias;

import java.time.LocalDateTime;

public class LibroAlquilable extends Libro {

    private Boolean alquilado;

    public LibroAlquilable(String titulo, String editorial){
        super(titulo, editorial);
        this.alquilado = false;
    }

    public void alquilarLibro(){
        if(!this.alquilado){
            Libreria libreria = Libreria.getInstance();
            Alquiler alquiler = new Alquiler(this, LocalDateTime.now());
            libreria.agregarAlquilerALista(alquiler);
            this.alquilado = true;
        }
    }

    public void devolverLibro(){
        if (this.alquilado){
            Libreria libreria = Libreria.getInstance();
            Alquiler alquilerDeLibro = libreria.buscar(this.getTitulo());
            libreria.listadoAlquileres.remove(alquilerDeLibro);
            this.alquilado = false;
        }
    }

    public boolean obtenerEstadoAlquilado(){
        return this.alquilado;
    }
}
