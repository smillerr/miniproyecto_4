package Arboles;

import Nodos.NodoDetalle;

import javax.swing.*;

/**
 * Esta clase representa un Árbol Binario de Detalles de Facturas.
 */
public class ABDetalle {
    NodoDetalle raiz;
    /**
     * Crea un nuevo Árbol Binario de Detalles de Facturas.
     */
    public ABDetalle() {
        raiz = null;
    }
    /**
     * Inserta un nuevo detalle de factura en el árbol.
     */

    public void insertar(int idFactura, int idDetalle, int idProducto, int cantidadProductos, int valorProducto) {
        raiz = insertarRecursivo(raiz, idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
    }

    /**
     * Inserta un nuevo detalle de factura de forma recursiva.
     */
    private NodoDetalle insertarRecursivo(NodoDetalle nodo, int idFactura, int idDetalle, int idProducto, int cantidadProductos, int valorProducto) {
        if (nodo == null) {
            nodo = new NodoDetalle(idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
            return nodo;
        }
        if(idDetalle == nodo.idDetalle){
            JOptionPane.showMessageDialog(null, "El detalle de factura que esta intentando insertar ya existe, por favor seleccione un codigo diferente", "Advertencia", JOptionPane.OK_CANCEL_OPTION);
            return nodo;
        }
        if (idDetalle < nodo.idDetalle) {
            nodo.hijoIzquierdo = insertarRecursivo(nodo.hijoIzquierdo, idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
        } else if (idDetalle > nodo.idDetalle) {
            nodo.hijoDerecho = insertarRecursivo(nodo.hijoDerecho, idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
        }

        return nodo;
    }
    /**
     * Busca un detalle de factura por su ID.
     */

    public String buscar(int idDetalle) {

        return buscarRecursivo(raiz, idDetalle);
    }
    /**
     * Busca un detalle de factura de forma recursiva.
     */

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
    /**
     * Busca el precio total de una factura por su ID.
     */

    public int buscarPrecio(int idFactura) {

        return buscarPrecioRecursivo(raiz, idFactura);
    }
    /**
     * Busca el precio total de una factura de forma recursiva.
     */

    private int buscarPrecioRecursivo(NodoDetalle nodo, int idFactura) {
        if (nodo == null) {
            return 0;
        }

        if (idFactura==nodo.idFactura) {
            return nodo.valorProducto * nodo.cantidadProductos;
        } else if (idFactura < nodo.idFactura) {
            return buscarPrecioRecursivo(nodo.hijoIzquierdo, idFactura);
        } else {
            return buscarPrecioRecursivo(nodo.hijoDerecho, idFactura);
        }
    }
    /**
     * Busca un detalle de factura por el ID de la factura.
     */
    public NodoDetalle buscarDetallePorFactura(int idFactura) {

        return buscarDetallePorFacturaRecursivo(raiz, idFactura);
    }
    /**
     * Busca un detalle de factura por el ID de la factura de forma recursiva.
     */

    private NodoDetalle buscarDetallePorFacturaRecursivo(NodoDetalle nodo, int idFactura) {
        if (nodo == null) {
            return null;
        }


        if (idFactura==nodo.idFactura) {
            return nodo;
        } else if (idFactura < nodo.idFactura) {
            return buscarDetallePorFacturaRecursivo(nodo.hijoIzquierdo, idFactura);
        } else {
            return buscarDetallePorFacturaRecursivo(nodo.hijoDerecho, idFactura);
        }
    }
    /**
     * Edita un detalle de factura.
     */
    public String editar(int idFactura, int idDetalle, int idProducto, int cantidadProductos, int valorProducto) {
        raiz = editarRecursivo(raiz, idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
        String buscarNodo = buscar(idDetalle);
        if(buscarNodo.equals(""))
            return "";
        else
            return buscarNodo;
    }
    /**
     * Edita un detalle de factura de forma recursiva.
     */

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
    /**
     * Elimina un detalle de factura.
     */

    public String eliminar(int idDetalle) {
        String buscarNodo = buscar(idDetalle);
        raiz = eliminarRecursivo(raiz, idDetalle);
        if(buscarNodo.equals(""))
            return "";
        else
            return buscarNodo;
    }
    /**
     * Elimina un detalle de factura de forma recursiva.
     */

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
    /**
     * Encuentra el sucesor de un nodo en el árbol.
     */


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

    public int tamanio() {
        return tamanioRecursivo(raiz);
    }

    private int tamanioRecursivo(NodoDetalle nodo) {
        if (nodo == null) {
            return 0;
        }

        int tamanioIzquierdo = tamanioRecursivo(nodo.hijoIzquierdo);
        int tamanioDerecho = tamanioRecursivo(nodo.hijoDerecho);

        return tamanioIzquierdo + tamanioDerecho + 1;
    }

    public boolean estaVacio() {
        return raiz == null;
    }
}
