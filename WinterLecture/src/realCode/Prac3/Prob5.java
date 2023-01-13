package realCode.Prac3;

import java.util.*;

public class Prob5 {
    int solution(int[] nums,int m){
        Arrays.sort(nums);

        return binarySearch(nums, 0, nums.length, m) + 1;
    }
    int binarySearch(int[] nums,int start,int end,int target) {
            if (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) return binarySearch(nums, mid + 1, end, target);
            else if (nums[mid] > target) return binarySearch(nums, start, mid - 1, target);
            else if (nums[mid] == target) return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution(new int[]{23, 87, 65, 12, 57, 32, 99, 81},32));
    }
}
