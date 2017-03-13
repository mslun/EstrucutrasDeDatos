
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class C {

    public static class Pair {

        long a, b, index;

        public Pair(long a, long b, long index) {
            this.a = a;
            this.b = b;
            this.index = index;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in;

        File f;
        f = new File("C:\\Users\\maleo\\desktop\\CN4R.txt");
        //if (f.exists()) {
        in = new BufferedReader(new FileReader(f));
        //} else {
        //	in = new BufferedReader(new InputStreamReader(System.in));
        //}

        int n = Integer.parseInt(in.readLine());
        Pair p[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            int tmp[] = readInts(in.readLine());
            p[i] = new Pair(tmp[0], tmp[1], i);
        }
        Queue<Pair> q = new LinkedList<Pair>();
        boolean flag = false;
        long count = 0;
        int res = 0;
        int idx = 0;
        while (flag == false) {
            if (q.size() == n) {
                System.out.println(res);
                break;
            }
            if (count + p[idx % n].a - p[idx % n].b >= 0) {
                q.add(new Pair(p[idx % n].a, p[idx % n].b, idx));
                count += p[idx % n].a - p[idx % n].b;
                idx++;
            } else {
                boolean c = false;
                while (!q.isEmpty()) {
                    count += q.peek().b - q.peek().a;
                    q.poll();
                    res++;
                    if (count >= 0) {
                        c = true;
                        break;
                    }
                }
                if (!c) {
                    idx++;
                    res++;
                }
            }
        }
    }

    public static int[] readInts(String cad) {
        String lines[] = cad.split(" ");
        int arr[] = new int[lines.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(lines[i]);
        }
        return arr;
    }
}
