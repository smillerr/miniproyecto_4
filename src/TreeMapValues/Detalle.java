package TreeMapValues;

public class Detalle {
    public int idFactura;
    public int idDetalle;
    public int idProducto;
    public int cantidadProductos;
    public int valorProducto;
    /**

     Constructor de la clase Detalle.
     */

    public Detalle(int idFactura, int idDetalle, int idProducto, int cantidadProductos, int valorProducto) {
        this.idFactura = idFactura;
        this.idDetalle = idDetalle;
        this.idProducto = idProducto;
        this.cantidadProductos = cantidadProductos ;
        this.valorProducto = valorProducto;
    }
}
