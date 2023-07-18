package Prac1;

import java.util.*;
public class Prob7 {
    public int[] solution(String s) {
        int[] answer = new int[3];
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) map.put(x,map.getOrDefault(x,0) + 1);
        int max = 0;
        for(char x : map.keySet()) max = Math.max(max,map.get(x));
        String tmp = "abc";
        for(char x : tmp.toCharArray()){
            answer[x-97] = max - map.getOrDefault(x,0);
        }
        for(int x : answer) System.out.print(x + " ");
        return answer;
    }

    public static void main(String[] args) {
        Prob7 T = new Prob7();
        System.out.println(T.solution("aaabc"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("abc"));
        System.out.println(T.solution("ac"));
    }
}
