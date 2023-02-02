package PracticeCode.Prac6;
import java.util.*;
public class Prob3 {
    LinkedList<String> tmp;
    int answer;
    public void DFS(int start,String s){
        if(start == s.length()){
            answer++;
        }else{
            for(int i=start;i<s.length();i++){
                if(start < s.length() && s.charAt(start) == '0') return;
                String num = s.substring(start,i+1);
                if(Integer.parseInt(num) > 26) return;
                tmp.add(num);
                DFS(i+1,s);
                tmp.pollLast();
            }
        }
    }
    public int solution(String s) {
        answer = 0;
        tmp = new LinkedList<>();
        return answer;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution("25114"));
    }
}
