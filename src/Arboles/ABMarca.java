package Arboles;

import Nodos.NodoMarca;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un árbol binario para gestionar marcas.
 */
public class ABMarca {
    /**
     * Raíz del árbol.
     */
    NodoMarca raiz;
    /**
     * Área de texto para imprimir resultados.
     */
    JTextArea ta;
    /**
     * Constructor de la clase ABMarca.
     */

    public ABMarca() {
        raiz = null;
    }

    /**
     * Inserta una nueva marca en el árbol.
     */
    public void insertar(String nombreMarca, int idMarca) {
        raiz = insertarRecursivo(raiz, nombreMarca, idMarca);
    }

    private NodoMarca insertarRecursivo(NodoMarca nodo, String nombreMarca, int idMarca) {
        if (nodo == null) {
            nodo = new NodoMarca(nombreMarca, idMarca);
            return nodo;
        }
        if(idMarca == nodo.idMarca){
            JOptionPane.showMessageDialog(null, "La marca que esta intentando insertar ya existe, por favor seleccione un codigo diferente", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            return nodo;
        }
        if (idMarca < nodo.idMarca) {
            nodo.hijoIzquierdo = insertarRecursivo(nodo.hijoIzquierdo, nombreMarca, idMarca);
        } else if (idMarca > nodo.idMarca) {
            nodo.hijoDerecho = insertarRecursivo(nodo.hijoDerecho, nombreMarca, idMarca);
        }

        return nodo;
    }

    /**
     * Busca una marca en el árbol por su ID.
     */
    public String buscar(int idMarca) {

        return buscarRecursivo(raiz, idMarca);
    }

    private String buscarRecursivo(NodoMarca nodo, int idMarca) {
        if (nodo == null) {
            return "";
        }


        if (idMarca==nodo.idMarca) {
            return nodo.idMarca+"-"+nodo.nombreMarca;
        } else if (idMarca < nodo.idMarca) {
            return buscarRecursivo(nodo.hijoIzquierdo, idMarca);
        } else {
            return buscarRecursivo(nodo.hijoDerecho, idMarca);
        }
    }

    /**
     * Busca una marca en el árbol por su ID y devuelve una descripción detallada.
     */
    public String buscarDetallado(int idMarca) {

        return buscarDetalladoRecursivo(raiz, idMarca);
    }

    private String buscarDetalladoRecursivo(NodoMarca nodo, int idMarca) {
        if (nodo == null) {
            return "";
        }


        if (idMarca==nodo.idMarca) {
            return nodo.idMarca+"-"+nodo.nombreMarca;
        } else if (idMarca < nodo.idMarca) {
            return buscarDetalladoRecursivo(nodo.hijoIzquierdo, idMarca);
        } else {
            return buscarDetalladoRecursivo(nodo.hijoDerecho, idMarca);
        }
    }
    /**
     * Edita el nombre de una marca en el árbol.
     */

    public String editar(String nombreMarca, int idMarca) {
        raiz = editarRecursivo(raiz, nombreMarca, idMarca);
        String buscarNodo = buscar(idMarca);
        if(buscarNodo.equals(""))
            return "";
        else
            return buscarNodo;
    }

    private NodoMarca editarRecursivo(NodoMarca nodo, String nombreMarca, int idMarca) {
        if (nodo == null) {
            return null;
        }

        if (nodo.idMarca == idMarca) {
            nodo.nombreMarca = nombreMarca;
        } else if (idMarca < nodo.idMarca) {
            nodo.hijoIzquierdo = editarRecursivo(nodo.hijoIzquierdo, nombreMarca, idMarca);
        } else {
            nodo.hijoDerecho = editarRecursivo(nodo.hijoDerecho, nombreMarca, idMarca);
        }

        return nodo;
    }
    /**
     * Elimina una marca del árbol por su ID.
     */

    public String eliminar(int idMarca) {
        String buscarNodo = buscar(idMarca);
        raiz = eliminarRecursivo(raiz, idMarca);
        if(buscarNodo.equals(""))
            return "";
        else
            return buscarNodo;
    }

    private NodoMarca eliminarRecursivo(NodoMarca nodo, int idMarca) {
        if (nodo == null) {
            return null;
        }

        if (idMarca<nodo.idMarca) {
            nodo.hijoIzquierdo = eliminarRecursivo(nodo.hijoIzquierdo, idMarca);
        } else if (idMarca>nodo.idMarca) {
            nodo.hijoDerecho = eliminarRecursivo(nodo.hijoDerecho, idMarca);
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
                NodoMarca sucesor = encontrarSucesor(nodo.hijoDerecho);
                nodo.nombreMarca = sucesor.nombreMarca;
                nodo.hijoDerecho = eliminarRecursivo(nodo.hijoDerecho, sucesor.idMarca);
            }
        }

        return nodo;
    }

    private NodoMarca encontrarSucesor(NodoMarca nodo) {
        while (nodo.hijoIzquierdo != null) {
            nodo = nodo.hijoIzquierdo;
        }
        return nodo;
    }
    /**
     * Imprime las marcas del árbol en orden.
     */

    public void imprimirEnOrden(JTextArea ta) {
        this.ta = ta;
        imprimirEnOrdenRecursivo(raiz);
    }

    private void imprimirEnOrdenRecursivo(NodoMarca nodo) {
        if (nodo != null) {
            imprimirEnOrdenRecursivo(nodo.hijoIzquierdo);
            ta.append(nodo.nombreMarca + " - " + nodo.idMarca + "\n");
            imprimirEnOrdenRecursivo(nodo.hijoDerecho);
        }
    }
    /**
     * Obtiene el tamaño del árbol (número de marcas).
     */

    public int tamaño() {
        return tamañoRecursivo(raiz);
    }

    private int tamañoRecursivo(NodoMarca nodo) {
        if (nodo == null) {
            return 0;
        }

        int tamañoIzquierdo = tamañoRecursivo(nodo.hijoIzquierdo);
        int tamañoDerecho = tamañoRecursivo(nodo.hijoDerecho);

        return tamañoIzquierdo + tamañoDerecho + 1;
    }
    /**
     * Verifica si el árbol está vacío.
     */

    public boolean estaVacio() {
        return raiz == null;
    }
}