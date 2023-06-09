package Arboles;

import Nodos.NodoDetalle;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class ABDetalle {
    NodoDetalle raiz;

    public ABDetalle() {
        raiz = null;
    }

    public void insertar(int idFactura, int idDetalle, int idProducto, int cantidadProductos, int valorProducto) {
        raiz = insertarRecursivo(raiz, idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
    }

    private NodoDetalle insertarRecursivo(NodoDetalle nodo, int idFactura, int idDetalle, int idProducto, int cantidadProductos, int valorProducto) {
        if (nodo == null) {
            nodo = new NodoDetalle(idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
            return nodo;
        }

        if (idDetalle < nodo.idDetalle) {
            nodo.hijoIzquierdo = insertarRecursivo(nodo.hijoIzquierdo, idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
        } else if (idDetalle > nodo.idDetalle) {
            nodo.hijoDerecho = insertarRecursivo(nodo.hijoDerecho, idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
        }

        return nodo;
    }

    public String buscar(int idDetalle) {

        return buscarRecursivo(raiz, idDetalle);
    }

    private String buscarRecursivo(NodoDetalle nodo, int idDetalle) {
        if (nodo == null) {
            return "";
        }


        if (idDetalle==nodo.idDetalle) {
            return "Detalle de factura con id: " + nodo.idDetalle + " - " + nodo.idFactura + " - " + nodo.idProducto + nodo.cantidadProductos + " - " + nodo.valorProducto;
        } else if (idDetalle < nodo.idDetalle) {
            return buscarRecursivo(nodo.hijoIzquierdo, idDetalle);
        } else {
            return buscarRecursivo(nodo.hijoDerecho, idDetalle);
        }
    }

    public String editar(int idFactura, int idDetalle, int idProducto, int cantidadProductos, int valorProducto) {
        raiz = editarRecursivo(raiz, idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
        String buscarNodo = buscar(idDetalle);
        if(buscarNodo.equals(""))
            return "";
        else
            return buscarNodo;
    }

    private NodoDetalle editarRecursivo(NodoDetalle nodo, int idFactura, int idDetalle, int idProducto, int cantidadProductos, int valorProducto) {
        if (nodo == null) {
            return null;
        }

        if (nodo.idDetalle == idDetalle) {
            nodo.idFactura = idFactura;
            nodo.idProducto = idProducto;
            nodo.cantidadProductos = cantidadProductos;
            nodo.valorProducto = valorProducto;

        } else if (idDetalle < nodo.idDetalle) {
            nodo.hijoIzquierdo = editarRecursivo(nodo.hijoIzquierdo, idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
        } else {
            nodo.hijoDerecho = editarRecursivo(nodo.hijoDerecho, idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
        }

        return nodo;
    }

    public String eliminar(int idDetalle) {
        String buscarNodo = buscar(idDetalle);
        raiz = eliminarRecursivo(raiz, idDetalle);
        if(buscarNodo.equals(""))
            return "";
        else
            return buscarNodo;
    }

    private NodoDetalle eliminarRecursivo(NodoDetalle nodo, int idDetalle) {
        if (nodo == null) {
            return null;
        }

        if (idDetalle<nodo.idFactura) {
            nodo.hijoIzquierdo = eliminarRecursivo(nodo.hijoIzquierdo, idDetalle);
        } else if (idDetalle>nodo.idFactura) {
            nodo.hijoDerecho = eliminarRecursivo(nodo.hijoDerecho, idDetalle);
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
                NodoDetalle sucesor = encontrarSucesor(nodo.hijoDerecho);
                nodo.idFactura = sucesor.idFactura;
                nodo.idProducto = sucesor.idProducto;
                nodo.cantidadProductos = sucesor.cantidadProductos;
                nodo.valorProducto = sucesor.valorProducto;
                nodo.hijoDerecho = eliminarRecursivo(nodo.hijoDerecho, sucesor.idDetalle);
            }
        }

        return nodo;
    }

    private NodoDetalle encontrarSucesor(NodoDetalle nodo) {
        while (nodo.hijoIzquierdo != null) {
            nodo = nodo.hijoIzquierdo;
        }
        return nodo;
    }

    public void imprimirEnOrden(JTextArea ta) {
        //this.ta = ta;
        imprimirEnOrdenRecursivo(raiz);
    }

    private void imprimirEnOrdenRecursivo(NodoDetalle nodo) {
        if (nodo != null) {
            imprimirEnOrdenRecursivo(nodo.hijoIzquierdo);
            //ta.append(nodo.nombreMarca + " - " + nodo.idMarca + "\n");
            imprimirEnOrdenRecursivo(nodo.hijoDerecho);
        }
    }

    public int tamaño() {
        return tamañoRecursivo(raiz);
    }

    private int tamañoRecursivo(NodoDetalle nodo) {
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
