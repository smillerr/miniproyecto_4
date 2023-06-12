package Arboles;

import Nodos.NodoDetalle;

import javax.swing.*;

public class ABDetalle {
    NodoDetalle raiz;

    public ABDetalle() {
        raiz = null;
    }

    public void insertar(int idFactura, int idDetalle, int idProducto, int cantidadProductos, int valorProducto) {
        raiz = insertarRecursivo(raiz, idFactura, idDetalle, idProducto, cantidadProductos, valorProducto);
    }
    /**
     * El metodo insertar recursivo tiene como parametros el nodo a instertar, el id de la factura, el id del detalle de la factura, la cantidad de productos, el valor de cada producto
     *
     * Tiene 4 posibles casos:
     *
     * 1) En caso tal de que el nodo sea el primero en agregar, lo pone como la raiz del arbol
     * 2) En caso de que se intente agregar un nodo que ya exista, ya que el id es unico, se retorna el nodo que se habia creado con ese id, es decir, el nodo antiguo
     * 3) En caso tal de que el id sea menor al que ya está, entonces se añade como el hijo izquierdo
     * 4) En caso tal de que el id sea mayor al que ya está, se añade como el hijo derecho
     *
     * Esto para asegurar que no se pueda insertar un detalle de factura con un id que ya exista, es decir, se asegura la exclusividad
     * **/
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

    public int buscarPrecio(int idFactura) {

        return buscarPrecioRecursivo(raiz, idFactura);
    }

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
    public NodoDetalle buscarDetallePorFactura(int idFactura) {

        return buscarDetallePorFacturaRecursivo(raiz, idFactura);
    }

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
