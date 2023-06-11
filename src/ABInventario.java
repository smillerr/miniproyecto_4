import Arboles.ABDetalle;
import Arboles.ABFactura;
import Arboles.ABMarca;
import Arboles.ABProducto;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.*;

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
    private JTextField facturaId;
    private JComboBox mesComboBox;
    private JComboBox diaComboBox;
    private JComboBox yearComboBox;
    private JComboBox horaComboBox;
    private JComboBox minutoComboBox;
    private JButton agregarFactura;
    private JButton editarButton2;

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
    private JButton eliminarButton3;
    private JTextField textField9;
    private JTextField detalleId;
    private JTextField undText;
    private JTextField priceText;
    private JButton añadirButton;
    private JButton editarButton3;
    private JButton eliminarButton2;
    private JTextField textField15;
    private JComboBox comboBox7;
    private JButton mostrarDatosDeLasButton;
    private JTable table1;
    private JTextArea facturaTextArea;
    private JComboBox comboBoxProductos;
    private JComboBox comboBoxFacturas;

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

        agregarFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarRegistro();
            }
        });
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarRegistro();
            }
        });
    }

    public void agregarRegistro(){

        int registro = whichRegistro(tabbedPane1.getSelectedIndex());

        if(registro==0){
            if(!marcaNombre.getText().equals("") && !marcaId.getText().equals("")){
                String nombreAgregar = marcaNombre.getText();
                String marcaAgregar = marcaId.getText();
                if(codeIsNumber(marcaAgregar)){
                    arbolMarcas.insertar(nombreAgregar, Integer.parseInt(marcaAgregar));
                }
                else{
                    return;
                }
                //Agregamos la marca al comboBox de marcas
                comboBoxMarcas.addItem(marcaAgregar + "-" + nombreAgregar);
                //Limpiamos la UI
                limpiarUIMarca();
            }
            else{
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else if(registro==1){
            if(descProducto.getText()!="" && productoId.getText()!="" && comboBoxMarcas.getSelectedIndex()!=0){
                String descProd = descProducto.getText();
                String prodIdAgregar = productoId.getText();
                if(codeIsNumber(prodIdAgregar)){
                    int selectedIndex = comboBoxMarcas.getSelectedIndex();
                    // Retrieve the selected item
                    String selectedText = (String) comboBoxMarcas.getItemAt(selectedIndex);
                    int idNewMarca = idFromText(selectedText);
                    arbolProductos.insertar(descProd, Integer.parseInt(prodIdAgregar), idNewMarca);
                }
                else return;
                comboBoxProductos.addItem(Integer.parseInt(prodIdAgregar) + "-" + descProd);
                limpiarUIProd();
            }
            else{
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else if(registro==2){
            if(!facturaId.getText().equals("")){
                String facturaAgregar = facturaId.getText();
                if(codeIsNumber(facturaAgregar)){
                    //Capturamos la fecha que indico el usuario
                    int selectedMesIndex = mesComboBox.getSelectedIndex();
                    int selectedDiaIndex = diaComboBox.getSelectedIndex();
                    int selectedYearIndex = yearComboBox.getSelectedIndex();
                    // Devolvemos el contenido de los items seleccionados
                    String selectedMes = (String) mesComboBox.getItemAt(selectedMesIndex);
                    String selectedDia = (String) diaComboBox.getItemAt(selectedDiaIndex);
                    String selectedYear = (String) yearComboBox.getItemAt(selectedYearIndex);
                    //Capturamos la hora seleccionada por el usuario
                    int selectedHoraIndex = horaComboBox.getSelectedIndex();
                    int selectedMintuoIndex = minutoComboBox.getSelectedIndex();
                    //Devolvemos el contenido de los items seleccionados
                    String selectedHora = (String) horaComboBox.getItemAt(selectedHoraIndex);
                    String selectedMinuto = (String) minutoComboBox.getItemAt(selectedMintuoIndex);
                    LocalDate fechaAgregar = LocalDate.of(Integer.parseInt(selectedYear), Integer.parseInt(selectedMes), Integer.parseInt(selectedDia));
                    LocalTime horaAgregar = LocalTime.of(Integer.parseInt(selectedHora), Integer.parseInt(selectedMinuto));

                    arbolFacturas.insertar(Integer.parseInt(facturaAgregar), fechaAgregar, horaAgregar);
                }
                else return;
                comboBoxFacturas.addItem("Factura con id:" + Integer.parseInt(facturaAgregar));
                limpiarUIFact();
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else if(registro==3){
            if(comboBoxFacturas.getSelectedIndex()!=0 && comboBoxProductos.getSelectedIndex()!=0 && !undText.equals("") && !priceText.equals("")){
                String cantidad = undText.getText();
                String price = priceText.getText();
                String detalle = detalleId.getText();
                if(codeIsNumber(cantidad) && codeIsNumber(price) && codeIsNumber(detalle)){
                    int productoIndex = comboBoxProductos.getSelectedIndex();
                    int facturaIndex = comboBoxFacturas.getSelectedIndex();
                    String selectedProducto = (String) comboBoxProductos.getItemAt(productoIndex);
                    String selectedFactura = (String) comboBoxFacturas.getItemAt(facturaIndex);
                    int newFactura = idFromText(selectedFactura);
                    int newProducto = idFromText(selectedProducto);
                   arbolDetalles.insertar(newFactura, Integer.parseInt(detalle), newProducto, Integer.parseInt(cantidad), Integer.parseInt(price));
                }
                else return;
                limpiarUIDetalle();
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
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
    public void limpiarUIProd(){
        descProducto.setText("");
        productoId.setText("");
        comboBoxMarcas.setSelectedIndex(0);
    }
    public void limpiarUIFact(){
        facturaId.setText("");
        mesComboBox.setSelectedIndex(0);
        diaComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        horaComboBox.setSelectedIndex(0);
        minutoComboBox.setSelectedIndex(0);
    }
    public void limpiarUIDetalle(){
        detalleId.setText("");
        priceText.setText("");
        undText.setText("");
        comboBoxProductos.setSelectedIndex(0);
        comboBoxFacturas.setSelectedIndex(0);
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
    public int idFromText(String text){
        int id=0;
        // Define the regular expression pattern to match digits
        String pattern = "\\d+";

        // Create a Pattern object
        Pattern regex = Pattern.compile(pattern);

        // Create a Matcher object
        Matcher matcher = regex.matcher(text);

        // Find and print all matches
        while (matcher.find()) {
            String number = matcher.group();
            id=Integer.parseInt(number);
        }
        return id;
    }

}