package Prac2;

import java.util.*;

public class Prob1 {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();

        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String tmp = "abcde";
        for (char key : tmp.toCharArray()) {
            if (map.getOrDefault(key, 0) > max) {
                max = map.getOrDefault(key, 0);
            }
        }

        for (char key : tmp.toCharArray()) {
            answer.add(max - map.getOrDefault(key, 0));
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution("aaabc"));
    }
}
