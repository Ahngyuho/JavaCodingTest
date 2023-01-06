package Prac3;

import java.util.*;

public class Prob6 {

    boolean isPossible(int[] nums,long num,int target){
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] / num;
            if(res >= target) return true;
        }

        return false;
    }

    long binarySearch(int[] nums,long start, long end, int target) {
        long height = 0;
        if(end >= start){
            long mid = (start + end) / 2;

            if(isPossible(nums,mid,target)) {
                height = mid;
                return binarySearch(nums, mid + 1, end, target);
            }
            else if(!isPossible(nums,mid,target)) return binarySearch(nums,start,mid - 1,target);
        }

        return height;
    }

    long solution(int[] nums, int n) {
        Arrays.sort(nums);
        return binarySearch(nums, 0, Integer.MAX_VALUE, n);
    }

    public static void main(String[] args) {
        Prob6 T = new Prob6();
        System.out.println(T.solution(new int[]{802, 743, 457, 539},11));
    }
}
