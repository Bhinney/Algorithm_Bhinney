import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		System.out.println(solution(n));
	}

	private static int solution(int n) {
		if (n < 10) return n;

		int answer = 9; // 자릿수
		int add = 1; // 자릿수에 더할 값
		int num = 10; // 몇자리수?

		for (int i = 10; i <= n; i++) {
			if (i % num == 0) {
				add++;
				num *= 10;
			}

			answer += add;
		}

		return answer;
	}
}