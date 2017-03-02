/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaEncadenada;

/**
 *
 * @author maleo
 */
public class Lista {

    protected Nodo primero;

    public Lista() {
        primero = null;
    }

    public Lista insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;
        return this;
    }

    public Lista insertarUltimo(Nodo ultimo, int entrada) {
        ultimo.enlace = new Nodo(entrada);
        ultimo = ultimo.enlace;
        return this;
    }

    public Lista insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;
        return this;
    }

    public void visualizar() {
        Nodo n;
        int k = 0;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
            k++;
            System.out.print((k % 15 != 0 ? " " : "\n"));
        }
    }

}
