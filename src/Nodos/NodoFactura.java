package Nodos;
import java.time.*;
public class NodoFactura {
    public int idFactura;
    public LocalDate fechaFactura;
    public LocalTime horaFactura;
    public NodoFactura hijoIzquierdo;
    public NodoFactura hijoDerecho;

    public NodoFactura(int idFactura, LocalDate fechaFactura, LocalTime horaFactura) {
        this.idFactura = idFactura;
        this.fechaFactura = fechaFactura;
        this.horaFactura = horaFactura;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }





}
