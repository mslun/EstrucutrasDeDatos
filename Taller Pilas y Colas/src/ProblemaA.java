
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.io.File;
import java.io.FileReader;

public class ProblemaA {

    /**
     * @param s1
     * @param s
     * @param s_remove
     */
    public static void removeN(String s1, Deque s, Deque s_remove) {
        int t = Integer.parseInt(s1);
        for (int k = 0; k < t; k++) {
            s_remove.addFirst(s.removeFirst());
        }
    }

    public static void undoRemove(int uo, Deque s, Deque s_remove) {

        for (int i = 0; i < uo; i++) {
            if (!s_remove.isEmpty()) {
                s.addFirst(s_remove.removeFirst());
            }
        }

    }

    public static void main(String[] args) throws IOException {

        //BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        File f = new File("C:\\Users\\maleo\\desktop\\A1.txt");
        BufferedReader entrada = new BufferedReader (new FileReader(f));
        String linea = entrada.readLine();
        int q = Integer.parseInt(linea);

        Deque s = new LinkedList();
        Deque s_remove = new LinkedList();
        Deque pila_comandos = new LinkedList();

        for (int i = 0; i < q; i++) {

            String S[] = entrada.readLine().split(" ");

            if (S[0].equals("1")) {
                pila_comandos.addFirst(S[0] + " " + S[1]);
                for (int k = 0; k < S[1].length(); k++) {
                    s.addFirst(S[1].charAt(k));
                }
            }
            if (S[0].equals("2")) {
                pila_comandos.addFirst(S[0] + " " + S[1]);
                removeN(S[1], s, s_remove);
            }
            if (S[0].equals("3")) {

                int cont_get = s.size() - Integer.parseInt(S[1]);

                if (cont_get == 0) {
                    System.out.println(s.getFirst());
                } else {
                    for (int k = 0; k < cont_get; k++) {
                        s_remove.addFirst(s.removeFirst());

                        if (k == cont_get - 1) {
                            System.out.println(s.getFirst());
                        }

                    }
                    undoRemove(cont_get, s, s_remove);
                }
            }

            if (S[0].equals("4")) {

                String cr = pila_comandos.getFirst().toString();
                String SR[] = cr.split(" ");

                if (SR[0].equals("2")) {
                    undoRemove(Integer.parseInt(SR[1]), s, s_remove);
                }
                
                if (SR[0].equals("1")){
                    int t=SR[1].length();
                    
                    for (int k=0;k<t;k++){
                    s.removeFirst();
                    
                    }
                    
                
                }
                pila_comandos.removeFirst();

            }

            //System.out.println(pila_comandos);
            //System.out.println(s);

        }

    }

}
