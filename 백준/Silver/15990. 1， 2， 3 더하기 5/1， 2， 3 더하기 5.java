import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	final static int MOD = 1_000_000_009;
	public static void main(String[] args) throws IOException {
		long[][] dp = dynamic();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		while (n--> 0) {
			int t = Integer.parseInt(br.readLine());
			long ans = (dp[t][1] + dp[t][2] + dp[t][3]) % MOD;
			bw.append(String.valueOf(ans)).append("\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static long[][] dynamic() {
		long[][] dp = new long[100_001][4];
		dp[1][1] = 1; // 1
		dp[2][2] = 1; // 2
		dp[3][1] = 1; // 1 + 2
		dp[3][2] = 1; // 2 + 1
		dp[3][3] = 1; // 3

		for (int i = 4; i < dp.length; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
		}

		return dp;
	}
}
