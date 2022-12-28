package Prac4;

public class Prob5 {
    int solution(int[] nums,int k){
        int answer = 0;
        int left = 0;
        int cnt = 0;

        for(int right = 0;right < nums.length; right ++){
            if(nums[right] == 0) cnt++;

            while(cnt > k){
                if(nums[left] == 0) cnt--;
                left++;
            }

            answer = Math.max(answer,right-left+1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        int[] arr = new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(T.solution(arr,2));
    }
}
