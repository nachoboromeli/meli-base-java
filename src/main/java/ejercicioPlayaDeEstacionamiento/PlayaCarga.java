package ejercicioPlayaDeEstacionamiento;

import java.util.LinkedList;

public class PlayaCarga {
    public LinkedList<Carga> listadoDeCargas;
    public boolean ingresoVehiculosHabilitado;
    public LinkedList<Utilitarios> listadoUtilitarios;
    public int cargaDespachada = 0;

    private static PlayaCarga playaCargaUnica = new PlayaCarga();

    public static PlayaCarga getInstance() {
        return playaCargaUnica;
    }

    public PlayaCarga(){
        listadoDeCargas = new LinkedList();
        listadoUtilitarios = new LinkedList();
        decidirEstacionamientoHabilitado();
    }

    public void decidirEstacionamientoHabilitado(){
        ingresoVehiculosHabilitado = listadoDeCargas.size() >= 0;
    }

    public boolean playaContieneCarga(Carga carga){
        return listadoDeCargas.contains(carga);
    }

    public boolean playaContieneUtilitario(Utilitarios utilitarios){
        return listadoUtilitarios.contains(utilitarios);
    }

    public void agregarCarga(Carga carga){
        if (!playaContieneCarga(carga)){
            listadoDeCargas.add(carga);
        }
    }

    public void quitarCarga(Carga carga){
        if (playaContieneCarga(carga)){
            listadoDeCargas.remove(carga);
            this.cargaDespachada += carga.kilos;
        }
        decidirEstacionamientoHabilitado();
    }

    public void quitarUtilitario(Utilitarios utilitarios){
        if (playaContieneUtilitario(utilitarios)){
            listadoUtilitarios.remove(utilitarios);
        }
    }

    public void agregarUtilitario(Utilitarios utilitarios){
        if (!playaContieneUtilitario(utilitarios)){
            listadoUtilitarios.add(utilitarios);
        }
    }

}
