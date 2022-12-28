package Prac6;

import java.util.*;

public class Prob4 {
    /*
    * 순열 구하기
    * 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열
        하는 방법을 모두 출력합니다.
    * 11 12 13 21 22 23 31 32 33
    * 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다
    * */
    int[] ch = new int[10];
    Stack<Integer> pm = new Stack<>();
    static int n,m;

    void DFS(int L) {
        if(L == m){
            for (int x : pm) {
                System.out.print(x+ " ");
            }
            System.out.println();
        }else{
            for (int i = 1; i <= n; i++) {
                pm.push(i);
                DFS(L + 1);
                pm.pop();
            }
        }
    }

    public static void main(String[] args) {
        n = 7;
        m = 7;
        Prob4 T = new Prob4();
        T.DFS(0);
    }
}
