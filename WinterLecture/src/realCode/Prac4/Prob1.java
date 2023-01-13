package realCode.Prac4;

import java.util.*;

public class Prob1 {
    int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);

        int lt = 0;
        int rt = nums.length - 1;

        while (lt <= rt) {
            if(nums[lt] + nums[rt] > 5){
                rt--;
                answer++;
            }else{
                rt--;
                lt++;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
    }
}
