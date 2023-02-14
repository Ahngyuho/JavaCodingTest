package PracticeCode.Prac8;
import java.util.*;
public class Prob5 {
    //2023 02 12
    public int[] solution2(int[][] tasks) {
        int n = tasks.length;
        int[] answer = new int[n];
        int[][] prog = new int[n][3];
        for(int i=0;i<n;i++){
            prog[i][0] = tasks[i][0];
            prog[i][1] = tasks[i][1];
            prog[i][2] = i;
        }
        Arrays.sort(prog,(a,b) -> a[0] - b[0]);
        int j=0,curT = 0;
        PriorityQueue<int[]> wait = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        ArrayList<Integer> res = new ArrayList<>();
        while(j < n || !wait.isEmpty()){
            if(wait.isEmpty()){
                curT = Math.max(curT,prog[j][0]);
            }
            for(;j<n;j++){
                if(prog[j][0] <= curT) wait.offer(new int[]{prog[j][1],prog[j][2]});
                else break;
            }
            int[] p = wait.poll();
            curT += p[0];
            res.add(p[1]);
        }
        for(int i=0;i<n;i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
    //2023 02 11
    public int[] solution1(int[][] tasks) {
        int n = tasks.length;
        int[] answer = new int[n];
        int[][] prog = new int[n][3];
        for(int i=0;i<n;i++){
            prog[i][0] = tasks[i][0];
            prog[i][1] = tasks[i][1];
            prog[i][2] = i;
        }
        Arrays.sort(prog,(a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> ends = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int j = 0,curT = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(j < n || !ends.isEmpty()){
            if(ends.isEmpty()) {
                curT = Math.max(curT, prog[j][0]);
            }
            for(;j<n;j++) {
                if (prog[j][0] <= curT) ends.offer(new int[]{prog[j][1], prog[j][2]});
                else break;
            }
            int[] p = ends.poll();
            curT += p[0];
            res.add(p[1]);
        }
        for(int i=0;i<n;i++) answer[i] = res.get(i);
        return answer;
    }

    //2023 02 10
    public int[] solution(int[][] tasks){
        //int[] answer = {};
        int n = tasks.length;
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<int[]> programs = new LinkedList<>();
        for(int i = 0; i < n; i++){
            programs.add(new int[]{tasks[i][0], tasks[i][1], i});
        }
        programs.sort((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int curT = 0;
        while(!programs.isEmpty() || !pq.isEmpty()){
            if(pq.isEmpty()) curT = Math.max(curT, programs.peek()[0]);
            while(!programs.isEmpty() && programs.peek()[0] <= curT){
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1], x[2]});
            }
            int[] ex = pq.poll();
            curT = curT + ex[0];
            res.add(ex[1]);
        }

        int[] answer = new int[n];
        for(int i = 0; i < n; i++) answer[i] = res.get(i);

        return answer;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(Arrays.toString(T.solution2(new int[][]{{2, 3}, {1, 2}, {4, 2}, {3, 1}})));
        System.out.println(Arrays.toString(T.solution2(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution2(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution2(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
        System.out.println(Arrays.toString(T.solution2(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));

    }
}
