package TreeMapValues;

import java.time.LocalDate;
import java.time.LocalTime;

public class Factura {
    public int idFactura;
    public LocalDate fechaFactura;
    public LocalTime horaFactura;

    /**

     Constructor de la clase Factura.
     */
    public Factura(int idFactura, LocalDate fechaFactura, LocalTime horaFactura) {
        this.idFactura = idFactura;
        this.fechaFactura = fechaFactura;
        this.horaFactura = horaFactura;
    }
}
