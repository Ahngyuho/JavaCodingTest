package Prac3;

import java.util.Arrays;

public class Prob7 {
    boolean isPossible(int[] nums,long dist,int c){
        c--;
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[pos] >= dist) {
                pos = i;
                c--;
            }
            if(c == 0) return true;
        }

        return false;
    }

    long solution(int[] nums, int c) {
        Arrays.sort(nums);

        long height = 0;
        long start = 1;
        long end = nums[nums.length-1];

        while (end >= start) {
            long mid = (start + end) / 2;
            if(isPossible(nums,mid,c)){
                height = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return height;
    }

    public static void main(String[] args) {
        Prob7 T = new Prob7();
        System.out.println(T.solution(new int[]{5, 12, 34, 16, 18, 23, 29, 15},7));
    }
}
