/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author maleo
 */
public class cInRandomGen {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\maleo\\desktop\\CN4R.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        int N = ThreadLocalRandom.current().nextInt(1, 100001);
        pw.println(N);
        for (int i = 0; i < N; i++) {
            
            pw.println(ThreadLocalRandom.current().nextInt(1, 1000000000)+" "+ThreadLocalRandom.current().nextInt(1, 1000000000));

        }

        pw.close();
    }
}
