package PracticeCode.Prac4;
import java.util.*;
public class Prob5 {
    public int solution1(int n,int[][] meetings) {
        TreeSet<Integer> res = new TreeSet<>();
        for(int i=0;i<n;i++) res.add(i);
        PriorityQueue<int[]> ends = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[] tmp = new int[n];
        for(int[] m : meetings){
            while(!ends.isEmpty() && ends.peek()[0] <= m[0]) {
                res.add(ends.poll()[1]);
            }
            if(!res.isEmpty()){
                int p = res.pollFirst();
                tmp[p]++;
                ends.offer(new int[]{m[1],p});
            }else{
                int[] p = ends.poll();
                tmp[p[1]]++;
                ends.offer(new int[]{p[0] + m[1] - m[0],p[1]});
            }
        }
        int max_idx = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            if(max < tmp[i]){
                max = tmp[i];
                max_idx = i;
            }
        }
        return max_idx;
    }
    public int solution(int n,int[][] meetings) {
        Arrays.sort(meetings,(a,b) -> a[0] - b[0]);
        TreeSet<Integer> rooms = new TreeSet<>();
        for(int i=0;i<n;i++) rooms.add(i);
        PriorityQueue<int[]> ends = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] res = new int[n];
        for(int[] m : meetings){
            while(!ends.isEmpty() && ends.peek()[0] <= m[0]) rooms.add(ends.poll()[1]);
            if(!rooms.isEmpty()){
                int e = rooms.pollFirst();
                res[e]++;
                ends.offer(new int[]{m[1],e});
            }else{
                int[] e = ends.poll();
                res[e[1]]++;
                ends.offer(new int[]{e[0] + m[1] - m[0],e[1]});
            }
        }
        int max = 0;
        int max_idx = 0;
        for(int i=0;i<n;i++){
            if(max < res[i]){
                max = res[i];
                max_idx = i;
            }
        }
        return max_idx;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution1(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution1(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution1(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution1(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14},{15, 20}}));
    }
}
