/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

/**
 *
 * @author maleo
 */
// declaración de la clase ColaLista
public class ColaLista {

    protected Nodo frente;
    protected Nodo fin;
// constructor: crea cola vacía

    public ColaLista() {
        frente = fin = null;
    }
// insertar: pone elemento por el final

    public void insertar(Object elemento) {
        Nodo a;
        a = new Nodo(elemento);
        if (colaVacia()) {
            frente = a;
        } else {
            fin.siguiente = a;
        }
        fin = a;
    }
// quitar: sale el elemento frente

    public Object quitar() throws Exception {
        Object aux;
        if (!colaVacia()) {
            aux = frente.elemento;
            frente = frente.siguiente;}
        else
            throw new Exception("Eliminar de una cola vacía");
        
        return aux;
    }
// libera todos los nodos de la cola

    public void borrarCola() {
        for (; frente != null;) {
            frente = frente.siguiente;
        }
        System.gc();
    }
// acceso al primero de la cola

    public Object frenteCola() throws Exception {
        if (colaVacia()) {
            throw new Exception("Error: cola vacía");
        }
        return (frente.elemento);
    }
// verificación del estado de la cola

    public boolean colaVacia() {
        return (frente == null);
    }
}
