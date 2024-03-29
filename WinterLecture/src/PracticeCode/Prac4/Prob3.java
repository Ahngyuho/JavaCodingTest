package PracticeCode.Prac4;
import java.util.*;
public class Prob3 {
    public int solution3(int[] plantTime, int[] growTime) {
        int answer = 0;
        int n = plantTime.length;
        int[][] list = new int[n][2];
        for(int i=0;i<n;i++){
            list[i][0] = plantTime[i];
            list[i][1] = growTime[i];
        }

        Arrays.sort(list,(a,b) -> b[1] - a[1]);
        int start = 0, end = 0;
        for (int[] x : list) {
            end = start + x[0] + x[1];
            answer = Math.max(answer, end);
            start += x[0];
        }
        return answer;
    }
    public int solution2(int[] plantTime,int[] growTime) {
        int n = plantTime.length;
        int[][] list = new int[n][2];
        for(int i=0;i<n;i++){
            list[i][0] = plantTime[i];
            list[i][1] = growTime[i];
        }
        Arrays.sort(list,(a,b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        int pT = 0;
        int gT = 0;
        for(int[] x : list){
            pT += x[0];
            gT = Math.max(gT,x[1] + pT);
        }
        return gT;
    }
    public int solution1(int[] planTime,int[] growTime) {
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

    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;
        int n= plantTime.length;
        int[][] list = new int[n][2];
        for(int i = 0; i < n; i++){
            list[i][0] = plantTime[i];
            list[i][1] = growTime[i];
        }
        Arrays.sort(list, (a, b) -> b[1] - a[1]);
        int start = 0, end = 0;
        for(int[] x : list){
            end = start + x[0] + x[1];
            answer = Math.max(answer, end);
            start += x[0];
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution2(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution2(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution2(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution2(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution2(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
