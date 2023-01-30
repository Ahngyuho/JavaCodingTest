package PracticeCode.Prac9;
import java.util.*;
public class Prob2 {
    //01 29
    public int solution(int[][] routes,int s,int e) {
        HashMap<Integer,ArrayList<Integer>> nH = new HashMap<>();
        int n = routes.length;
        for(int i=0;i<n;i++) {
            for(int x : routes[i]){
                nH.putIfAbsent(x,new ArrayList<>());
                nH.get(x).add(i);
            }
        }
        int[] visited = new int[n];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                int p = Q.poll();
                for(int x : nH.get(p)){
                    if(visited[x] == 0) {
                        for(int y : routes[x])
                        {if(y == e) return L;
                            Q.offer(y);
                        }

                        visited[x] = 1;
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
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14,
                15}, {2, 14, 16}},1,14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}},9,19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}},1,10));

    }
}
