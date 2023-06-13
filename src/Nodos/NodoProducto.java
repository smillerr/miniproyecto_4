package Nodos;

/**

 Esta clase representa un nodo en un árbol binario de productos.

 Cada nodo contiene la información de un producto.
 */
public class NodoProducto {
    public String descProducto;
    public int idProducto;
    public int idMarca;
    public NodoProducto hijoIzquierdo;
    public NodoProducto hijoDerecho;
    /**

     Constructor de la clase NodoProducto.
     */

    public NodoProducto(String descProducto, int idProducto, int idMarca) {
        this.descProducto = descProducto;
        this.idProducto = idProducto;
        this.idMarca = idMarca;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
}