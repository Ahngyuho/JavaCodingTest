package PracticeCode.Prac9;
import java.util.*;
public class Prob2 {
    public int solution3(int[][] routes,int s,int e){
        int answer = 0;
        int n = routes.length;
        HashMap<Integer, HashSet<Integer>> station = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for(int x : routes[i]){
                station.putIfAbsent(x, new HashSet<>());
                station.get(x).add(i);
            }
        }
        int[] visitedLine = new int[n];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int cur = Q.poll();
                for (int line : station.get(cur)) {
                    if (visitedLine[line] == 0) {
                        visitedLine[line] = 1;
                        for (int stop : routes[line]) {
                            if(stop == e) return L;
                            Q.offer(stop);
                        }
                    }
                }
            }
            L++;
        }

        return visitedLine[e] == 0 ? -1 : answer;
    }
    //2023 02 12
    public int solution2(int[][] routes,int s,int e) {
        HashMap<Integer,HashSet<Integer>> lineInfo = new HashMap<>();
        int n = routes.length;
        for(int i=0;i<n;i++){
            for(int x : routes[i]){
                lineInfo.putIfAbsent(x,new HashSet<>());
                lineInfo.get(x).add(i);
            }
        }
        int L = 0;
        int[] visited = new int[n];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                int p = Q.poll();
                for(int x : lineInfo.get(p)){
                    if(visited[x] == 0){
                        for(int y : routes[x]){
                            if(y == e) return L;
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
    //01 29
    public int solution1(int[][] routes,int s,int e) {
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

    public int solution(int[][] routes, int s, int e){
        int answer = 0;
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length;
        for(int i = 0; i < n; i++){
            for(int x : routes[i]){
                graph.putIfAbsent(x, new HashSet<Integer>());
                graph.get(x).add(i);
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        int[] ch = new int[n];
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int curStop = Q.poll();
                for(int line : graph.get(curStop)){
                    if(ch[line] == 1) continue;
                    ch[line] = 1;
                    for(int stop : routes[line]){
                        if(stop == e) return L;
                        Q.offer(stop);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution3(new int[][]{{1, 3, 5, 7, 9, 11}, {10, 3, 14}, {8, 5, 6}, {2,
                7, 13}, {10, 8, 2, 17}, {14, 5, 2, 12}},1,12));
        System.out.println(T.solution3(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14,
                15}, {2, 14, 16}},1,14));
        System.out.println(T.solution3(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}},9,19));
        System.out.println(T.solution3(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}},1,10));

    }
}
