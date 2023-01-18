package Prac8;

import java.util.*;

public class Prob1 {
    int solution(int[] nums){
        int answer = 0;

        Arrays.sort(nums);
        int cnt = 1;
        for(int i=1;i<nums.length;i++){
            int tmp = nums[i] - nums[i - 1];
             if(tmp == 1) {
                cnt++;
                answer = Math.max(cnt, answer);
            }else{
                cnt = 1;
            }
        }

        answer = Math.max(cnt, answer);

        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
