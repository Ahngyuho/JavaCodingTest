package Prac4;

public class Prob3 {
    int solution(int[] nums,int M) {
        int answer = 0;
        int left = 0;
        int sum = 0;

        for(int right=0;right<nums.length;right++){
            sum += nums[right];

            while(sum > M){
                sum -= nums[left];
                left++;
            }

            if(sum == M) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        int[] nums = new int[]{1, 2, 1, 3, 1, 1, 1, 2};
        System.out.println(T.solution(nums,6));
    }
}
