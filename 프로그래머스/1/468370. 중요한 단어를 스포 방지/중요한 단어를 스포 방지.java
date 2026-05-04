import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        
        // 1. 스포일러 문자 변경하기
        StringBuilder sb = new StringBuilder(message);
        for (int[] range : spoiler_ranges) {
			for (int i = range[0]; i <= range[1]; i++) {
				if (message.charAt(i) == ' ') continue;

				sb.setCharAt(i, '*');
			}
		}

        // 2. 변경된 단어 저장하기
        String[] origins = message.split(" ");
        String[] changes = sb.toString().split(" ");
        Set<String> spoilers = new HashSet<>();
        
        for (int i = 0; i < origins.length; i++)
			if (!origins[i].equals(changes[i]))
				spoilers.add(origins[i]);

        // 3. 변경된 단어가 없으면 ++
        int answer = 0;
        List<String> list = Arrays.stream(changes).collect(Collectors.toList());
		for (String s : spoilers)
			if (!list.contains(s)) answer++;
        
        return answer;
    }
}