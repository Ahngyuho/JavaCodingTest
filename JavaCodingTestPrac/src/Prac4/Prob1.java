package Prac4;

public class Prob1 {

    public int solution(int[] nums,int k){
        int answer = 0;
        int sum = 0;

        for(int i=0;i<k;i++){
            sum += nums[i];
        }

        answer = sum;

        for(int i=k;i<nums.length;i++) {
            sum += (nums[i] - nums[i - k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        int[] arr = new int[]{12, 15, 11, 20, 25, 10, 20, 19, 13, 15};
        System.out.println(T.solution(arr,3));
    }
}
