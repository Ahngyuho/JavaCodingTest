package PracticeCode.Prac10;

public class Prob5 {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int[] minR = new int[n];
        minR[n-1] = nums[n-1];
        for(int i = n - 2;i>=0;i--) minR[i] = Math.min(minR[i+1],nums[i]);
        int curMax = nums[0];
        for(int i=1;i<n;i++){
            curMax = Math.max(nums[i-1],curMax);
            if(curMax <= minR[i]) return i;
        }
        return answer;
    }
    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution(new int[]{1, 3, 2, 0, 7, 9, 8, 7}));
        System.out.println(T.solution(new int[]{3, 5, 3, 1, 2, 5, 3, 5, 7}));
        System.out.println(T.solution(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 1, 5}));
    }
}
