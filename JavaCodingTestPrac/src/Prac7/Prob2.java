package Prac7;

import java.util.*;

public class Prob2 {
    int target,answer = 0;
    ArrayList<ArrayList<Integer>> graph;
    int[] ch;
    public void DFS(int v){
        if (v == target) answer++;
        else{
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n + 1];
        target = n;
        for (int[] x : edge) {
            graph.get(x[0]).add(x[1]);
        }

        ch[1] = 1;
        DFS(1);
        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution(5, new int[][]{{1, 2}, {1, 3}, {1, 4},
                {2, 1}, {2, 3}, {2, 5}, {3, 4}, {4, 2}, {4, 5}}));
    }
}
