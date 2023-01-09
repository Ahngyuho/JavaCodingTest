package Prac4;

import java.util.*;


public class Prob5 {
    class Info{
        public int end;
        public int room;

        public Info(int end, int room) {
            this.end = end;
            this.room = room;
        }
    }
    int solution(int n, int[][] meetings) {
        int answer = 0;
        Arrays.sort(meetings,(a,b) -> a[0] - b[0]);

        PriorityQueue<Info> pQ = new PriorityQueue<>((a,b) -> a.end == b.end ? a.room - b.room : a.end - b.end);
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            ts.add(i);
        }
        int[] cnt = new int[meetings.length];

        for (int[] x : meetings) {
            boolean flag = false;
            int room;

            if(!ts.isEmpty() && !pQ.isEmpty()){
                room = ts.pollFirst();
                pQ.add(new Info(x[0],room));
                cnt[room]++;
            }else{
                while(pQ.peek().end > x[0]){
                    Info peek = pQ.poll();
                }
                Info peek = pQ.poll();
                if(peek.end > x[0]) {
                    int z = peek.end - x[0];
                    pQ.add(new Info(peek.end + z,peek.room));
                    cnt[peek.room]++;
                }else{
                    pQ.poll();
                    pQ.add(new Info(x[1], peek.room));
                    cnt[peek.room]++;
                }
            }




        }

        int max = 0;
        int max_idx = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max,cnt[i]);
            if(max < cnt[i]){
                max = cnt[i];
                max_idx = i;
            }
        }

        return max_idx;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution(2,new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
