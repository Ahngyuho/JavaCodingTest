package Prac2;

import java.util.*;

public class Prob2 {
    public int solution(String s) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char key : map.keySet()) {
            list.add(map.get(key));
        }

        int tmp = 0;
        int duple = 1;
        for (int x : list) {
            if (x == tmp) {
                duple++;
            }
        }

        return answer;
    }
}
