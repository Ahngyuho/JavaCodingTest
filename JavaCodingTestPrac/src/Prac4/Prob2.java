package Prac4;

import java.util.Arrays;

public class Prob2 {

    int solution(int nums[],int k){
        int answer = Arrays.stream(nums).reduce(0,(x, y) -> x+y);
        int m = nums.length - k;
        int sum = 0;
        int min;

        for(int i=0;i<m;i++){
            sum += nums[i];
        }

        min = sum;

        for(int i=m;i<nums.length;i++){
            sum += (nums[i] - nums[i-m]);
            min = Math.min(min,sum);
        }

        return answer - min;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        int[] arr = new int[]{2, 3, 7, 1, 2, 1, 5};
        System.out.println(T.solution(arr,4));
    }
}
