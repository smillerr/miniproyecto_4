package Arboles;

import Nodos.NodoProducto;

import javax.swing.*;

public class ABProducto {
    NodoProducto raiz;

    public ABProducto() {
        raiz = null;
    }

    public void insertar(String descProducto, int idProducto, int idMarca) {
        raiz = insertarRecursivo(raiz, descProducto, idProducto, idMarca);
    }

    private NodoProducto insertarRecursivo(NodoProducto nodo, String descProducto, int idProducto, int idMarca) {
        if (nodo == null) {
            nodo = new NodoProducto(descProducto, idProducto, idMarca);
            return nodo;
        }

        if (idProducto < nodo.idProducto) {
            nodo.hijoIzquierdo = insertarRecursivo(nodo.hijoIzquierdo, descProducto, idProducto, idMarca);
        } else if (idProducto > nodo.idProducto) {
            nodo.hijoDerecho = insertarRecursivo(nodo.hijoDerecho, descProducto, idProducto, idMarca);
        }

        return nodo;
    }

    public String buscar(int idProducto) {

        return buscarRecursivo(raiz, idProducto);
    }

    private String buscarRecursivo(NodoProducto nodo, int idProducto) {
        if (nodo == null) {
            return "";
        }


        if (idProducto==nodo.idMarca) {
            return nodo.descProducto + " - " + nodo.idProducto + " - " + nodo.idMarca;
        } else if (idProducto < nodo.idMarca) {
            return buscarRecursivo(nodo.hijoIzquierdo, idProducto);
        } else {
            return buscarRecursivo(nodo.hijoDerecho, idProducto);
        }
    }

    public String editar(String descProducto, int idProducto, int idMarca) {
        raiz = editarRecursivo(raiz, descProducto, idProducto, idMarca);
        String buscarNodo = buscar(idProducto);
        if(buscarNodo.equals(""))
            return "";
        else
            return buscarNodo;
    }

    private NodoProducto editarRecursivo(NodoProducto nodo, String descProducto, int idProducto, int idMarca) {
        if (nodo == null) {
            return null;
        }

        if (nodo.idProducto == idProducto) {
            nodo.descProducto = descProducto;
            nodo.idMarca = idMarca;
        } else if (idProducto < nodo.idProducto) {
            nodo.hijoIzquierdo = editarRecursivo(nodo.hijoIzquierdo, descProducto, idProducto, idMarca);
        } else {
            nodo.hijoDerecho = editarRecursivo(nodo.hijoDerecho, descProducto, idProducto, idMarca);
        }

        return nodo;
    }

    public String eliminar(int idProducto) {
        String buscarNodo = buscar(idProducto);
        raiz = eliminarRecursivo(raiz, idProducto);
        if(buscarNodo.equals(""))
            return "";
        else
            return buscarNodo;
    }

    private NodoProducto eliminarRecursivo(NodoProducto nodo, int idProducto) {
        if (nodo == null) {
            return null;
        }

        if (idProducto<nodo.idProducto) {
            nodo.hijoIzquierdo = eliminarRecursivo(nodo.hijoIzquierdo, idProducto);
        } else if (idProducto>nodo.idMarca) {
            nodo.hijoDerecho = eliminarRecursivo(nodo.hijoDerecho, idProducto);
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
                NodoProducto sucesor = encontrarSucesor(nodo.hijoDerecho);
                nodo.descProducto = sucesor.descProducto;
                nodo.idMarca = sucesor.idMarca;
                nodo.hijoDerecho = eliminarRecursivo(nodo.hijoDerecho, sucesor.idProducto);
            }
        }

        return nodo;
    }

    private NodoProducto encontrarSucesor(NodoProducto nodo) {
        while (nodo.hijoIzquierdo != null) {
            nodo = nodo.hijoIzquierdo;
        }
        return nodo;
    }

    public void imprimirEnOrden(JTextArea ta) {
        //this.ta = ta;
        imprimirEnOrdenRecursivo(raiz);
    }

    private void imprimirEnOrdenRecursivo(NodoProducto nodo) {
        if (nodo != null) {
            imprimirEnOrdenRecursivo(nodo.hijoIzquierdo);
            //ta.append(nodo.nombreMarca + " - " + nodo.idMarca + "\n");
            imprimirEnOrdenRecursivo(nodo.hijoDerecho);
        }
    }

    public int tamaño() {
        return tamañoRecursivo(raiz);
    }

    private int tamañoRecursivo(NodoProducto nodo) {
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
