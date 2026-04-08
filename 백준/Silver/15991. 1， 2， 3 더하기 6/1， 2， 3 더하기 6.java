import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int MOD = 1_000_000_009;
	public static void main(String[] args) throws IOException {
		long[] dp = dynamic();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while (n--> 0) {
			int t = Integer.parseInt(br.readLine());
			System.out.println(dp[t]);
		}
	}

	private static long[] dynamic() {
		long[] dp = new long[100_001];
		dp[1] = 1; // 1
		dp[2] = 2; // 1 + 1, 2
		dp[3] = 2; // 1 + 1 + 1, 3
		dp[4] = 3; // 1 + 1 + 1 + 1, 1 + 2 + 1, 2 + 2
		dp[5] = 3; // 1 + 1 + 1 + 1 + 1, 1 + 3 + 1, 2 + 1 + 2
		dp[6] = 6; // 1 + 1 + 1 + 1 + 1 + 1, 1 + 1 + 2 + 1 + 1, 1 + 2 + 2 + 1,  2 + 2 + 2, 2 + 1 + 1 + 2,  3 + 3

		for (int i = 7; i < dp.length; i++)
			dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % MOD;

		return dp;
	}
}