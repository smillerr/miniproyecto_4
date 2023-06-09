import Arboles.ABMarca;

import javax.swing.*;

public class ABInventario extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel marcaPanel;
    private JPanel productoPanel;
    private JPanel facturaVentaPanel;
    private JPanel detalleFacturaPanel;
    private JPanel informePanel;

    public ABInventario() {
        super("Inventario");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ABMarca arbolTest = new ABMarca();

        arbolTest.insertar("Nike" , 1);
        arbolTest.insertar("Adidas" , 2);
        arbolTest.insertar("Puma" , 3);
        arbolTest.insertar("Gucci" , 4);

        System.out.println(arbolTest.buscar(3));
        String result = arbolTest.eliminar(15);
        if(result.equals("")) System.out.println("Lo sentimos, estas tratando de eliminar algo que no existe");
        System.out.println(arbolTest.eliminar(7));
    }
}