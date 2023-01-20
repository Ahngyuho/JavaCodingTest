package realCode.Prac8;

import java.util.*;

public class Prob3 {

    String solution(String s){
        String answer = "";
        Stack<String> stack = new Stack<>();
        for(char x : s.toCharArray()){
            if(x == ')'){
                String tmp = "";
                while(!stack.isEmpty()){
                    String t = stack.pop();
                    if(t.equals("(")){
                        String num = "";
                        while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                            num = stack.pop() + num;
                        }
                        int ss;
                        if(num.equals("")) ss = 1;
                        else ss = Integer.parseInt(num);
                        String res = "";
                        for(int i=0;i<ss;i++) res += tmp;
                        stack.push(res);
                        break;
                    }else tmp = t + tmp;
                }
            }
            else stack.push(String.valueOf(x));
        }
        for(String x : stack) {
            System.out.println(x);
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("3(a2(b))ef"));
    }
}
