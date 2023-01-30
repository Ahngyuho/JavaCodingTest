package PracticeCode.Prac5;
import java.util.*;
public class Prob3 {
    public int solution(int[] nums,int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int sum = 0;
        int answer = 0;
        for(int right = 0;right < n;right++){
            sum += nums[right];
            while(nums[right] * (right - left + 1) > sum + k){
                sum -= nums[left];
                left++;
            }
            answer = Math.max(answer,right - left + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution(new int[]{1, 2, 4, 7}, 5));
        System.out.println(T.solution(new int[]{5, 7, 8, 2, 9, 6, 3}, 10));
        System.out.println(T.solution(new int[]{6, 8, 1, 3, 12, 9, 10}, 10));
        System.out.println(T.solution(new int[]{15, 23, 11, 17, 34, 25, 55, 47, 15}, 30));
        System.out.println(T.solution(new int[]{9, 7, 12, 33, 21, 23, 33, 22, 34, 22, 33,
                22}, 33));
        System.out.println(T.solution(new int[]{-1, 1, 2, 4, 0, -2}, 6));
    }
}
