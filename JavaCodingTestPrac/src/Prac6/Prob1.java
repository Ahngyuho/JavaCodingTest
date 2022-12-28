package Prac6;

/*
* 재귀함수 1 2 3 4 5 순차출력
* */

import java.util.*;

public class Prob1 {
    Stack<Integer> pm = new Stack<>();
    void DFS(int n) {
//        if(n==0) return;
//
//        DFS(n-1);
//        System.out.print(n);

        if(n == 0) return;
        DFS(n - 1);
        pm.push(n);
    }

    int solution() {
        int answer = 0;
        for (int x : pm) {
            answer = answer * 10 + x;
        }

        return answer;
    }


    public static void main(String[] args) {
        Prob1 T = new Prob1();
        T.DFS(5);
        System.out.println(T.solution());
    }
}
