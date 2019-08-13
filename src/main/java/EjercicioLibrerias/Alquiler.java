package EjercicioLibrerias;

import java.time.LocalDateTime;
import java.util.Date;

public class Alquiler {
    private LocalDateTime fechaAlquiler;
    private LocalDateTime fechaDevolucion;
    private LibroAlquilable libro;


    public Alquiler(LibroAlquilable libro, LocalDateTime fechaAlquiler){
        this.libro = libro;
        this.fechaAlquiler = fechaAlquiler;
    }

    public String getLibroAlquilado(){
        return this.libro.getTitulo();
    }
}
