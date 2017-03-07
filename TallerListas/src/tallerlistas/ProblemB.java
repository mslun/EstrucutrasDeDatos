import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Deque;
import java.util.LinkedList;

public class ProblemB {

	public static void main(String[] args) throws Exception {
		BufferedReader in;
		File f = new File("B_7.txt");
		if (f.exists()) {
			in = new BufferedReader(new FileReader(f));
			System.setOut(new PrintStream(new File("B_7Out.txt")));
		} else {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
		String line = in.readLine();
		int N = Integer.parseInt(line);

		for (int t = 0; t < N; t++) {
			System.out.println("Caso #" + (t + 1) + ":");
			int arr[] = readInts(in.readLine());
			int p = arr[0];
			int persons = arr[1];
			int r[] = readInts(in.readLine());
			Deque<Integer> q = new LinkedList<>();
			for (int i = 0; i < r.length; i++) {
				q.addLast(r[i]);
			}
			int sum[] = new int[persons];
			int k = 0;
			int max = 0;
			while (!q.isEmpty()) {
				if (q.peekFirst() > q.peekLast()) {
					sum[k] += q.pollFirst();
				} else {
					sum[k] += q.pollLast();
				}
				max = Math.max(sum[k], max);
				k = (k + 1) % persons;
			}
			int count = 0;
			for (int i = 0; i < sum.length; i++) {
				if (sum[i] == max) {
					if (count++ > 0)
						System.out.print(" ");
					System.out.print((i + 1));
				}
			}
			System.out.println();
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
