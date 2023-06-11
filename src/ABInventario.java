import Arboles.ABDetalle;
import Arboles.ABFactura;
import Arboles.ABMarca;
import Arboles.ABProducto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ABInventario extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel marcaPanel;
    private JPanel productoPanel;
    private JPanel facturaVentaPanel;
    private JPanel detalleFacturaPanel;
    private JPanel informePanel;
    private JTextField marcaId;
    private JTextField marcaNombre;
    private JButton agregarMarcaBtn;
    private JButton editarMarcaBtn;
    private JButton eliminarMarcaBtn;
    private JTextField marcaIdBusqueda;
    private JTextField productoId;
    private JTextField descProducto;
    private JButton agregarProducto;
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
<<<<<<< Updated upstream
    private JButton deleteButton;
    private JComboBox comboBoxMarcas;
    private JTextArea marcaTextArea;
    private JButton buscarMarca;
    private ABMarca arbolMarcas;
    private ABProducto arbolProductos;
    private ABFactura arbolFacturas;
    private ABDetalle arbolDetalles;
    int marcaIndex = 0;
    int productoIndex = 1;
    int facturaIndex = 2;
    int detalleIndex = 3;
=======
    private JButton eliminarButton3;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JButton añadirButton;
    private JButton editarButton3;
    private JButton eliminarButton2;
    private JTextField textField15;
    private JComboBox comboBox7;
    private JButton mostrarDatosDeLasButton;
    private JTable table1;
>>>>>>> Stashed changes

    public ABInventario() {
        super("Inventario");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        arbolMarcas = new ABMarca();
        arbolProductos = new ABProducto();
        arbolFacturas = new ABFactura();
        arbolDetalles = new ABDetalle();

        agregarMarcaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarRegistro();
            }
        });
        editarMarcaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMarcas(marcaTextArea);
            }
        });
        buscarMarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarMarcas();
            }
        });
        agregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarRegistro();
            }
        });
    }

    public void agregarRegistro(){

        int registro = whichRegistro(tabbedPane1.getSelectedIndex());

        if(registro==0){
            String nombreAgregar = marcaNombre.getText();
            String marcaAgregar = marcaId.getText();
            if(codeIsNumber(marcaAgregar)){
                arbolMarcas.insertar(nombreAgregar, Integer.parseInt(marcaAgregar));
            }
            //Agregamos la marca al comboBox de marcas
            comboBoxMarcas.addItem(nombreAgregar);
            //Limpiamos la UI
            limpiarUIMarca();
        }
        else if(registro==1){
            String descProd = descProducto.getText();
            String prodIdAgregar = productoId.getText();
            if(codeIsNumber(prodIdAgregar)){
                //arbolProductos.insertar(descProd, Integer.parseInt(prodIdAgregar), (Integer) comboBoxMarcas.getSelectedItem());
            }
            limpiarProdUI();
        }
        else if(registro==2){

        }
        else if(registro==3){

        }
    }
    public void mostrarMarcas(JTextArea ta){
        arbolMarcas.imprimirEnOrden(ta);
    }
    public void buscarMarcas(){
        try{
            int idMarcaAgregar = Integer.parseInt(marcaId.getText());
            arbolMarcas.buscar(idMarcaAgregar);
        }catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "El codigo de la marca a buscar debe ser un número", "Advertencia", 1);
        }
    }
    public void actualizarMarca(){
        String nombreActualizar = marcaNombre.getText();
        try{
            int idMarcaAgregar = Integer.parseInt(marcaId.getText());
            arbolMarcas.editar(nombreActualizar,idMarcaAgregar);
        }catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "El codigo de la marca que desea actualizar debe ser un número", "Advertencia", 1);
        }
        limpiarUIMarca();
    }
    public void limpiarUIMarca(){
        marcaNombre.setText("");
        marcaId.setText("");
    }
    public void limpiarProdUI(){
        descProducto.setText("");
        productoId.setText("");
        comboBoxMarcas.setSelectedIndex(0);
    }
    public int whichRegistro(int tabActual){
        if(tabActual==marcaIndex){
            tabActual=0;
        }
        else if(tabActual==productoIndex){
            tabActual=1;
        }
        else if(tabActual==facturaIndex){
            tabActual=2;
        }
        else if(tabActual==detalleIndex){
            tabActual=3;
        }
        return tabActual;
    }
    public Boolean codeIsNumber(String code){
        try {
            Integer.parseInt(code);
        }
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "El codigo debe ser un numero", "Advertencia", 1);
            return false;
        }
        return true;
    }
}