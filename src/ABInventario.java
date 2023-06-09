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
    private JTextField textField1;
    private JTextField textField2;
    private JButton agregarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton agregarButton1;
    private JButton editarButton1;
    private JButton eliminarButton1;
    private JTextField textField7;
    private JTextField textField8;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JButton agregarButton2;
    private JButton editarButton2;
    private JButton deleteButton;

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