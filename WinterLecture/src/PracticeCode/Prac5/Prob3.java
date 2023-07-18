package PracticeCode.Prac5;
import java.util.*;
public class Prob3 {
    public int solution4(int[] nums, int k) {
        int answer = 0;
        Arrays.sort(nums);
        int left = 0;
        int sum = 0;
        for(int right=0;right<nums.length;right++){
            sum += nums[right];
            while((right - left + 1) * right > sum + k){
                sum -= nums[left];
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
    public int solution3(int[] nums,int k) {
        int answer = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0,sum = 0;
        for(int right = 0;right < n;right++){
            sum += nums[right];
            while((right - left + 1) * nums[right] - sum > k){
                sum -= nums[left];
                left++;
            }
            answer = Math.max(answer,right - left + 1);
        }
        return answer;
    }
    public int solution2(int[] nums,int k) {
        int answer = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        int lt = 0;
        for(int rt = 0;rt<n;rt++){
            sum += nums[rt];
            while((nums[rt] * (rt - lt + 1)) - sum > k){
                sum -= nums[lt];
                lt++;
            }
            answer = Math.max(answer,rt - lt + 1);
        }
        return answer;
    }
    public int solution1(int[] nums,int k) {
        int answer = 0;
        Arrays.sort(nums);
        int lt = 0;
        int sum = 0;
        for(int rt = 0;rt<nums.length;rt++){
            sum += nums[rt];
            while(nums[rt] * (rt - lt + 1) > sum + k){
                sum -= nums[lt];
                lt++;
            }
            answer = Math.max(answer,rt - lt + 1);
        }
        return answer;
    }
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
        System.out.println(T.solution4(new int[]{1, 2, 4, 7}, 5));
        System.out.println(T.solution4(new int[]{5, 7, 8, 2, 9, 6, 3}, 10));
        System.out.println(T.solution4(new int[]{6, 8, 1, 3, 12, 9, 10}, 10));
        System.out.println(T.solution4(new int[]{15, 23, 11, 17, 34, 25, 55, 47, 15}, 30));
        System.out.println(T.solution4(new int[]{9, 7, 12, 33, 21, 23, 33, 22, 34, 22, 33,
                22}, 33));
        System.out.println(T.solution4(new int[]{-1, 1, 2, 4, 0, -2}, 6));
    }
}
