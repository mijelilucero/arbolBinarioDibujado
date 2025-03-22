package umg.progra.arbolbinariodibujado;

public class Nodo {

    protected int dato;
    protected Nodo izdo;
    protected Nodo dcho;


    //Primer constructor
    public Nodo(int valor){
        dato = valor;
        izdo = dcho = null;
    }

    //Segundo
    public Nodo(Nodo ramaIzdo, int valor, Nodo ramaDcho){
        dato = valor;
        izdo = ramaIzdo;
        dcho = ramaDcho;
    }

    //Accesos
    public int valorNodo(){
        return dato;
    }

    public Nodo GetSubarbolIzdo(){
        return izdo;
    }

    public Nodo GetSubarbolDcho(){
        return dcho;
    }

    public void SetRamaIzdo(Nodo n){
        izdo = n;
    }

    public void SetRamaDcho(Nodo n){
        dcho = n;
    }

    public void imprimirDato(){
        System.out.println(this.valorNodo());
    }
}