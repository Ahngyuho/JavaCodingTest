package Prac3;

import java.util.*;

public class Prob5 {
//    String solution(String s, int m) {
//        String answer = "";
//        Stack<Integer> stack = new Stack<>();
//
//        for (char x : s.toCharArray()) {
//            System.out.println((int)x);
//            if(stack.empty() || stack.peek() > x) stack.push(x - 48);
//            else{
//                while (!stack.empty() && stack.peek() < (x-48) && m > 0) {
//                    stack.pop();
//                    m--;
//                }
//                stack.push(x - 48);
//            }
//        }
//
//        for(int x : stack) answer += x;
//        return answer;
//    }

    public String solution(String s, int m) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        for (int x : s.toCharArray()) {
            while (!stack.empty() && m > 0 && stack.peek() < (x - 48)) {
                stack.pop();
                m--;
            }
            stack.push(x - 48);
        }

        while (m > 0) {
            stack.pop();
            m--;
        }

        for (int x : stack) answer += x;
        return answer;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution("5276823", 3));
    }
}
