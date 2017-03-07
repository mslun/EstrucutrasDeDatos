import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class ProblemD {

	public static int[] readInts(String cad) {
		String lines[] = cad.split(" ");
		int arr[] = new int[lines.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(lines[i]);
		}
		return arr;
	}

	public static class Person {
		String name;
		String last;
		String ced;
		boolean flag;

		public Person(String name, String last, String ced) {
			this.name = name;
			this.last = last;
			this.ced = ced;
			flag = true;
		}

		public void setPerson(Person p) {
			this.name = p.name;
			this.last = p.last;
			this.ced = p.ced;
			flag = true;
		}

		public void setFlag(boolean a) {
			this.flag = a;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in;
		File f = new File("D_1.txt");
		if (f.exists()) {
			in = new BufferedReader(new FileReader(f));
			//System.setOut(new PrintStream(new File("D_1Out.txt")));
		} else {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
		String line = in.readLine();
		int N = Integer.parseInt(line);
		for (int t = 0; t < N; t++) {
			System.out.println("Caso #" + (t + 1) + ":");
			int num = Integer.parseInt(in.readLine());
			int arr[] = readInts(in.readLine());
			int q = Integer.parseInt(in.readLine());
			ArrayList<ArrayList<Person>> persons = new ArrayList<ArrayList<Person>>();
			int count[] = new int[num];
			for (int i = 0; i < num; i++) {
				persons.add(new ArrayList<Person>());
			}
			for (int i = 0; i < q; i++) {
				String s[] = in.readLine().split(" ");
				if (s[0].equals("ingresar")) {
					Person p = new Person(s[1], s[2], s[3]);
					int index = -1;
					double max = 100000;
					for (int j = 0; j < persons.size(); j++) {
						double tmp = count[j] / (arr[j] * 1.0);
						if (tmp < max && count[j] < arr[j]) {
							max = tmp;
							index = j;
						}
					}
					if (index == -1) {
						System.out.println("limite alcanzado");
					} else {
						int idx = -1;
						for (int j = 0; j < persons.get(index).size(); j++) {
							if (persons.get(index).get(j).flag == false) {
								idx = j;
								break;
							}
						}
						if (count[index] == 0 && idx == -1) {
							persons.get(index).add(p);
							System.out.println((index + 1) + " " + (1));
							count[index]++;
						} else {
							if (idx == -1) {
								persons.get(index).add(p);
								System.out.println((index + 1) + " " + (persons.get(index).size()));
								count[index]++;
							} else {
								persons.get(index).get(idx).setPerson(p);
								System.out.println((index + 1) + " " + (idx + 1));
								count[index]++;
							}
						}

					}
				} else {
					boolean flag = false;
					for (int j = 0; j < persons.size() && !flag; j++) {
						for (int k = 0; k < persons.get(j).size() && !flag; k++) {
							Person tmp = persons.get(j).get(k);
							if (tmp.ced.equals(s[1])) {
								System.out.println(tmp.name);
								persons.get(j).get(k).setFlag(false);
								count[j]--;
								flag = true;
								break;
							}
						}
					}
				}
			}

		}

	}

}