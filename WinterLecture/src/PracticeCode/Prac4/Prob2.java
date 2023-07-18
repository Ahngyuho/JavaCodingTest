package PracticeCode.Prac4;
import java.util.*;
public class Prob2 {
    public int solution2(int[][] meetings){
        //시작 끝 시간을 따로 분리
        //시작 시간이면 회의실 배정 (cnt++) 끝 시간이면 회의실 삭제 (cnt--)
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] x : meetings){
            list.add(new int[]{x[0],2});
            list.add(new int[]{x[1],1});
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int answer = 0, cnt = 0;
        for(int[] x : list){
            if(x[1] == 2) cnt++;
            cnt--;
            answer = Math.max(cnt, answer);
        }

        return answer;
    }
    public int solution1(int[][] meetings) {
        int answer = 0;
        Arrays.sort(meetings,(a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for(int[] x : meetings){
            while(!pq.isEmpty() && pq.peek() <= x[0]){
                pq.poll();
            }
//            if(pq.isEmpty() || x[0] < pq.peek())
            pq.offer(x[1]);
            answer = Math.max(pq.size(),answer);
        }
        return answer;
    }
    public int solution(int[][] meetings) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] x : meetings){
            list.add(new int[]{x[0], 0});
            list.add(new int[]{x[1], 1});
        }
        Collections.sort(list,(a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int cnt = 0;
        for(int[] x : list){
//            System.out.println(x[0] + " " + x[1]);
            if(x[1] == 0) cnt++;
            else cnt--;
            answer = Math.max(cnt,answer);
        }
        return answer;
    }
    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}}));
        System.out.println(T.solution1(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution1(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
