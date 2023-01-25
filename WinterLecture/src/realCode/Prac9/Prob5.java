package realCode.Prac9;

import java.util.*;

public class Prob5 {
    public String solution(String[] cities,String[] roads,String[] cars,String customers){
        int n = cities.length;
        int[][] dist = new int[n][n];
        HashMap<String,Integer> node = new HashMap<>();
        int idx = 0;
        for(String x : cities){
            node.put(x,idx);
            idx++;
        }
        for(int i = 0;i<n;i++) Arrays.fill(dist[i],1000000000);
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
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        for(String x : cars){
            String a = x.split(" ")[0];
            int b = Integer.parseInt(x.split(" ")[1]);
            int c = Integer.parseInt(x.split(" ")[2]);
            list.get(node.get(a)).add(new int[]{b, c});
        }
        for (int i = 0; i < n; i++) list.get(i).sort((a, b) -> a[0] - b[0]);
        int s = node.get(customers.split(" ")[0]);
        int e = node.get(customers.split(" ")[1]);
        int g = Integer.parseInt(customers.split(" ")[2]);
        int minCost = Integer.MAX_VALUE;
        int num = 0;
        for(int i=0;i<n;i++){
            int tmp = dist[i][s] + dist[s][e];
            if(tmp >= 100000000) continue; //해당 업체는 i->s -> e로 가는 경로가 없는 것
            //int idx = lower_bound(list.get(i),g);
            if(idx >= list.get(i).size()) continue;
            int cost = list.get(i).get(idx)[1];
            cost *= idx;
            if(cost < minCost){
                minCost = cost;
                num = i;
            }
            else if(cost == minCost && cities[i].compareTo(cities[num]) < 0) num = i;
        }
        //int answer = cities[num];
        return "";
    }
    public int lower_bound(ArrayList<int[]> list,int target){
        int left = 0;
        int right = list.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid)[0] > target) left = mid + 1;
        }
        return 1;
    }
    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution(new String[]{"rome", "busan",
                "daegu"},new String[]{"rome busan 1",
                "rome daegu 1",
                "busan daegu 2"},new String[]{"rome 50 10",
                "busan 100 20",
                "daegu 40 8",
                "rome 80 14",
                "rome 30 8"},"busan daegu 40"));
    }
}
