import Arboles.ABDetalle;
import Arboles.ABFactura;
import Arboles.ABMarca;
import Arboles.ABProducto;
import Nodos.NodoDetalle;
import Nodos.NodoFactura;
import Nodos.NodoProducto;
import TreeMapValues.Detalle;
import TreeMapValues.Factura;
import TreeMapValues.Marca;
import TreeMapValues.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.*;

/**
 * La clase ABInventario es una interfaz gráfica de usuario (GUI) para un sistema de inventario.
 * Permite gestionar marcas, productos, facturas y detalles de facturas.
 */
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
    private JTextField marcaSearch;
    private JTextField productoId;
    private JTextField descProducto;
    private JButton agregarProducto;
    private JButton editarProductoBtn;
    private JButton eliminarProductoBtn;
    private JTextField productoSearch;
    private JTextField facturaId;
    private JComboBox mesComboBox;
    private JComboBox diaComboBox;
    private JComboBox yearComboBox;
    private JComboBox horaComboBox;
    private JComboBox minutoComboBox;
    private JButton agregarFactura;
    private JButton editarFacturaBtn;

    private JButton deleteButton;
    private JComboBox comboBoxMarcas;
    private JTextArea marcaTextArea;
    private JButton buscarMarca;
    private ABMarca arbolMarcas;
    private ABProducto arbolProductos;
    private ABFactura arbolFacturas;
    private ABDetalle arbolDetalles;
    private NodoDetalle nodoDetalleReporte;
    private NodoFactura nodoFacturaReporte;
    private NodoProducto nodoProductoReporte;
    int marcaIndex = 0;
    int productoIndex = 1;
    int facturaIndex = 2;
    int detalleIndex = 3;
    private JButton eliminarFacturaBtn;
    private JTextField facturaSearch;
    private JTextField detalleId;
    private JTextField undText;
    private JTextField priceText;
    private JButton agregarDetalle;
    private JButton editarDetalleBtn;
    private JButton eliminarDetalleBtn;
    private JTextField detalleSearch;
    private JComboBox comboReporteMes;
    private JButton mostrarDatosDeLasButton;
    private JTable tablaPorMes;
    private JTextArea facturaTextArea;
    private JComboBox comboBoxProductos;
    private JComboBox comboBoxFacturas;
    private JButton buscarProductoBtn;
    private JButton buscarFacturaBtn;
    private JButton buscarDetalleBtn;
    private JTextArea productoTextArea;
    private JTextArea detalleTextArea;
    private JTable tablePorMarca;
    private JComboBox comboMarcasReporte;
    private JButton mostrarProductosDadaUnaButton;
    private JComboBox comboBoxReporteFactura;
    private JTable tablePorFactura;
    private JButton mostrarInformacionAcercaDeButton;
    private JButton mostrarFacturasDelMesButton;
    private JTable tablePorFacturasMayo;
    private JScrollPane tablaPorMarca;
    // TreeMap<Key,Value>
    private TreeMap<Integer, Marca> treeMapMarcas;
    private TreeMap<Integer, Producto> treeMapProducto;
    private TreeMap<Integer, Factura> treeMapFactura;
    private TreeMap<Integer, Detalle> treeMapDetalle;

    /**
     * Constructor de la clase ABInventario.
     * Inicializa los componentes de la interfaz gráfica y crea instancias de los árboles de datos.
     */
    public ABInventario() {
        super("Inventario");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        arbolMarcas = new ABMarca();
        treeMapMarcas = new TreeMap<>();

        arbolProductos = new ABProducto();
        treeMapProducto = new TreeMap<>();

        arbolFacturas = new ABFactura();
        treeMapFactura = new TreeMap<>();

        arbolDetalles = new ABDetalle();
        treeMapDetalle = new TreeMap<>();

        // Asignar oyentes de eventos a los botones y otros componentes
        agregarMarcaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarRegistro();
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
        agregarDetalle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarRegistro();
            }
        });
        editarMarcaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarRegistro();
            }
        });
        editarFacturaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarRegistro();
            }
        });
        editarDetalleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarRegistro();
            }
        });
        editarProductoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarRegistro();
            }
        });
        eliminarMarcaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarRegistro();
            }
        });

        eliminarProductoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarRegistro();
            }
        });
        eliminarFacturaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarRegistro();
            }
        });
        eliminarDetalleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarRegistro();
            }
        });
        buscarMarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRegistro();
            }
        });
        buscarProductoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRegistro();
            }
        });
        buscarFacturaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRegistro();
            }
        });
        buscarDetalleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRegistro();
            }
        });
        mostrarDatosDeLasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaFromMes();
            }
        });
        mostrarProductosDadaUnaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaFromMarca();
            }
        });
        mostrarInformacionAcercaDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaFromFactura();
            }
        });
        mostrarFacturasDelMesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaFacturasMayo();
            }
        });
    }
    /**
     * Método privado que se ejecuta cuando se hace clic en el botón "Agregar" de cualquier panel.
     * Agrega un nuevo registro al árbol de datos correspondiente según el panel actualmente visible.
     */

    public void agregarRegistro(){
        // Lógica para agregar un nuevo registro al árbol de datos
        marcaTextArea.setText("");
        productoTextArea.setText("");
        facturaTextArea.setText("");
        detalleTextArea.setText("");
        int registro = whichRegistro(tabbedPane1.getSelectedIndex());

        if(registro==0){
            if(!marcaNombre.getText().equals("") && !marcaId.getText().equals("")){
                String nombreAgregar = marcaNombre.getText();
                String marcaAgregar = marcaId.getText();
                if(codeIsNumber(marcaAgregar)){
                    treeMapMarcas.put(Integer.parseInt(marcaAgregar) , new Marca(nombreAgregar, Integer.parseInt(marcaAgregar)));
                    //Hacemos uso de el arbol binario para guardar los reportes en las tablas
                    arbolMarcas.insertar(nombreAgregar,Integer.parseInt(marcaAgregar));
                }
                else{
                    return;
                }
                JOptionPane.showMessageDialog(null, "Registro creado con exito", "Aviso", 1);
                //Agregamos la marca al comboBox de marcas
                comboBoxMarcas.addItem(marcaAgregar + "-" + nombreAgregar);
                comboMarcasReporte.addItem(marcaAgregar + "-" + nombreAgregar);
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
                    if(treeMapProducto.containsKey(Integer.parseInt(prodIdAgregar))) {
                        JOptionPane.showMessageDialog(null, "El registro que está intentando agregar ya existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                        return;
                    }
                    treeMapProducto.put(Integer.parseInt(prodIdAgregar), new Producto(descProd,Integer.parseInt(prodIdAgregar),idNewMarca));
                    arbolProductos.insertar(descProd,Integer.parseInt(prodIdAgregar),idNewMarca);
                }
                else return;
                JOptionPane.showMessageDialog(null, "Registro creado con exito", "Aviso", 1);
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
                    if(treeMapFactura.containsKey(Integer.parseInt(facturaAgregar))) {
                        JOptionPane.showMessageDialog(null, "El registro que está intentando agregar ya existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                        return;
                    }
                    treeMapFactura.put(Integer.parseInt(facturaAgregar), new Factura(Integer.parseInt(facturaAgregar),fechaAgregar,horaAgregar));
                    arbolFacturas.insertar(Integer.parseInt(facturaAgregar),fechaAgregar,horaAgregar);
                }
                else return;
                JOptionPane.showMessageDialog(null, "Registro creado con exito", "Aviso", 1);
                comboBoxReporteFactura.addItem("Factura con id: " + Integer.parseInt(facturaAgregar));
                comboBoxFacturas.addItem("Factura con id: " + Integer.parseInt(facturaAgregar));
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
                    if(treeMapDetalle.containsKey(newFactura)) {
                        JOptionPane.showMessageDialog(null, "El registro que está intentando agregar ya existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                        return;
                    }
                    treeMapDetalle.put(newFactura, new Detalle(newFactura,Integer.parseInt(detalle),newProducto,Integer.parseInt(cantidad), Integer.parseInt(price)));
                    arbolDetalles.insertar(newFactura,Integer.parseInt(detalle),newProducto,Integer.parseInt(cantidad), Integer.parseInt(price));
                }
                else return;
                JOptionPane.showMessageDialog(null, "Registro creado con exito", "Aviso", 1);
                limpiarUIDetalle();
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }

    }
    /**
     * Método privado que se ejecuta cuando se hace clic en el botón "Editar" de cualquier panel.
     * Edita el registro seleccionado en el árbol de datos correspondiente según el panel actualmente visible.
     */

    public void editarRegistro(){
        // Lógica para editar un registro en el árbol de datos
        marcaTextArea.setText("");
        productoTextArea.setText("");
        facturaTextArea.setText("");
        detalleTextArea.setText("");
        int registro = whichRegistro(tabbedPane1.getSelectedIndex());

        if(registro==0){
            if(!marcaNombre.getText().equals("") && !marcaId.getText().equals("")){
                //Buscar la marca con el id que voy a editar
                String newNombre = marcaNombre.getText();
                String marcaEditar = marcaId.getText();
                Marca oldMarca = treeMapMarcas.get(Integer.parseInt(marcaEditar));
                String eliminarComboMarca = oldMarca.idMarca + "-" + oldMarca.nombreMarca;
                eliminarFromCombo(comboBoxMarcas,eliminarComboMarca);
                eliminarFromCombo(comboMarcasReporte,eliminarComboMarca);
                if(codeIsNumber(marcaEditar)){
                    Boolean searchResult;
                    searchResult = treeMapMarcas.containsKey(Integer.parseInt(marcaEditar));
                    if(!searchResult){
                        JOptionPane.showMessageDialog(null, "El registro que esta intentando editar no existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                    }
                    else{
                        treeMapMarcas.put(oldMarca.idMarca, new Marca(newNombre,oldMarca.idMarca));
                        arbolMarcas.editar(newNombre,oldMarca.idMarca);
                        JOptionPane.showMessageDialog(null, "Registro editado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        comboBoxMarcas.addItem(marcaEditar + "-" + newNombre);
                        comboMarcasReporte.addItem(marcaEditar + "-" + newNombre);
                    }
                }
                else{
                    return;
                }
                //Limpiamos la UI
                limpiarUIMarca();
            }
            else{
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else if(registro==1){
            if(descProducto.getText()!="" && productoId.getText()!="" && comboBoxMarcas.getSelectedIndex()!=0){
                String newDescProd = descProducto.getText();
                String prodIdEditar = productoId.getText();
                Producto oldProducto = treeMapProducto.get(Integer.parseInt(prodIdEditar));
                String eliminarComboProducto = oldProducto.idProducto + "-" + oldProducto.descProducto;
                eliminarFromCombo(comboBoxProductos,eliminarComboProducto);
                if(codeIsNumber(prodIdEditar)){
                    int selectedIndex = comboBoxMarcas.getSelectedIndex();
                    // Retrieve the selected item
                    String selectedText = (String) comboBoxMarcas.getItemAt(selectedIndex);
                    int idNewMarca = idFromText(selectedText);
                    Boolean searchResult;
                    searchResult = treeMapProducto.containsKey(Integer.parseInt(prodIdEditar));
                    if(!searchResult){
                        JOptionPane.showMessageDialog(null, "El registro que esta intentando editar no existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                    }
                    else{
                        treeMapProducto.put(oldProducto.idProducto, new Producto(newDescProd,oldProducto.idProducto,idNewMarca));
                        arbolProductos.editar(newDescProd,oldProducto.idProducto,idNewMarca);
                        JOptionPane.showMessageDialog(null, "Registro editado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        comboBoxProductos.addItem(Integer.parseInt(prodIdEditar) + "-" + newDescProd);
                    }
                }
                else return;
                limpiarUIProd();
            }
            else{
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else if(registro==2){
            if(!facturaId.getText().equals("")){
                String facturaEditar = facturaId.getText();
                Factura oldFactura = treeMapFactura.get(Integer.parseInt(facturaEditar));
                String eliminarComboFactura = "Factura con id: " + oldFactura.idFactura;
                eliminarFromCombo(comboBoxFacturas,eliminarComboFactura);
                eliminarFromCombo(comboBoxReporteFactura,eliminarComboFactura);
                if(codeIsNumber(facturaEditar)){
                    //Capturamos la fecha que indico el usuario
                    int selectedMesIndex = mesComboBox.getSelectedIndex();
                    int selectedDiaIndex = diaComboBox.getSelectedIndex();
                    int selectedYearIndex = yearComboBox.getSelectedIndex();
                    // Devolvemos el contenido de los items seleccionados
                    String newSelectedMes = (String) mesComboBox.getItemAt(selectedMesIndex);
                    String newSelectedDia = (String) diaComboBox.getItemAt(selectedDiaIndex);
                    String newSelectedYear = (String) yearComboBox.getItemAt(selectedYearIndex);
                    //Capturamos la hora seleccionada por el usuario
                    int selectedHoraIndex = horaComboBox.getSelectedIndex();
                    int selectedMintuoIndex = minutoComboBox.getSelectedIndex();
                    //Devolvemos el contenido de los items seleccionados
                    String selectedHora = (String) horaComboBox.getItemAt(selectedHoraIndex);
                    String selectedMinuto = (String) minutoComboBox.getItemAt(selectedMintuoIndex);
                    LocalDate newFechaAgregar = LocalDate.of(Integer.parseInt(newSelectedYear), Integer.parseInt(newSelectedMes), Integer.parseInt(newSelectedDia));
                    LocalTime newHoraAgregar = LocalTime.of(Integer.parseInt(selectedHora), Integer.parseInt(selectedMinuto));
                    Boolean searchResult;
                    searchResult = treeMapFactura.containsKey(Integer.parseInt(facturaEditar));
                    if(!searchResult){
                        JOptionPane.showMessageDialog(null, "El registro que esta intentando editar no existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                    }
                    else{
                        treeMapFactura.put(oldFactura.idFactura, new Factura(oldFactura.idFactura, newFechaAgregar, newHoraAgregar));
                        arbolFacturas.editar(oldFactura.idFactura, newFechaAgregar, newHoraAgregar);
                        JOptionPane.showMessageDialog(null, "Registro editado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        comboBoxReporteFactura.addItem("Factura con id: " + Integer.parseInt(facturaEditar));
                        comboBoxFacturas.addItem("Factura con id: " + Integer.parseInt(facturaEditar));
                    }
                }
                else return;
                limpiarUIFact();
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else if(registro==3){
            if(comboBoxFacturas.getSelectedIndex()!=0 && comboBoxProductos.getSelectedIndex()!=0 && !undText.equals("") && !priceText.equals("") && !detalleId.equals("")){
                String newCantidad = undText.getText();
                String newPrice = priceText.getText();
                String detalleEditar = detalleId.getText();
                if(codeIsNumber(newCantidad) && codeIsNumber(newPrice) && codeIsNumber(detalleEditar)){
                    int productoIndex = comboBoxProductos.getSelectedIndex();
                    int facturaIndex = comboBoxFacturas.getSelectedIndex();
                    String newSelectedProducto = (String) comboBoxProductos.getItemAt(productoIndex);
                    String newSelectedFactura = (String) comboBoxFacturas.getItemAt(facturaIndex);
                    int newFactura = idFromText(newSelectedFactura);
                    int newProducto = idFromText(newSelectedProducto);
                    Boolean searchResult;
                    searchResult = treeMapDetalle.containsKey(Integer.parseInt(detalleEditar));
                    if(!searchResult){
                        JOptionPane.showMessageDialog(null, "El registro que esta intentando editar no existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                    }
                    else{
                        treeMapDetalle.put(Integer.parseInt(detalleEditar), new Detalle(newFactura,Integer.parseInt(detalleEditar),newProducto,Integer.parseInt(newCantidad),Integer.parseInt(newPrice)));
                        arbolDetalles.editar(newFactura,Integer.parseInt(detalleEditar),newProducto,Integer.parseInt(newCantidad),Integer.parseInt(newPrice));
                        JOptionPane.showMessageDialog(null, "Registro editado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else return;
                limpiarUIDetalle();
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
    }
    /**
     * Método privado que se ejecuta cuando se hace clic en el botón "Eliminar" de cualquier panel.
     * Elimina el registro seleccionado del árbol de datos correspondiente según el panel actualmente visible.
     */
    public void eliminarRegistro(){
        // Lógica para eliminar un registro del árbol de datos
        marcaTextArea.setText("");
        productoTextArea.setText("");
        facturaTextArea.setText("");
        detalleTextArea.setText("");
        int registro = whichRegistro(tabbedPane1.getSelectedIndex());

        if(registro==0){
            if(!marcaId.getText().equals("")){
                //Buscar la marca con el id que voy a borrar
                String marcaEliminar = marcaId.getText();
                Marca deleteMarca = treeMapMarcas.get(Integer.parseInt(marcaEliminar));
                String eliminarComboMarca = deleteMarca.idMarca + "-" + deleteMarca.nombreMarca;
                eliminarFromCombo(comboBoxMarcas,eliminarComboMarca);
                eliminarFromCombo(comboMarcasReporte,eliminarComboMarca);
                if(codeIsNumber(marcaEliminar)){
                    Marca searchResult;
                    searchResult = treeMapMarcas.remove(Integer.parseInt(marcaEliminar));
                    if(searchResult==null){
                        JOptionPane.showMessageDialog(null, "El registro que esta intentando eliminar no existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                    }
                    else{
                        arbolMarcas.eliminar(Integer.parseInt(marcaEliminar));
                        JOptionPane.showMessageDialog(null, "Registro eliminado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    return;
                }
                //Limpiamos la UI
                limpiarUIMarca();
            }
            else{
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else if(registro==1){
            if(!productoId.getText().equals("")){
                String prodIdEliminar = productoId.getText();
                Producto deleteProducto = treeMapProducto.get(Integer.parseInt(prodIdEliminar));
                String eliminarComboProducto = deleteProducto.idProducto + "-" + deleteProducto.descProducto;
                eliminarFromCombo(comboBoxProductos,eliminarComboProducto);
                if(codeIsNumber(prodIdEliminar)){
                    Producto searchResult;
                    searchResult = treeMapProducto.remove(deleteProducto.idProducto);
                    if(searchResult==null){
                        JOptionPane.showMessageDialog(null, "El registro que esta intentando eliminar no existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                    }
                    else{
                        arbolMarcas.eliminar(deleteProducto.idProducto);
                        JOptionPane.showMessageDialog(null, "Registro eliminado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else return;
                limpiarUIProd();
            }
            else{
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else if(registro==2){
            if(!facturaId.getText().equals("")){
                String facturaEliminar = facturaId.getText();
                Factura deleteFactura = treeMapFactura.get(Integer.parseInt(facturaEliminar));
                String eliminarComboFactura = "Factura con id: " + deleteFactura.idFactura;
                eliminarFromCombo(comboBoxFacturas,eliminarComboFactura);
                eliminarFromCombo(comboBoxReporteFactura,eliminarComboFactura);
                if(codeIsNumber(facturaEliminar)){
                    Factura searchResult;
                    searchResult = treeMapFactura.remove(deleteFactura.idFactura);
                    if(searchResult==null){
                        JOptionPane.showMessageDialog(null, "El registro que esta intentando editar no existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                    }
                    else{
                        arbolFacturas.eliminar(deleteFactura.idFactura);
                        JOptionPane.showMessageDialog(null, "Registro editado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else return;
                limpiarUIFact();
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else if(registro==3){
            if(!detalleId.equals("")){
                String detalleEliminar = detalleId.getText();
                if(codeIsNumber(detalleEliminar)){
                    Detalle searchResult;
                    searchResult = treeMapDetalle.remove(Integer.parseInt(detalleEliminar));
                    if(searchResult.equals("")){
                        JOptionPane.showMessageDialog(null, "El registro que esta intentando eliminar no existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                    }
                    else{
                        arbolDetalles.eliminar(Integer.parseInt(detalleEliminar));
                        JOptionPane.showMessageDialog(null, "Registro eliminado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else return;
                limpiarUIDetalle();
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
    }
    /**
     * Método privado que se ejecuta cuando se hace clic en el botón "Buscar" de cualquier panel.
     * Realiza una búsqueda en el árbol de datos correspondiente según el panel actualmente visible.
     */
    public void buscarRegistro(){
        // Lógica para realizar una búsqueda en el árbol de datos
        marcaTextArea.setText("");
        productoTextArea.setText("");
        facturaTextArea.setText("");
        detalleTextArea.setText("");
        int registro = whichRegistro(tabbedPane1.getSelectedIndex());

        if(registro==0){
            if(!marcaSearch.getText().equals("")){
                //Buscar la marca con el id que voy a mostrar y buscar
                String marcaBuscar = marcaSearch.getText();
                if(codeIsNumber(marcaBuscar)){
                    Boolean searchResult;
                    searchResult = treeMapMarcas.containsKey(Integer.parseInt(marcaBuscar));
                    if(!searchResult){
                        JOptionPane.showMessageDialog(null, "El registro que esta intentando buscar no existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                    }
                    else{
                        Marca marcaEncontrada = treeMapMarcas.get(Integer.parseInt(marcaBuscar));
                        String registroEncontrado = "Nombre de la marca: " + marcaEncontrada.nombreMarca + "\nId de la marca: " + marcaEncontrada.idMarca;
                        marcaTextArea.append(registroEncontrado);
                    }
                }
                else{
                    return;
                }
                //Limpiamos la UI
                limpiarUIMarca();
            }
            else{
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else if(registro==1){
            if(!productoSearch.getText().equals("")){
                String prodIdBuscar = productoSearch.getText();
                if(codeIsNumber(prodIdBuscar)){
                    Boolean searchResult;
                    searchResult = treeMapProducto.containsKey(Integer.parseInt(prodIdBuscar));
                    if(!searchResult){
                        JOptionPane.showMessageDialog(null, "El registro que esta intentando buscar no existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                    }
                    else{
                        Producto productoEncontrado = treeMapProducto.get(Integer.parseInt(prodIdBuscar));
                        String registroEncontrado = "Descrpcion del producto: " + productoEncontrado.descProducto + "\nId del producto: " + productoEncontrado.idProducto + "\nId de la marca del producto: " + productoEncontrado.idMarca;
                        productoTextArea.append(registroEncontrado);
                    }
                }
                else return;
                limpiarUIProd();
            }
            else{
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else if(registro==2){
            if(!facturaSearch.getText().equals("")){
                String facturaBuscar = facturaSearch.getText();
                if(codeIsNumber(facturaBuscar)){
                    Boolean searchResult;
                    searchResult = treeMapFactura.containsKey(Integer.parseInt(facturaBuscar));
                    if(!searchResult){
                        JOptionPane.showMessageDialog(null, "El registro que esta intentando buscar no existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                    }
                    else{
                        Factura facturaEncontrada = treeMapFactura.get(Integer.parseInt(facturaBuscar));
                        String registroEncontrado = "Id de la factura: " + facturaEncontrada.idFactura + "\nFecha de la factura: " + facturaEncontrada.fechaFactura + "\nHora de la factura: " + facturaEncontrada.horaFactura;
                        facturaTextArea.append(registroEncontrado);
                    }
                }
                else return;
                limpiarUIFact();
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        else if(registro==3){
            if(!detalleSearch.equals("")){
                String detalleBuscar = detalleSearch.getText();
                if(codeIsNumber(detalleBuscar)){
                    Boolean searchResult;
                    searchResult = treeMapDetalle.containsKey(Integer.parseInt(detalleBuscar));
                    if(!searchResult){
                        JOptionPane.showMessageDialog(null, "El registro que esta intentando buscar no existe", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
                    }
                    else{
                        Detalle detalleEncontrado = treeMapDetalle.get(Integer.parseInt(detalleBuscar));
                        String registroEncontrado = "Id del detalle de factura: " + detalleEncontrado.idDetalle + "\nRelacionado con la factura con id: " + detalleEncontrado.idFactura + "\nProducto en detalle: " + detalleEncontrado.idProducto + "\nUnidades del producto: " + detalleEncontrado.cantidadProductos + "\nValor por unidad: " + detalleEncontrado.valorProducto;
                        detalleTextArea.append(registroEncontrado);
                    }
                }
                else return;
                limpiarUIDetalle();
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos solicitados", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            }
        }
    }
    /**
     * Limpia los campos de la interfaz de usuario relacionados con la marca.
     */
    public void limpiarUIMarca(){
        // Código para limpiar la interfaz de usuario de la marca
        marcaNombre.setText("");
        marcaId.setText("");
    }
    /**
     * Limpia los campos de la interfaz de usuario relacionados con el producto.
     */
    public void limpiarUIProd(){
        // Código para limpiar la interfaz de usuario del producto
        descProducto.setText("");
        productoId.setText("");
        comboBoxMarcas.setSelectedIndex(0);
    }
    /**
     * Limpia los campos de la interfaz de usuario relacionados con la factura.
     */
    public void limpiarUIFact(){
        // Código para limpiar la interfaz de usuario de la factura
        facturaId.setText("");
        mesComboBox.setSelectedIndex(0);
        diaComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        horaComboBox.setSelectedIndex(0);
        minutoComboBox.setSelectedIndex(0);
    }
    /**
     * Limpia los campos de la interfaz de usuario relacionados con el detalle.
     */
    public void limpiarUIDetalle(){
        // Código para limpiar la interfaz de usuario del detalle
        detalleId.setText("");
        priceText.setText("");
        undText.setText("");
        comboBoxProductos.setSelectedIndex(0);
        comboBoxFacturas.setSelectedIndex(0);
    }
    /**
     * Devuelve un índice correspondiente a un registro específico basado en el índice de la pestania actual.
     */
    public int whichRegistro(int tabActual){
        // Código para determinar el índice del registro según la pestania actual
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
    /**
     * Verifica si el código especificado es un número.
     */
    public Boolean codeIsNumber(String code){
        // Código para verificar si el código es un número
        try {
            Integer.parseInt(code);
        }
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "El codigo debe ser un numero", "Advertencia", 1);
            return false;
        }
        return true;
    }
    /**
     * Extrae el identificador de un texto dado.
     */
    public int idFromText(String text){
        // Código para extraer el identificador del texto
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
    /**
     * Elimina un elemento específico de un JComboBox.
     */
    public void eliminarFromCombo(JComboBox comboEliminar, String itemEliminar){
        // Código para eliminar un elemento del JComboBox
        int itemCount = comboEliminar.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (comboEliminar.getItemAt(i).equals(itemEliminar)) {
                comboEliminar.removeItemAt(i);
                break;
            }
        }
    }
    /**
     * Genera una tabla de informe basada en el mes seleccionado.
     */
    public void tablaFromMes(){
        // Código para generar una tabla de informe basada en el mes seleccionado
        DefaultTableModel modelo = new DefaultTableModel();
        try{
            int selectedMesIndex = comboReporteMes.getSelectedIndex();
            // Retrieve the selected item
            String selectedMesText = (String) comboReporteMes.getItemAt(selectedMesIndex);

            modelo.setRowCount(0);
            modelo.addColumn("Mes");
            modelo.addColumn("Total ventas");

            int mesEnColumna = idFromText(selectedMesText);
            int totalMes=0;
            LocalDate fechaFiltro = LocalDate.of(2023,mesEnColumna,7);
            ArrayList<Integer> baseFacturas = new ArrayList<>();
            ArrayList<Integer> facturasPorMes = arbolFacturas.imprimirEnOrden(fechaFiltro,baseFacturas);
            for(int i=0; i<facturasPorMes.size(); i++){
                int idToDetalle = facturasPorMes.get(i);
                totalMes=totalMes+arbolDetalles.buscarPrecio(idToDetalle);
            }
            modelo.addRow(new Object[]{mesEnColumna, totalMes});
            tablaPorMes.setModel(modelo);
        }catch (NullPointerException npe){
            JOptionPane.showMessageDialog(null, "Usuario: El mes que esta tratando visualizar no tiene ventas aún", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            modelo.setRowCount(0);
        }

    }
    /**
     * Genera una tabla de informe basada en la marca seleccionada.
     */
    public void tablaFromMarca(){
        // Código para generar una tabla de informe basada en la marca seleccionada
        DefaultTableModel modelo = new DefaultTableModel();
        try{
            int selectedMarcaIndex = comboMarcasReporte.getSelectedIndex();
            // Retrieve the selected item
            String selectedMarcaText = (String) comboMarcasReporte.getItemAt(selectedMarcaIndex);
            modelo.setRowCount(0);
            modelo.addColumn("Producto");
            int marcaAsInt = idFromText(selectedMarcaText);
            ArrayList<String> baseProductos = new ArrayList<>();
            ArrayList<String> productosConMarca = arbolProductos.imprimirEnOrdenByMarca(marcaAsInt,baseProductos);
            for(int i=0; i<productosConMarca.size(); i++){
                String textToTabla = productosConMarca.get(i);
                modelo.addRow(new Object[]{textToTabla});
            }
            tablePorMarca.setModel(modelo);
        }catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Usuario: La marca que esta tratando visualizar no tiene productos aún", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            modelo.setRowCount(0);
        }
    }
    /**
     * Genera una tabla de informe basada en la factura seleccionada.
     */
    public void tablaFromFactura(){
        // Código para generar una tabla de informe basada en la factura seleccionada
        DefaultTableModel modelo = new DefaultTableModel();
        try{
            int selectedFacturaIndex = comboBoxReporteFactura.getSelectedIndex();
            // Retrieve the selected item
            String selectedFacturaText = (String) comboBoxReporteFactura.getItemAt(selectedFacturaIndex);
            modelo.setRowCount(0);
            modelo.addColumn("Id factura");
            modelo.addColumn("Fecha factura");
            modelo.addColumn("Hora factura");
            modelo.addColumn("Descripcion producto");
            modelo.addColumn("Cantidad de productos");
            modelo.addColumn("Valor producto");
            modelo.addColumn("Total factura");
            int facturaAsInt = idFromText(selectedFacturaText);
            nodoDetalleReporte = arbolDetalles.buscarDetallePorFactura(facturaAsInt);
            nodoFacturaReporte = arbolFacturas.buscaFactura(facturaAsInt);
            nodoProductoReporte = arbolProductos.buscarProducto(nodoDetalleReporte.idProducto);
            int valorFactura = arbolDetalles.buscarPrecio(nodoFacturaReporte.idFactura);
            modelo.addRow(new Object[]{facturaAsInt,nodoFacturaReporte.fechaFactura,nodoFacturaReporte.horaFactura,nodoProductoReporte.descProducto,nodoDetalleReporte.cantidadProductos,nodoDetalleReporte.valorProducto,valorFactura});
            tablePorFactura.setModel(modelo);
        }catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Usuario: La factura que esta tratando visualizar está incompleta", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            modelo.setRowCount(0);
        }
    }
    /**
     * Genera una tabla de informe de las facturas del mes de mayo.
     */
    public void tablaFacturasMayo(){
        DefaultTableModel modelo = new DefaultTableModel();
        try{
            modelo.setRowCount(0);
            modelo.addColumn("Id factura");
            modelo.addColumn("Fecha factura");
            modelo.addColumn("Hora factura");
            modelo.addColumn("Total factura");

            int mesEnColumna = 5;
            int totalFactura=0;
            LocalDate fechaFiltro = LocalDate.of(2023,mesEnColumna,7);
            ArrayList<Integer> baseFacturas = new ArrayList<>();
            ArrayList<Integer> facturasPorMes = arbolFacturas.imprimirEnOrden(fechaFiltro,baseFacturas);
            for(int i=0; i<facturasPorMes.size(); i++) {
                int idToDetalle = facturasPorMes.get(i);
                NodoFactura facturaMes = arbolFacturas.buscaFactura(idToDetalle);
                totalFactura=arbolDetalles.buscarPrecio(facturaMes.idFactura);
                modelo.addRow(new Object[]{facturaMes.idFactura,facturaMes.fechaFactura, facturaMes.horaFactura, totalFactura});
            }
            tablePorFacturasMayo.setModel(modelo);
        }catch (NullPointerException npe){
            JOptionPane.showMessageDialog(null, "Usuario: El mes de mayo aún no tiene facturas completas para mostrar", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            modelo.setRowCount(0);
        }
    }
}