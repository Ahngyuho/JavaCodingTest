package realCode.Prac9;

import java.util.*;

public class Prob5 {
    public String solution(String[] cities,String[] roads){
        int n = cities.length;
        int[][] dist = new int[n][n];
        HashMap<String,Integer> node = new HashMap<>();
        int idx = 0;
        for(String x : cities){
            node.put(x,idx);
            idx++;
        }
        for(int i = 0;i<n;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) dist[i][j] = 0;
            }
        }
        for(String x : roads){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            int c = Integer.parseInt(x.split(" ")[2]);
            dist[node.get(a)][node.get(b)] = c;
            dist[node.get(b)][node.get(a)] = c;
        }
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]) dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        for(int i=0;i<n;i++){
            for (int j = 0; j < n; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        return "";
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution(new String[]{"rome", "busan",
                "daegu"},new String[]{"rome busan 1",
                "rome daegu 1",
                "busan daegu 2"}));
    }
}
