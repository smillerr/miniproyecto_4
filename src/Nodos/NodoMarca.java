package Nodos;
public class NodoMarca {
    public String nombreMarca;
    public int idMarca;
    public NodoMarca hijoIzquierdo;
    public NodoMarca hijoDerecho;

    public NodoMarca(String nombreMarca, int idMarca) {
        this.nombreMarca = nombreMarca;
        this.idMarca = idMarca;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
}
