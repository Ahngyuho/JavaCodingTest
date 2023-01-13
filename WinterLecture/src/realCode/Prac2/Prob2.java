package realCode.Prac2;

import java.util.*;

public class Prob2 {
    public int solution(String s) {
        int answer = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : map.keySet()) {
            while (set.contains(map.get(x))) {
                answer++;
                map.put(x, map.get(x) - 1);
            }

            if(map.get(x) != 0) set.add(map.get(x));
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution("aebbbbc"));
    }
}
