import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[col - 1] == o2[col - 1]) return o2[0] - o1[0];
				return o1[col - 1] - o2[col - 1];
			}
		});

		int ans = 0;
		for (int i = row_begin - 1; i < row_end; i++) {
			int sum = 0;
			for (int j = 0; j < data[0].length; j++) {
				sum += (data[i][j] % (i + 1));
			}

			ans = (ans ^ sum);
		}

		return ans;
    }
}