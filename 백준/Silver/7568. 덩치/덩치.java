import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] people = new int[n][2];
		for (int i = 0; i < n; i++) {
			people[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		br.close();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int rank = 1;

			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) rank++;
			}

			sb.append(rank).append(" ");
		}

		System.out.println(sb.toString());
	}
}