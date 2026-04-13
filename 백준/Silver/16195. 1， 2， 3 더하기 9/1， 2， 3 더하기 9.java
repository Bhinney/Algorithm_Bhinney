import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int MOD = 1_000_000_009;

	public static void main(String[] args) throws IOException {
		long[][] dp =  dynamic();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			long sum = 0;

			for (int i = 1 ; i <= input[1]; i++)
				sum += dp[input[0]][i];

			System.out.println(sum % MOD);
		}
	}

	private static long[][] dynamic() {
		long[][] dp = new long[1001][1001]; // dp[n][m]
		dp[1][1] = 1; // 1
		dp[2][1] = 1; // 2
		dp[2][2] = 1; // 1 + 1
		dp[3][1] = 1; // 3
		dp[3][2] = 2; // 1 + 2, 2 + 1
		dp[3][3] = 1; // 1 + 1 + 1

		for (int i = 4; i < dp.length; i++) {
			dp[i][i] = 1;

			for (int j = 2; j < i; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp[i - 3][j - 1]) % MOD;
			}
		}

		return dp;
	}
}