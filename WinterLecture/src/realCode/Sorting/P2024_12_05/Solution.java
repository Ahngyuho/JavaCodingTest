package realCode.Sorting.P2024_12_05;

import java.util.Arrays;

public class Solution {
    public int binarySearchRecur(int[] nums, int target,int left, int right){
        if(left > right) return -1;

        //정수 오버플로 방지 left + (right - left)
        int mid = left + (right - left) / 2;

        if(nums[mid] == target) return mid + 1;
        else if(nums[mid] > target) return binarySearchRecur(nums,target,left,mid-1);
        else return binarySearchRecur(nums, target, mid + 1, right);
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);

        while( left <= right ) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid + 1;

            if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = new int[]{23, 87, 65, 12, 57, 32, 99, 81};
        Arrays.sort(arr);
        System.out.println(T.binarySearchRecur((arr), 32,0,arr.length-1));
    }


}
