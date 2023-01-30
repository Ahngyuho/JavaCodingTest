package Prac2;

public class Prob2 {
    //01 29
    public int solution1(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int left = 0;
        for(int right = 1;right<n;right++){
            if(nums[right] <= nums[right - 1]){
                left = right;
            }else{
                answer = Math.max(nums[right] - nums[left], answer);
            }
        }
        return answer;
    }

    //01 29
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int height = 0;
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]){
                height += nums[i] - nums[i-1];
            }else {answer = Math.max(answer,height);height = 0;}
        }
        answer = Math.max(answer,height);
        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution(new int[]{8, 12, 2, 3, 7, 6, 12, 20, 3}));
        System.out.println(T.solution(new int[]{5, 2, 4, 7, 7, 3, 9, 10, 11}));
    }
}
