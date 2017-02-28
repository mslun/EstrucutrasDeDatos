/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author maleo
 */
import pilas.PilaLineal;
import java.io.*;

class EjemploPila {

    public static void main(String[] a) {
        PilaLineal pila;
        int x;
        final int CLAVE = -1;
        BufferedReader entrada = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Teclea los elemento (termina con -1).");
        try {
            pila = new PilaLineal(); // crea pila vacía
            do {
                x = Integer.parseInt(entrada.readLine());
                pila.insertar(x);
            } while (x != CLAVE);
            System.out.println("Elementos de la Pila: ");
            while (!pila.pilaVacia()) {
                x = pila.quitar();
                System.out.print(x + " ");
            }
        } catch (Exception er) {
            System.err.println("Excepcion: " + er);
        }
    }
}
