package EjercicioLibrerias;

public abstract class Libro {
    private String titulo;
    private String editorial;

    public Libro (String titulo, String editorial) {
        this.titulo = titulo;
        this.editorial= editorial;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getEditorial(){
        return this.editorial;
    }

}
