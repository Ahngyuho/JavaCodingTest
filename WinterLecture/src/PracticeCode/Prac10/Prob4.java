package PracticeCode.Prac10;

public class Prob4 {
    public int solution1(int[] nums) {
        int min_idx = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(min > nums[i]){
                min_idx = i;
                min = nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=min_idx;i++){
            if(max < nums[i]) max = nums[i];
        }
        int tmp = nums[min_idx];
        int max_idx = min_idx+1;
        for(int i=min_idx+1;i<n;i++){
            if(nums[i] <= max && nums[i] >= tmp){
                tmp = nums[i];
                max_idx = i;
                System.out.println(tmp + " " + max_idx);
            }
        }
        return max_idx;
    }
    public int solution(int[] nums){
        int answer = 0;
        int n = nums.length;
        int[] minR = new int[n];
        minR[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--) minR[i] = Math.min(nums[i], minR[i+1]);
        int curMax = nums[0];
        for(int i = 1; i < n; i++){
            curMax = Math.max(curMax, nums[i - 1]);
            if(curMax <= minR[i]) return i;
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution(new int[]{1, 3, 2, 0, 7, 9, 8, 7}));
        System.out.println(T.solution(new int[]{3, 5, 3, 1, 2, 5, 3, 5, 7}));
        System.out.println(T.solution(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 1, 5}));
    }
}
