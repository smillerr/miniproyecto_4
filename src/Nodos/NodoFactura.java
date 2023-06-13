package Nodos;
import java.time.*;

/**

 Esta clase representa un nodo en un árbol binario de facturas.

 Cada nodo contiene la información de una factura.
 */
public class NodoFactura {
    public int idFactura;
    public LocalDate fechaFactura;
    public LocalTime horaFactura;
    public NodoFactura hijoIzquierdo;
    public NodoFactura hijoDerecho;

    /**

     Constructor de la clase NodoFactura.
     */
    public NodoFactura(int idFactura, LocalDate fechaFactura, LocalTime horaFactura) {
        this.idFactura = idFactura;
        this.fechaFactura = fechaFactura;
        this.horaFactura = horaFactura;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }





}
