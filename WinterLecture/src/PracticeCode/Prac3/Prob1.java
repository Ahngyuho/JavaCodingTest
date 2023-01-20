package PracticeCode.Prac3;

import java.util.*;

public class Prob1 {
    
    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length];
        int[][] res = new int[nums.length][2];
        for(int i = 0;i < nums.length;i++){
            int tmp = nums[i];
            while(tmp > 0){
                res[i][1] += (tmp % 2);
                tmp /= 2;
            }
            res[i][0] = nums[i];
        }

        Arrays.sort(res,(a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < nums.length; i++) {
            answer[i] = res[i][0];
        }
        return answer;
    }
    public static void main(String[] args){
        Prob1 T = new Prob1();
        for(int x : T.solution(new int[]{5, 6, 7, 8, 9})){
            System.out.print(x + " ");
        }
    }
}
