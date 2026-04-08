import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int MOD = 1_000_000_009;

	public static void main(String[] args) throws IOException {
		long[][] dp = dynamic();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			int t = Integer.parseInt(br.readLine());
			System.out.println(dp[t][1] + " " + dp[t][0]);
		}
	}

	private static long[][] dynamic() {
		long[][] dp = new long[100_001][2]; // dp[i][0] : 짝수, dp[i][1] : 홀수
		dp[1][1] = 1; // 1
		dp[2][0] = 1; // 1 + 1
		dp[2][1] = 1; // 2
		dp[3][0] = 2; // 1 + 2, 2 + 1
		dp[3][1] = 2; // 1 + 1 + 1, 3

		for (int i = 4; i < dp.length; i++) {
			dp[i][1] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 3][0]) % MOD;
			dp[i][0] = (dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1]) % MOD;
		}

		return dp;
	}
}