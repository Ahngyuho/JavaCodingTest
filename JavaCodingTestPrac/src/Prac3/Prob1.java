package Prac3;
/*
* 올바른 괄호
  괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
  (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
* */

import java.util.Stack;

public class Prob1 {
//    String solution(String s) {
//        String answer = "YES";
//
//        Stack<Character> stack = new Stack<>();
//
//        for (char x : s.toCharArray()) {
//            if(x == '(') stack.push('(');
//            else{
//                if(stack.empty()) return "NO";
//                stack.pop();
//            }
//        }
//
//        if(!stack.isEmpty()) return "NO";
//        return answer;
//    }

    String solution(String s) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == '(') {
                stack.push('(');
            } else {
                if(stack.empty()) return "NO";
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return "NO";
        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution("(()(()))(()"));
    }
}
