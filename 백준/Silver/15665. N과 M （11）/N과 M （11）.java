import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		input();
		solution();
		output();
	}

	private static int N, M;
	private static int[] arr;
	private static List<String> list;

	private static void solution() {
		int[] res = new int[M];
		list = new ArrayList<>();
		perm(res, 0);
	}
	private static void perm(int[] res, int depth) {
		if (depth == M) {
			list.add(IntStream.of(res).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
			return;
		}

		for (int i = 0; i < N; i++) {
			res[depth] = arr[i];
			perm(res, depth + 1);
		}
	}
	private static void output() {
		System.out.println(list.stream().distinct().collect(Collectors.joining("\n")));
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		N = nm[0];
		M = nm[1];
		br.close();
	}
}