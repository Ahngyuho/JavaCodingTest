package PracticeCode.Prac5;
import java.util.*;
public class Prob5 {
    public int solution(String s,int k) {
        int answer = Integer.MAX_VALUE;
        int left = 0;
        HashMap<Character,Integer> nH = new HashMap<>();
        for(int right = 0;right<s.length();right++){
            char c = s.charAt(right);
            nH.put(c,nH.getOrDefault(c,0) + 1);
            while(nH.size() == k){
                //왜 이 자리?
                //이 while 문이 동작하는 상황이 실제 정답을 찾을 수 있는 상황
                //해쉬 맵의 크기가 k 와 같다는 것은 해당 부분 문자열이 k 개의 알파벳을 들고 있다는 뜻이므로...
                answer = Math.min(answer,right - left + 1);
                char l = s.charAt(left);
                if(nH.get(l) == 1) nH.remove(l);
                else nH.put(l, nH.get(l) - 1);
                left++;
            }
            //이 자리가 아니라? 이 자리는 안 된다. 이 자리로 왔다는 것은 right 와 left 사이의 알파벳 문자가 k 가 아니라는 의미임
        }
        return answer;
    }
    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution("abacbbcdede" , 5));
        System.out.println(T.solution("acbbcdbbedeade", 4));
        System.out.println(T.solution("abcabcabcbebef", 5));
    }
}
