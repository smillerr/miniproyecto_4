package Arboles;

import Nodos.NodoFactura;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class ABFactura {
    NodoFactura raiz;

    public ABFactura() {
        raiz = null;
    }

    public void insertar(int idFactura, LocalDate fechaFactura, LocalTime horaFactura) {
        raiz = insertarRecursivo(raiz, idFactura, fechaFactura, horaFactura);
    }

    private NodoFactura insertarRecursivo(NodoFactura nodo, int idFactura, LocalDate fechaFactura, LocalTime horaFactura) {
        if (nodo == null) {
            nodo = new NodoFactura(idFactura, fechaFactura, horaFactura);
            return nodo;
        }

        if (idFactura < nodo.idFactura) {
            nodo.hijoIzquierdo = insertarRecursivo(nodo.hijoIzquierdo, idFactura, fechaFactura, horaFactura);
        } else if (idFactura > nodo.idFactura) {
            nodo.hijoDerecho = insertarRecursivo(nodo.hijoDerecho, idFactura, fechaFactura, horaFactura);
        }

        return nodo;
    }

    public String buscar(int idFactura) {

        return buscarRecursivo(raiz, idFactura);
    }

    private String buscarRecursivo(NodoFactura nodo, int idFactura) {
        if (nodo == null) {
            return "";
        }


        if (idFactura==nodo.idFactura) {
            return "Factura con id: " + nodo.idFactura + " - " + nodo.fechaFactura + " - " + nodo.horaFactura;
        } else if (idFactura < nodo.idFactura) {
            return buscarRecursivo(nodo.hijoIzquierdo, idFactura);
        } else {
            return buscarRecursivo(nodo.hijoDerecho, idFactura);
        }
    }

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

    public void imprimirEnOrden(JTextArea ta) {
        //this.ta = ta;
        imprimirEnOrdenRecursivo(raiz);
    }

    private void imprimirEnOrdenRecursivo(NodoFactura nodo) {
        if (nodo != null) {
            imprimirEnOrdenRecursivo(nodo.hijoIzquierdo);
            //ta.append(nodo.nombreMarca + " - " + nodo.idMarca + "\n");
            imprimirEnOrdenRecursivo(nodo.hijoDerecho);
        }
    }

    public int tamaño() {
        return tamañoRecursivo(raiz);
    }

    private int tamañoRecursivo(NodoFactura nodo) {
        if (nodo == null) {
            return 0;
        }

        int tamañoIzquierdo = tamañoRecursivo(nodo.hijoIzquierdo);
        int tamañoDerecho = tamañoRecursivo(nodo.hijoDerecho);

        return tamañoIzquierdo + tamañoDerecho + 1;
    }

    public boolean estaVacio() {
        return raiz == null;
    }
}
