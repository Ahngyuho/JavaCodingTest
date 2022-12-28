package Prac6;

import java.util.*;

public class Prob6 {
    static int n,m;

    Stack<Integer> combi = new Stack<>();

    void DFS(int L,int s) {
        if (m == L) {
            for (int x : combi) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                combi.push(i);
                DFS(L + 1, i + 1);
                combi.pop();
            }
        }
    }

    public static void main(String[] args) {
        Prob6 T = new Prob6();
        n = 4;
        m = 2;
        T.DFS(0, 1);
    }
}
