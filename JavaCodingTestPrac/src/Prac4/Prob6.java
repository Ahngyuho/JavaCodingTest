package Prac4;

public class Prob6 {

    int counting(int[] nums,int k){
        int result = 0;
        int left = 0;
        int cnt = 0;
        for(int right=0;right<nums.length;right++){
            if(nums[right] % 2 == 1) cnt++;

            while(cnt > k){
                if(nums[left] % 2 == 1) cnt--;
                left++;
            }

            result += right - left + 1;
        }

        return result;
    }
    int solution(int[] nums,int k){
        int answer = 0;
        answer = counting(nums,k) - counting(nums,k-1);
        return answer;
    }



    public static void main(String[] args) {
        Prob6 T = new Prob6();
        int[] arr = new int[]{1, 2, 1, 1, 2};
        System.out.println(T.solution(arr,2));
    }
}
