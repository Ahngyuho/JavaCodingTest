package realCode.Prac8;

import java.util.*;

public class Prob5 {
    int[] solution(int[][] tasks) {
        int[] answer = new int[tasks.length];
        LinkedList<int[]> list = new LinkedList<>();
        PriorityQueue<int[]> pQ = new PriorityQueue<>();

        int idx = 0;
        for (int[] x : tasks) {
            list.add(new int[]{x[0], x[1],idx});
        }
        int curT = 0;
        int ans_idx = 0;
        while(!pQ.isEmpty() && !list.isEmpty()){
            if(pQ.isEmpty()) curT = Math.max(curT,list.peek()[0]);
            while(curT <= list.peek()[0] && !list.isEmpty()){
                int[] ints = list.pollFirst();
                pQ.offer(new int[]{ints[1],ints[2]});
            }
            int[] e = pQ.poll();
            answer[ans_idx] = e[1];
            curT += e[0];
            ans_idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution(new int[][]{{2, 3}, {1, 2}, {4, 2}, {3, 1}}));
    }
}
