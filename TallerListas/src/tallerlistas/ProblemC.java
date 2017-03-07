
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

class ProblemC {
	public static void main(String args[]) throws Exception {

		BufferedReader in;
		File f = new File("C_4.txt");
		if (f.exists()) {
			in = new BufferedReader(new FileReader(f));
			System.setOut(new PrintStream(new File("C_4Out.txt")));
		} else {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
		
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> list = readInts(in.readLine());
		int m = Integer.parseInt(in.readLine());
		int cont = 0;
		for (int j = 0; j < m; j++) {
			ArrayList<Integer> temp = readInts(in.readLine());
			boolean flag = false;
			for (int i = 0; i < list.size(); i++) {
				flag = false;
				for (int k = 0; k < temp.size(); k++) {
					if (list.get(i) == temp.get(k)) {
						flag = true;
						break;
					}
				}
				if (flag == false) {
					break;
				}
			}

			if (flag == false) {

			} else {
				cont++;
			}
		}
		System.out.println(cont);

	}

	public static ArrayList<Integer> readInts(String cad) {
		String line[] = cad.split(" ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < line.length; i++) {
			list.add(Integer.parseInt(line[i]));
		}
		return list;
	}

}
