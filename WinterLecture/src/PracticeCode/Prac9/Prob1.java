package PracticeCode.Prac9;
import java.util.*;
public class Prob1 {
    //01 29
    public int solution(int n,int[][] flights,int s,int e,int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{s,0});
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] x : flights){
            graph.get(x[0]).add(new int[]{x[1],x[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                int[] cur = Q.poll();
                int now = cur[0];
                int nowCost = cur[1];
                for(int[] x : graph.get(cur[0])){
                    int next = x[0];
                    int nextCost = x[1];
                    if(dist[next] > nowCost + nextCost){
                        dist[next] = nowCost + nextCost;
                        Q.offer(new int[]{next,dist[next]});
                    }
                }
            }
            L++;
            if(L > k) return dist[e] == Integer.MAX_VALUE ? -1 : dist[e];
        }
        return -1;
    }
    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution(5,new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3,
                80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}},0,3,1));
        System.out.println(T.solution(4,new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}},0,3,0));
        System.out.println(T.solution(8,new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2,
                10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}},1,7,2));
        System.out.println(T.solution(10,new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3,
                10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10},
                {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}},1,8,2));
    }
}
