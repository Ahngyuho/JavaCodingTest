package realCode.Prac3;

import java.util.*;

public class Prob6 {
    long answer;
    boolean isPossible(int[] nums,long num,int target){
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] / num;
            if(res >= target) return true;
        }

        return false;
    }

    long solution(int[] nums, int n) {
        Arrays.sort(nums);

        long height = 0;
        long start = 1;
        long end = nums[nums.length-1];

        while (end >= start) {
            long mid = (start + end) / 2;
            if(isPossible(nums,mid,n)){
                height = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return height;
    }

    public static void main(String[] args) {
        Prob6 T = new Prob6();
        System.out.println(T.solution(new int[]{93, 97, 93, 53, 75, 57, 85, 89, 67},30));
    }
}
