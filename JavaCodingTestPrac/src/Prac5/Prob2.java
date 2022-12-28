package Prac5;

import java.util.*;

public class Prob2 {

    public int getAverage(int[] nums, int a, int b) {
        int sum = 0;

        for (int i = a; i <= b; i++) {
            sum += nums[i];
        }

        return sum / (b - a + 1);
    }

    int solution(int[] nums, int d, int k) {
        int answer = 0;
        int sum = 0;

        Arrays.sort(nums);

        if (nums[nums.length - 1] - nums[0] <= d) {
            return getAverage(nums, 0, nums.length - 1);
        } else if (nums[nums.length - 2] - nums[1] <= d) {
            return getAverage(nums, 1, nums.length - 2);
        } else {
            int n = nums.length;
            for (int i = 0; i < n - k; i++) {
                if (nums[i + k - 1] - nums[i] <= d) {
                    return getAverage(nums, i, i + k - 1);
                }
            }
        }

        return nums[nums.length / 2];
    }
}
