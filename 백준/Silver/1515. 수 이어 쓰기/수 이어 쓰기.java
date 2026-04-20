import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();

		int pointer = 0;
		int answer = 0;

		loop:
		for (int i = 1; ; i++) {
			String base = String.valueOf(i);

			for (int j = 0; j < base.length(); j++) {
				if (input.charAt(pointer) == base.charAt(j)) {
					pointer++;
				}
				if (pointer == input.length()) {
					answer = i;
					break loop;
				}
			}
		}

		System.out.println(answer);
	}
}