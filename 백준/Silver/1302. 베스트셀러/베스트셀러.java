import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		Map<String, Integer> map = new HashMap<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			String book = br.readLine();
			map.put(book, map.getOrDefault(book, 0) + 1);
		}

		br.close();

		String best = map.entrySet().stream()
			.max(Map.Entry.<String, Integer>comparingByValue()
				.thenComparing(Map.Entry.<String, Integer>comparingByKey().reversed()))
			.map(Map.Entry::getKey)
			.orElse("No");

		System.out.println(best);
	}
}