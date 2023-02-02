package PracticeCode.Prac2;
import java.util.*;
public class Prob1 {
    //2023 02 01
    public int[] solution1(String s) {
        int[] answer = new int[5];
        int[] alpha = new int[5];
        for(char x : s.toCharArray()){
            alpha[x - 97]++;
        }
        int max = 0;
        int max_idx = 0;
        for(int i=0;i<5;i++){
            if(max < alpha[i]){
                max = alpha[i];
                max_idx = i;
            }
        }
        for(int i=0;i<5;i++){
            answer[i] = max - alpha[i];
        }
        return answer;
    }
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

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(Arrays.toString(T.solution1("aaabc")));
        System.out.println(Arrays.toString(T.solution1("aabb")));
        System.out.println(Arrays.toString(T.solution1("abcde")));
    }
}