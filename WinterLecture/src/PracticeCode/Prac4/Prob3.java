package PracticeCode.Prac4;
import java.util.*;
public class Prob3 {
    public int solution(int[] planTime,int[] growTime) {
        int answer = 0;
        ArrayList<int[]> tmp = new ArrayList<>();
        int n = planTime.length;
        for(int i = 0;i<n;i++){
            tmp.add(new int[]{planTime[i],growTime[i]});
        }
        Collections.sort(tmp,(a,b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        for(int[] x : tmp) System.out.println(x[0] + " " + x[1]);
        int pTime = 0;
        for(int[] x : tmp){
            pTime += x[0];
            if(pTime + x[1] > answer) answer = pTime + x[1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
    }
}
