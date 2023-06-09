package Nodos;

public class NodoProducto {
    public String descProducto;
    public int idProducto;
    public int idMarca;
    public NodoProducto hijoIzquierdo;
    public NodoProducto hijoDerecho;

    public NodoProducto(String descProducto, int idProducto, int idMarca) {
        this.descProducto = descProducto;
        this.idProducto = idProducto;
        this.idMarca = idMarca;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
}