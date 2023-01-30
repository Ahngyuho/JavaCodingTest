package Prac2;

public class Prob1 {
    //01 29
    public int[] solution(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int left = 0;
        int right = n - 1;
        int tmp = 0;
        for(int i=n-1;i>=0;i--){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                tmp = nums[right];
                right--;
            }else{
                tmp = nums[left];
                left++;
            }
            answer[i] = tmp * tmp;
        }
        for(int x : answer) System.out.print(x + " ");
        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution(new int[]{-4, -1, 0, 3, 10}));
        System.out.println(T.solution(new int[]{-7, -3, 2, 3, 11}));
    }
}
