import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		int start = 0, end = 0, cnt = 0, sum = 0;

		while (end <= n) {
			if (sum == n) {
				cnt++;
				end++;
				sum += end;
			} else if (sum < n) {
				end++;
				sum += end;
			} else {
				start++;
				sum -= start;
			}
		}

		System.out.println(cnt);
	}
}