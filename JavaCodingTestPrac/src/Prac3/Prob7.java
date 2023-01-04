package Prac3;

import java.util.*;

public class Prob7 {
    public ArrayList<String> solution(String need, String[] plans) {
        ArrayList<String> answer = new ArrayList<>();
        for (String s : plans) {
            Queue<Character> Q = new LinkedList<>();
            for(char x : need.toCharArray()) Q.offer(x);
            for (char x : s.toCharArray()) {
                if (x == Q.peek()) Q.poll();
                if(Q.isEmpty()) break;
            }

            if(Q.isEmpty()) answer.add("YES");
            else answer.add("NO");
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob7 T = new Prob7();
        System.out.println(T.solution("CBA",new String[]{"CBDAGE" ,"FGCDAB","CTSBDEA"}));
    }
}
