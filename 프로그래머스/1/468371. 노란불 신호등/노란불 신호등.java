class Solution {
    public int solution(int[][] signals) {
        int len = 1;

		for (int[] signal : signals)
			len *= signal[0]  + signal[1] + signal[2];

		int[] yellow_on = new int[len + 1];

		for (int[] signal : signals) {
			int g = signal[0];
			int y = signal[1];
			int r = signal[2];

			int t = g + y + r;

			for (int i = 1; i <= len; i += t)
				for (int j = 0; j < y; j++)
					yellow_on[g + i + j]++;
		}

		for (int i = 1; i <= len; i++)
			if (yellow_on[i] == signals.length)
				return i;
		
		return -1;
    }
}