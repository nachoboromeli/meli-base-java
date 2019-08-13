package myPackage;

public class Cerradura {

    public int Clave;
    public boolean isOpen = false;

    public  Cerradura(){

    }

    public Cerradura(int clave){

        this.Clave = clave;
    }

    public void Abrir(int clave){
       this.isOpen = clave == this.Clave;
    }

    public  void Cerrar(){
        this.isOpen = false;
    }
}
