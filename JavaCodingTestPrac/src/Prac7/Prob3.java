package Prac7;

import java.util.ArrayList;

public class Prob3 {
    static int answer = 0;
    int[] ch;
    ArrayList<ArrayList<Integer>> graph;

    void DFS(int v) {

        for (int nv : graph.get(v)) {
            if (ch[nv] == 0) {
                ch[nv] = 1;
                DFS(nv);
            }
        }
    }

    int solution(int n, int[][] edges) {
        ch = new int[n + 1];
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] x : edges) {
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }

        for(int i=1; i<=n; i++){
            if(ch[i]==0){
                ch[i]=1;
                answer++;
                DFS(i);
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution(7, new int[][]{{1, 2}, {2, 3}, {1, 4}, {1, 5}}));
    }
}
