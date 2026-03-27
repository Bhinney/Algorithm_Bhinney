import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

	private static class Solution {
		void solution() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());

			while (t-- > 0) {
				int n = Integer.parseInt(br.readLine()); // 동전의 개수
				int[] coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int target = Integer.parseInt(br.readLine()); // 만들어야 하는 금액

				solve(n, coins, target);
			}
		}

		private void solve(int n, int[] coins, int target) {
			int[] dp = new int[target + 1];
			dp[0] = 1;

			for (int i = 0; i < n; i++) {
				for (int j = coins[i]; j < target + 1; j++) {
					dp[j] = dp[j] + dp[j - coins[i]];
				}
			}

			System.out.println(dp[target]);
		}
	}
}