package PracticeCode.Prac3;

import java.util.*;

public class Prob1 {

    public int[] solution(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[][] tmp = new int[n][2];
        for(int i=0;i<n;i++){
            int b = nums[i];
            int cnt = 0;
            while(b > 0){
                if(b % 2 == 1) cnt++;
                b /= 2;
            }
            tmp[i][0] = nums[i];
            tmp[i][1] = cnt;
        }
        Arrays.sort(tmp,(a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for(int i=0;i<n;i++) answer[i] = tmp[i][0];
        return answer;
    }
    public static void main(String[] args){
        Prob1 T = new Prob1();
        for(int x : T.solution(new int[]{5, 6, 7, 8, 9})){
            System.out.print(x + " ");
        }
        System.out.println();
        for(int x : T.solution(new int[]{5, 4, 3, 2, 1})){
            System.out.print(x + " ");
        }
        System.out.println();
        for(int x : T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})){
            System.out.print(x + " ");
        }
    }
}
