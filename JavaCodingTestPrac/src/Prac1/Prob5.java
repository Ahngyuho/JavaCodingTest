package Prac1;
import java.util.*;
public class Prob5 {
    //01 29
    public char solution1(String s) {
        char answer = ' ';
        char[] alpha = new char[5];
        int tmp = 0;
        for(char x : s.toCharArray()){
            alpha[x - 65]++;
            if(tmp < alpha[x - 65]){
                answer = x;
                tmp = alpha[x - 65];
            }
        }
        return answer;
    }

    //01 29
    public char solution(String s) {
        char answer = ' ';
        HashMap<Character,Integer> nH = new HashMap<>();
        for(char x : s.toCharArray()) nH.put(x,nH.getOrDefault(x,0) + 1);
        int max = Integer.MIN_VALUE;
        for(char x : nH.keySet()){
            if(max < nH.get(x)) {
                max = nH.get(x);
                answer = x;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution("BACBACCACCBDEDE"));
        System.out.println(T.solution("AAAAABBCCDDDD"));
    }
}
