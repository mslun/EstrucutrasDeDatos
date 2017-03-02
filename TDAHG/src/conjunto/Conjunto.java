/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjunto;

/**
 *
 * @author maleo
 */
public class Conjunto {

    static int M = 20; // aumento de la capacidad
    private Object[] cto;
    private int cardinal;
    private int capacidad;
// operaciones

    public Conjunto() {
        cto = new Object[M];
        cardinal = 0;
        capacidad = M;
    }
// determina si el conjunto está vacío

    public boolean esVacio() {
        return (cardinal == 0);
    }
// añade un elemento si no está en el conjunto

    public void annadir(Object elemento) {
        if (!pertenece(elemento)) {
            /* verifica si hay posiciones libres,
en caso contrario amplia el conjunto */
            if (cardinal == capacidad) {
                Object[] nuevoCto;
                nuevoCto = new Object[capacidad + M];
                for (int k = 0; k < capacidad; k++) {
                    nuevoCto[k] = cto[k];
                }
                capacidad += M;
                cto = nuevoCto;
                System.gc(); // devuelve la memoria no referenciada
                
            }
            cto[cardinal++] = elemento;
        }
    }
// quita elemento del conjunto

    public void retirar(Object elemento) {
        if (pertenece(elemento)) {
            int k = 0;
            while (!cto[k].equals(elemento)) {
                k++;
            }
            /* desde el elemento k hasta la última posición
mueve los elementos una posición a la izquierda */
            for (; k < cardinal; k++) {
                cto[k] = cto[k + 1];
            }
            cardinal--;
        }
    }
//busca si un elemento pertenece al conjunto

    public boolean pertenece(Object elemento) {
        int k = 0;
        boolean encontrado = false;
        while (k < cardinal && !encontrado) {
            encontrado = cto[k].equals(elemento);
            k++;
        }
        return encontrado;
    }
//devuelve el número de elementos

    public int cardinal() {
        return this.cardinal;
    }
//operación unión de dos conjuntos

    public Conjunto union(Conjunto c2) {
        Conjunto u = new Conjunto();
// primero copia el primer operando de la unión
        for (int k = 0; k < cardinal; k++) {
            u.cto[k] = cto[k];
        }
        u.cardinal = cardinal;
// añade los elementos de c2 no incluidos
        for (int k = 0; k < c2.cardinal; k++) {
            u.annadir(c2.cto[k]);
        }
        return u;
    }

    public Object elemento(int n) throws Exception {
        if (n <= cardinal) {
            return cto[--n];
        } else {
            throw new Exception("Fuera de rango");
        }
    }
}
