package Prac3;

import java.util.*;
/*
* 괄호문자제거
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는
프로그램을 작성하세요.
▣ 입력설명
매개변수 s에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
▣ 출력설명
남은 문자만 반환 한다.
▣ 매개변수 형식 1
(A(BC)D)EF(G(H)(IJ)K)LM(N)
▣ 반환값 형식 1
EFLM
* */

public class Prob2 {

//    String solution(String s) {
//        String answer = "";
//        Stack<Character> stack = new Stack<>();
//
//        for (char x : s.toCharArray()) {
//            if (x == '(') {
//                stack.push('(');
//            } else if (x == ')') {
//                stack.pop();
//            }else{
//                if (stack.empty())
//                    answer += x;
//            }
//        }
//
//        return answer;
//    }

    String solution(String s) {
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for (char x : s.toCharArray()) {
            if(x == '(') stack.push('(');
            if (x == ')') {
                stack.pop();
            } else {
                if(stack.empty()) answer += x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
    }
}
