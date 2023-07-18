package PracticeCode.Prac1;

import java.util.*;
public class Prob5 {
    int solution(int[][] fruit){
        int answer = 0;
        ArrayList<ArrayList<int[]>> fruits = new ArrayList<>();
        int n = fruit.length;
        for (int i = 0; i < n; i++) fruits.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            int idx = 0;
            for(int x : fruit[i]){
                fruits.get(i).add(new int[]{x,idx});
                idx++;
            }
            Collections.sort(fruits.get(i),(a,b) -> a[0] - b[0]);
        }
//        for(int i=0;i<n;i++){
//            for(int[] x : fruits.get(i)) System.out.print(x[0]+ " " + x[1]+ " ");
//            System.out.println();
//        }
        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i] == 1) continue;
            ArrayList<int[]> tmp = fruits.get(i);
            boolean flag = false;
            for(int j=0;j<n;j++){
                if(i != j && visited[j] == 0){
                    int x1 = fruits.get(j).get(0)[1];
                    int y1 = tmp.get(0)[1];
                    int x2 = fruits.get(j).get(1)[1];
                    int y2 = tmp.get(1)[1];
                    if(x1 != y1 && x1+1 != y1 && x2+1 != y2){
                        answer += fruits.get(j).get(0)[0] + 1;
                        answer += tmp.get(0)[0] + 1;
                        visited[i] = 1;
                        visited[j] = 1;
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
        }
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                answer += fruits.get(i).get(0)[0];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println();
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
