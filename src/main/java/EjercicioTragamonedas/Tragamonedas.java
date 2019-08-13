package EjercicioTragamonedas;


import java.util.LinkedList;
import java.util.List;

public class Tragamonedas {
    private List<Tambor> listaTambores;

    public Tragamonedas(){
        listaTambores = new LinkedList<>();
    }

    public void agregarTamborALista(Tambor tambor){
        listaTambores.add(tambor);
    }

    public int cantidadTambores(){
        return listaTambores.size();
    }

    public List<Tambor> getListadoTambores(){
        return this.listaTambores;
    }

    public void activar(){
        for (Tambor tambor: listaTambores) {
            tambor.girar();
        }
    }

    public boolean entregaPremio() {
        boolean valido = true;
        int current = 0;
        for (Tambor tambor: this.getListadoTambores()) {
            valido = current == 0 ? valido : current == tambor.obtenerPosicion();
            current = tambor.obtenerPosicion();
        }
        return valido;
    }
}
