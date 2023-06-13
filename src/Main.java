
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * Clase principal del programa.
 */
public class Main {
    /**
     * Método principal que inicia la aplicación Swing.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            /**
             * Método run que se ejecuta en el hilo de despacho de eventos de Swing.
             */
            @Override
            public void run() {
                JFrame frame = new ABInventario();
                frame.setSize(900, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        /**
                         * Método que se ejecuta cuando se cierra la ventana.
                         */
                        super.windowClosing(e);
                        int opc = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Mensaje de confirmación", JOptionPane.OK_CANCEL_OPTION);
                        if (opc == 0) {
                            System.exit(0);
                        }
                    }
                });
            }
        });
    }
}