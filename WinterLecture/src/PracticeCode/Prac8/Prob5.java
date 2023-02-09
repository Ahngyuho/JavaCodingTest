package PracticeCode.Prac8;
import java.util.*;
public class Prob5 {
    public int[] solution(int[][] tasks) {
        int n = tasks.length;
        int[] answer = new int[n];
        int[][] tmp = new int[n][3];
        for(int i=0;i<n;i++) {
            tmp[i][0] = tasks[i][0];
            tmp[i][1] = tasks[i][1];
            tmp[i][2] = i;
        }
        Arrays.sort(tmp,(a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int[] x : tmp) System.out.println(x[0] + " " + x[1] + " " + x[2]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        pq.offer(new int[]{tmp[0][0],tmp[0][1],0});
        int curTime = 0;
        int pos = 1;
        int idx = 0;
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            curTime += p[1];
            while(pos<n && tmp[pos][0] <= curTime){
                pq.offer(new int[]{tmp[pos][0],tmp[pos][1],pos});
                pos++;
            }
            answer[idx] = p[2];
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
    }
}
