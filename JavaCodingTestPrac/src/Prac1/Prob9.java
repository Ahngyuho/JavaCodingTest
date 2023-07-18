package Prac1;
import java.util.*;
public class Prob9 {
    public String solution(String s) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) map.put(x, map.getOrDefault(x, 0) + 1);
        int max = 0;
        for(char x : map.keySet()) max = Math.max(max,map.get(x));
        for(char x : s.toCharArray()) if(map.get(x) != max) answer += x;
        return answer;
    }

    public static void main(String[] args) {
        Prob9 T = new Prob9();
        System.out.println(T.solution("abcabcdefabc"));
        System.out.println(T.solution("abcabcdefbca"));
        System.out.println(T.solution("abxdeydeabz"));
    }
}
