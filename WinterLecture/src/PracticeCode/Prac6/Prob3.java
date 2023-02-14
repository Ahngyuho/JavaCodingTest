package PracticeCode.Prac6;
import java.util.*;
public class Prob3 {
    int answer;
    int len;
    LinkedList<Character> list = new LinkedList<>();
    String S;
//    Stack<String> stack = new Stack<>();
    public void DFS(int L,int sub){
        if(len == list.size()){
//            for(String x : stack) System.out.print(x + " ");
//            System.out.println();
            answer++;
        }else{
            if(S.charAt(sub) == '0') return;
            if(sub <= len - 1){
                list.addLast(S.charAt(sub));
//                stack.push(S.substring(sub, sub + 1));
                DFS(L+1,sub+1);
//                stack.pop();
                list.pollLast();
            }
            if(sub <= len - 2){
                if(Integer.parseInt(S.substring(sub,sub+2)) > 26) return;
                list.addLast(S.charAt(sub));
                list.addLast(S.charAt(sub+1));
//                stack.push(S.substring(sub,sub+2));
                DFS(L+2,sub+2);
//                stack.pop();
                list.pollLast();
                list.pollLast();
            }
        }
    }
    public int solution(String s) {
        answer = 0;
        S = s;
        len = s.length();
        DFS(0,0);
        return answer;
    }
//    LinkedList<String> tmp;
//    int answer;
//    public void DFS(int start,String s){
//        if(start == s.length()){
//            answer++;
//        }else{
//            for(int i=start;i<s.length();i++){
//                if(start < s.length() && s.charAt(start) == '0') return;
//                String num = s.substring(start,i+1);
//                if(Integer.parseInt(num) > 26) return;
//                tmp.add(num);
//                DFS(i+1,s);
//                tmp.pollLast();
//            }
//        }
//    }
//    public int solution(String s) {
//        answer = 0;
//        tmp = new LinkedList<>();
//        return answer;
//    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}
