package Arboles;

import Nodos.NodoFactura;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase que representa un Árbol Binario de Facturas.
 */
public class ABFactura {
    NodoFactura raiz;

    /**
     * Constructor de la clase ABFactura.
     * Inicializa la raíz del árbol como null.
     */
    public ABFactura() {
        raiz = null;
    }

    /**
     * Inserta una nueva factura en el árbol.
     */
    public void insertar(int idFactura, LocalDate fechaFactura, LocalTime horaFactura) {
        raiz = insertarRecursivo(raiz, idFactura, fechaFactura, horaFactura);
    }

    private NodoFactura insertarRecursivo(NodoFactura nodo, int idFactura, LocalDate fechaFactura, LocalTime horaFactura) {
        if (nodo == null) {
            nodo = new NodoFactura(idFactura, fechaFactura, horaFactura);
            return nodo;
        }
        if(idFactura == nodo.idFactura){
            JOptionPane.showMessageDialog(null, "La factura que esta intentando insertar ya existe, por favor seleccione un codigo diferente", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            return nodo;
        }
        if (idFactura < nodo.idFactura) {
            nodo.hijoIzquierdo = insertarRecursivo(nodo.hijoIzquierdo, idFactura, fechaFactura, horaFactura);
        } else if (idFactura > nodo.idFactura) {
            nodo.hijoDerecho = insertarRecursivo(nodo.hijoDerecho, idFactura, fechaFactura, horaFactura);
        }

        return nodo;
    }
    /**
     * Busca una factura en el árbol por su ID.
     */

    public String buscar(int idFactura) {

        return buscarRecursivo(raiz, idFactura);
    }

    private String buscarRecursivo(NodoFactura nodo, int idFactura) {
        if (nodo == null) {
            return "";
        }


        if (idFactura==nodo.idFactura) {
            return "Factura con id: " + nodo.idFactura;
        } else if (idFactura < nodo.idFactura) {
            return buscarRecursivo(nodo.hijoIzquierdo, idFactura);
        } else {
            return buscarRecursivo(nodo.hijoDerecho, idFactura);
        }
    }
    /**
     * Busca una factura en el árbol por su ID y devuelve información detallada.
     */

    public String buscarDetallado(int idFactura) {

        return buscarDetalladoRecursivo(raiz, idFactura);
    }
    /**
     * Busca una factura en el árbol por su ID y devuelve información detallada.
     */

    private String buscarDetalladoRecursivo(NodoFactura nodo, int idFactura) {
        if (nodo == null) {
            return "";
        }

        if (idFactura==nodo.idFactura) {
            return "Factura con id: " + nodo.idFactura + "-" + nodo.fechaFactura + "-" + nodo.horaFactura;
        } else if (idFactura < nodo.idFactura) {
            return buscarDetalladoRecursivo(nodo.hijoIzquierdo, idFactura);
        } else {
            return buscarDetalladoRecursivo(nodo.hijoDerecho, idFactura);
        }
    }
    /**
     * Busca una factura en el árbol por su ID y devuelve el nodo de la factura.
     */

    public NodoFactura buscaFactura(int idFactura) {

        return buscarFacturaRecursivo(raiz, idFactura);
    }

    private NodoFactura buscarFacturaRecursivo(NodoFactura nodo, int idFactura) {
        if (nodo == null) {
            return null;
        }

        if (idFactura==nodo.idFactura) {
            return nodo;
        } else if (idFactura < nodo.idFactura) {
            return buscarFacturaRecursivo(nodo.hijoIzquierdo, idFactura);
        } else {
            return buscarFacturaRecursivo(nodo.hijoDerecho, idFactura);
        }
    }
    /**
     * Edita los datos de una factura en el árbol.
     */

    public String editar(int idFactura, LocalDate fechaFactura, LocalTime horaFactura) {
        raiz = editarRecursivo(raiz, idFactura, fechaFactura, horaFactura);
        String buscarNodo = buscar(idFactura);
        if(buscarNodo.equals(""))
            return "";
        else
            return buscarNodo;
    }

    private NodoFactura editarRecursivo(NodoFactura nodo, int idFactura, LocalDate fechaFactura, LocalTime horaFactura) {
        if (nodo == null) {
            return null;
        }

        if (nodo.idFactura == idFactura) {
            nodo.fechaFactura = fechaFactura;
            nodo.horaFactura = horaFactura;
        } else if (idFactura < nodo.idFactura) {
            nodo.hijoIzquierdo = editarRecursivo(nodo.hijoIzquierdo, idFactura, fechaFactura, horaFactura);
        } else {
            nodo.hijoDerecho = editarRecursivo(nodo.hijoDerecho, idFactura, fechaFactura, horaFactura);
        }

        return nodo;
    }
    /**
     * Elimina una factura del árbol por su ID.
     */

    public String eliminar(int idFactura) {
        String buscarNodo = buscar(idFactura);
        raiz = eliminarRecursivo(raiz, idFactura);
        if(buscarNodo.equals(""))
            return "";
        else
            return buscarNodo;
    }

    private NodoFactura eliminarRecursivo(NodoFactura nodo, int idFactura) {
        if (nodo == null) {
            return null;
        }

        if (idFactura<nodo.idFactura) {
            nodo.hijoIzquierdo = eliminarRecursivo(nodo.hijoIzquierdo, idFactura);
        } else if (idFactura>nodo.idFactura) {
            nodo.hijoDerecho = eliminarRecursivo(nodo.hijoDerecho, idFactura);
        } else {
            // Caso 1: Nodo sin hijos
            if (nodo.hijoIzquierdo == null && nodo.hijoDerecho == null) {
                nodo = null;
            }
            // Caso 2: Nodo con un hijo
            else if (nodo.hijoIzquierdo == null) {
                nodo = nodo.hijoDerecho;
            } else if (nodo.hijoDerecho == null) {
                nodo = nodo.hijoIzquierdo;
            }
            // Caso 3: Nodo con dos hijos
            else {
                NodoFactura sucesor = encontrarSucesor(nodo.hijoDerecho);
                nodo.fechaFactura = sucesor.fechaFactura;
                nodo.horaFactura = sucesor.horaFactura;
                nodo.hijoDerecho = eliminarRecursivo(nodo.hijoDerecho, sucesor.idFactura);
            }
        }

        return nodo;
    }

    private NodoFactura encontrarSucesor(NodoFactura nodo) {
        while (nodo.hijoIzquierdo != null) {
            nodo = nodo.hijoIzquierdo;
        }
        return nodo;
    }
    /**
     * Imprime en orden las facturas cuya fecha corresponda al mes especificado.
     */

    public ArrayList<Integer> imprimirEnOrden(LocalDate fechaDeseada, ArrayList<Integer> fechasPorMes) {
        ArrayList<Integer> resultadoMes = imprimirEnOrdenRecursivo(raiz, fechaDeseada, fechasPorMes);
        return resultadoMes;
    }

    private ArrayList<Integer> imprimirEnOrdenRecursivo(NodoFactura nodo , LocalDate fechaDeseada, ArrayList<Integer> fechasPorMes) {
        if (nodo != null && fechaDeseada.getMonth()==nodo.fechaFactura.getMonth()) {
            imprimirEnOrdenRecursivo(nodo.hijoIzquierdo, fechaDeseada, fechasPorMes);
            imprimirEnOrdenRecursivo(nodo.hijoDerecho, fechaDeseada, fechasPorMes);
            fechasPorMes.add(nodo.idFactura);
            return fechasPorMes;
        }
        return null;
    }
    /**
     * Calcula el tamanio del árbol.
     */
    public int tamanio() {
        return tamanioRecursivo(raiz);
    }

    private int tamanioRecursivo(NodoFactura nodo) {
        if (nodo == null) {
            return 0;
        }

        int tamanioIzquierdo = tamanioRecursivo(nodo.hijoIzquierdo);
        int tamanioDerecho = tamanioRecursivo(nodo.hijoDerecho);

        return tamanioIzquierdo + tamanioDerecho + 1;
    }
    /**
     * Verifica si el árbol está vacío.
     */

    public boolean estaVacio() {
        return raiz == null;
    }
}
