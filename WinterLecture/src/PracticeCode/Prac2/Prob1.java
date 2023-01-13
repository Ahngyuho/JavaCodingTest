package PracticeCode.Prac2;

import java.util.HashMap;

public class Prob1 {

    int[] solution(String s){
        HashMap<Character,Integer> nH = new HashMap<>();
        int[] answer = new int[5];
        for (char x : s.toCharArray()) {
            nH.put(x, nH.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for(char x : nH.keySet()){
            max = Math.max(max, nH.get(x));
        }
        String ss = "abcde";
        for(char x : ss.toCharArray()){
            answer[x - 97] = max - nH.getOrDefault(x,0);
        }
        for(int i=0;i<5;i++) System.out.print(answer[i]);
        return answer;
    }
}