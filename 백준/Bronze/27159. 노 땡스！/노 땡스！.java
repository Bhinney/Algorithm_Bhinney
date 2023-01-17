import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[36];

		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}

		int sum = 0;
		for (int i = 3; i <= 35; i++) {
			if (arr[i - 1] == 0 && arr[i] != 0)
				sum+=i;
		}
		System.out.println(sum);
	}
}