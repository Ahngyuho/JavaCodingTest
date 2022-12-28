package Prac5;

import java.util.Arrays;

public class Prob1 {
    int solution(int[] nums, int k) {
        int answer = 0;

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            if(nums[left] + nums[right] >= k) {
                left++;
                right--;
                answer++;
            }
            else right--;
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        int[] arr = new int[]{90, 50, 70, 100, 60};
        System.out.println(T.solution(arr,140));
    }
}
