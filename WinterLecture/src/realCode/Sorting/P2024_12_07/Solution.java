package realCode.Sorting.P2024_12_07;

import java.util.*;
class Solution {
    public int Count(int[] nums, int dist){
        int cnt = 1;
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - prev >= dist){
                cnt++;
                prev = nums[i];
            }
        }
        return cnt;
    }
    public int solution(int[] nums, int c){
        int answer = 0;
        Arrays.sort(nums);
        int left = 1;
        int right = nums[nums.length - 1];
        while(left <= right){
            int mid = (left + right) / 2;
            if(Count(nums, mid) >= c){
                answer = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{5, 12, 34, 16, 18, 23, 29, 15}, 7));
    }
}