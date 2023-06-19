package Nodos;

import java.time.LocalDate;
import java.time.LocalTime;
/**

 Esta clase representa un nodo en un árbol binario de detalles de facturas.

 Cada nodo contiene la información de un detalle de factura.
 */
public class NodoDetalle {
    public int idFactura;
    public int idDetalle;
    public int idProducto;
    public int cantidadProductos;
    public int valorProducto;
    public NodoDetalle hijoIzquierdo;
    public NodoDetalle hijoDerecho;

    /**

     Constructor de la clase NodoDetalle.
     */

    public NodoDetalle(int idFactura, int idDetalle, int idProducto, int cantidadProductos, int valorProducto) {
        this.idFactura = idFactura;
        this.idDetalle = idDetalle;
        this.idProducto = idProducto;
        this.cantidadProductos = cantidadProductos ;
        this.valorProducto = valorProducto;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
}
