package Nodos;
/**

 Esta clase representa un nodo en un árbol binario de marcas.

 Cada nodo contiene la información de una marca.
 */
public class NodoMarca {
    public String nombreMarca;
    public int idMarca;
    public NodoMarca hijoIzquierdo;
    public NodoMarca hijoDerecho;
    /**

     Constructor de la clase NodoMarca.
     */

    public NodoMarca(String nombreMarca, int idMarca) {
        this.nombreMarca = nombreMarca;
        this.idMarca = idMarca;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
}
