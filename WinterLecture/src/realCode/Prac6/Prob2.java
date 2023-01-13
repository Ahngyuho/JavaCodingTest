package realCode.Prac6;

import java.util.*;

public class Prob2 {
    LinkedList<String> list = new LinkedList<>();
    ArrayList<String> tmp = new ArrayList<>();

    public void DFS(int L,String s){
        if(list.size() > 4) return;
        if(list.size() == 4 && L == s.length()){
            String ss = "";
            for(int i=0;i<4;i++) ss += (list.pollFirst() + ".");

            tmp.add(ss.substring(0,ss.length() - 1));
        }else{
            for(int i=L;i<s.length();i++){
                if(s.charAt(L) == '0' && i > L) return;
                String ss = s.substring(L,i+1);
                if(Integer.parseInt(ss) <= 255){
                    list.add(ss);
                    DFS(i + 1,s);
                    list.pollLast();
                }else return;
            }
        }
    }

    String[] solution(String s){
        String[] answer;

        DFS(0,s);

        answer = new String[tmp.size()];

        for(int i=0;i<answer.length;i++){
            System.out.println(tmp.get(i));
            answer[i] = tmp.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution("2025505"));
    }
}
