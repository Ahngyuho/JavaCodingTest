package realCode.Prac9;

import java.util.*;

public class Prob1 {
    int solution(int n,int[][] flights ,int s,int e,int k){
        int answer = 0;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] x : flights){
            graph.get(x[0]).add(new int[]{x[1],x[2]});
        }
        int[] cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{s,0});
        cost[s] = 0;
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                int[] x = Q.poll();
                int now = x[0];
                int nowCost = x[1];
                for(int[] y : graph.get(now)){
                    if(nowCost + y[1] < cost[y[0]] ) {
                        cost[y[0]] = nowCost + y[1];
                        Q.offer(new int[]{y[0],cost[y[0]]});
                    }
                }
            }
            L++;
            if(L > k) break;
        }
        answer = cost[e];
        return answer;
    }
    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution(5,new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3,
                80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}},0,3,1));
        System.out.println(T.solution(10,new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3,
                10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10},
        {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}},1,8,2));
    }
}
