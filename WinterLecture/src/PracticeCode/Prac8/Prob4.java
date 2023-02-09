package PracticeCode.Prac8;
import java.util.*;
public class Prob4 {
    public int solution1(int[] laser,String[] enter) {
        int answer = 0;
        int n = enter.length;
        int[][] enters = new int[n][2];
        for(int i=0;i<n;i++){
            String s = enter[i];
            enters[i][0] = getTime(s.split(" ")[0]);
            enters[i][1] = Integer.parseInt(s.split(" ")[1]);
        }
        int eT = enters[0][0];
        Queue<Integer> Q = new LinkedList<>();
        int i = eT;
        int idx = 0;
        for(;i<=1200;i++){
            if(Q.isEmpty() && idx < n && eT <= enters[idx][0]) eT = enters[idx][0];
            if(idx < n && enters[idx][0] == i) {
                Q.offer(enters[idx][1]);
                idx++;
            }
            if(eT == i && !Q.isEmpty()) {
                eT += laser[Q.poll()];
            }
            answer = Math.max(Q.size(),answer);
        }
        return answer;
    }
    public int getTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + min;
    }
    public int solution(int[] laser, String[] enter) {
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];
        for(int i=0;i<n;i++){
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }
        Queue<Integer> Q = new LinkedList<>();
        int pos = 1;
        int endTime = inList[0][0];
        Q.offer(inList[0][1]);
        for(int i = endTime;i<=1200;i++){
            //대기자가 들어가야 할 시간이 되었을 때
            if(pos < n && i == inList[pos][0]){
                //대기자가 없는 경우 +
                if(Q.isEmpty() && inList[pos][0] > endTime) endTime = inList[pos][0];
                Q.offer(inList[pos][1]);
                pos++;
            }
            if(i == endTime && !Q.isEmpty()){
                int idx = Q.poll();
                endTime += laser[idx];
            }
            answer = Math.max(Q.size(),answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution1(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution1(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution1(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1",
                "11:40 1"}));
    }
}
