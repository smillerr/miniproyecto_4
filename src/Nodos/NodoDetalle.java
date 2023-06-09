package Nodos;

import java.time.LocalDate;
import java.time.LocalTime;

public class NodoDetalle {
    public int idFactura;
    public int idDetalle;
    public int idProducto;
    public int cantidadProductos;
    public int valorProducto;
    public NodoDetalle hijoIzquierdo;
    public NodoDetalle hijoDerecho;

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
