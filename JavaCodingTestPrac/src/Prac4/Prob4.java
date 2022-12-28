package Prac4;

public class Prob4 {

    int solution(int[] nums,int k){
        int answer = 0;
        int sum = 0;
        int left = 0;

        for(int right=0;right<nums.length;right++){
            sum += nums[right];

            while(sum > k){
                sum -= nums[left];
                left++;
            }

            answer += (right - left + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        int []arr = new int[]{1, 3, 1, 2, 3};
        System.out.println(T.solution(arr,5));
    }
}
