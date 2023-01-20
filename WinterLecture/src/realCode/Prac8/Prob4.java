package realCode.Prac8;

import java.util.*;

public class Prob4 {
    int getTime(String x){
        int hour = Integer.parseInt(x.split(":")[0]);
        int minute = Integer.parseInt(x.split(":")[1]);
        return hour * 60 + minute;
    }
    int solution(int[] laser,String[] enter){
        int answer = 0;
        Queue<int[]> Q = new LinkedList<>();
        ArrayList<int[]> tmp = new ArrayList<>();

        for(String x : enter){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            tmp.add(new int[]{getTime(a),Integer.parseInt(b)});
        }
        int idx = 1;
        int n = tmp.size();
        int fT = tmp.get(0)[0];
        for(int i = tmp.get(0)[0];i<=1200;i++){
            if(i == tmp.get(idx)[0] && idx < n) {
                if(Q.isEmpty() && tmp.get(idx)[0] > fT) fT = tmp.get(idx)[0];
                Q.offer(new int[]{tmp.get(idx)[0], tmp.get(idx)[1]});
                idx++;
            }
            if(!Q.isEmpty() && i == fT) {
                Q.poll();
                fT += laser[tmp.get(idx)[1]];
            }
            answer = Math.max(answer,Q.size());
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution(new int[]{30, 20, 25, 15},new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3","11:10 2"}));
    }
}
