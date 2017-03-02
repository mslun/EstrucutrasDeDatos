
import java.util.ArrayList;
import ArrayList.MyArrayList;
import LinkedList.MyLinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maleo
 */
public class main {

    /*public static void ejemploArrayList() {
        ArrayList<String> al = new ArrayList<>();
        System.out.println("Tamaño inicial: " + al.size());
        al.add("A");
        al.add("B");
        al.add("C");
        al.add("D");
        al.add("E");
        al.add("F");
        al.add(1, "A2");
        System.out.println("Tamaño después de insertar: " + al.size());
        System.out.println("Contenido: " + al);
        al.remove("F");
        al.remove(2);
        System.out.println("Tamaño después de eliminar: " + al.size());
        System.out.println("Contenido: " + al);
        for (String i : al) {
            System.out.print(i + "; ");
        }
    }

    public static void main(String[] args) {
        
        ejemploArrayList();

    }*/
    public static void main(String[] args) {
        /*MyArrayList<Integer> lst = new MyArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            lst.add(i);
        }
        for (int i = 20; i < 30; i++) {
            lst.add(0, i);
        }

        lst.remove(0);
        lst.remove(lst.size() - 1);

        System.out.println(lst);*/

        MyLinkedList<Integer> lst = new MyLinkedList<Integer>();

        for (int i = 0; i < 10; i++) {
            lst.add(i);
        }
        for (int i = 20; i < 30; i++) {
            lst.add(0, i);
        }

        lst.remove(0);
        lst.remove(lst.size() - 1);

        System.out.println(lst);

        java.util.Iterator<Integer> itr = lst.iterator();
        while (itr.hasNext()) {
            itr.next();
            itr.remove();
            System.out.println(lst);
        }
    }

}
