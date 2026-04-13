import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("(?<=>)|(?=<)");
		br.close();

		/*
		 * <, > 있으면 저걸 기준으로 분리 꺽쇄 안의 문자는 reverse X
		 * <, > 없으면 띄어쓰기 기준으로 분리 후 reverse
		 */

		StringBuilder result = new StringBuilder();

		for (String s : input) {
			if (s.startsWith("<"))
				result.append(s);
			else {
				String[] target = s.split(" ");

				for (int i = 0; i < target.length - 1; i++)
					result.append(reverse(target[i])).append(" ");

				result.append(reverse(target[target.length - 1]));
			}
		}

		System.out.println(result.toString());
	}

	private static String reverse(String str) {

		return new StringBuilder(str).reverse().toString();
	}
}