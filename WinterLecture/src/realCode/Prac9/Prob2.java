package realCode.Prac9;

import java.util.*;

public class Prob2 {
    public int solution(int[][] routes,int s,int e){
        HashMap<Integer,HashSet<Integer>> graph = new HashMap<>();
        int[] ch = new int[routes.length];
        Queue<Integer> Q = new LinkedList<>();
        int idx = 0;
        for(int[] x : routes){
            for(int i=0;i<x.length;i++){
                graph.putIfAbsent(x[i],new HashSet<>());
                graph.get(x[i]).add(idx);
            }
            idx++;
        }
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                Integer p = Q.poll();
                for(int x : graph.keySet()){
                    for(int y : graph.get(x)){
                        if(ch[y] == 1) continue;
                        ch[y] = 1;
                            for(int j=0;j<routes[y].length;j++) {
                                if(routes[y][j] == e) return L;
                                Q.add(routes[y][j]);
                            }
                    }
                }
            }
            L++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7, 9, 11}, {10, 3, 14}, {8, 5, 6}, {2,
                7, 13}, {10, 8, 2, 17}, {14, 5, 2, 12}},1,12));
    }
}
