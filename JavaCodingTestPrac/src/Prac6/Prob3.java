package Prac6;

import java.util.Stack;

public class Prob3 {
//    void DFS(int v) {
//        if(v>7) return;
//        else{
//            System.out.println(v + " ");
//            DFS(v*2);
//            DFS(v*2 + 1);
//        }
//    }
//
//    public static void main(String[] args) {
//        Prob3 T = new Prob3();
//        T.DFS(1);
//    }
    Stack<Integer> stack = new Stack<>();
    int[] ch = new int[N+1];
    static int N=10;
    static int M=5;

    public void DFS(int L) {
        if (L == M) {
            for(int x : stack) System.out.print(x + " ");
            System.out.println();
        }else{
            for (int i = 1; i <= M; i++) {
                if (ch[i] == 0) {
                    stack.push(i);
                    ch[i] = 1;
                    DFS(L + 1);
                    ch[i] = 0;
                    stack.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        T.DFS(0);
    }
}
