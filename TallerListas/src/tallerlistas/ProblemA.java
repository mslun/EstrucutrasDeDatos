import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class ProblemA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in;
		File f = new File("A_1.txt");
		if (f.exists()) {
			in = new BufferedReader(new FileReader(f));
			System.setOut(new PrintStream(new File("A_1Out.txt")));
		} else {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
		int k = Integer.parseInt(in.readLine());

		for (int t = 0; t < k; t++) {
			System.out.println("Caso #" + (t+1)+":");
			int n = Integer.parseInt(in.readLine());
			ArrayList<Integer> list = new ArrayList<Integer>();
			LinkedList<Integer> chain = new LinkedList<>();
			int costList = 0;
			int costChain = 0;
			int index;
			int value;
                        
			for (int i = 0; i < n; i++) {
				
				// System.out.println(list);
				String line[] = in.readLine().split(" ");
				String type = line[0];
				if (type.equals("insertar")) {
					value = Integer.parseInt(line[1]);
					index = Integer.parseInt(line[2]);
					if (index <= list.size()) {
						costList += (list.size() - index);
						costChain += index;
						list.add(index, value);
						chain.add(index, value);
						System.out.println("insertar: posicion valida");
					} else {
						System.out.println("insertar: posicion invalida");
					}
				} else if (type.equals("consultar")) {
					index = Integer.parseInt(line[1]);
					if (index < list.size()) {
						System.out.println("consulta: " + list.get(index));
						costChain += index;
					} else {
						System.out.println("consulta: no encontrado");
					}
				} else if (type.equals("eliminar")) {
					index = Integer.parseInt(line[1]);
					if (index < list.size()) {
						costList += list.size() - (index + 1);
						costChain += index;
						list.remove(index);
						chain.remove(index);
						System.out.println("eliminar: posicion valida");
					} else {
						System.out.println("eliminar: posicion invalida");
					}
				} else if (type.equals("buscar")) {
					value = Integer.parseInt(line[1]);
					boolean ok = false;
					for (int j = 0; j < list.size(); j++) {
						if (value == list.get(j)) {
							System.out.println("buscar: " + j);
							costList += j + 1;
							costChain += j + 1;
							ok = true;
							break;
						}
					}
					if (!ok) {
						costList += list.size();
						costChain += list.size();
						System.out.println("no existe numero");
					}
				} else if (type.equals("costo")) {
					System.out.println("costo: " + costList + " " + costChain);
				}
			}
		}

	}
}
