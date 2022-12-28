package Prac5;

import java.util.*;

public class Prob3 {
    int solution(int[] nums,int k){
        int answer = 0;

        int n = nums.length;

        Integer[] tmp;

        if(n % 2 == 1){
            n++;
            tmp = new Integer[n];

            for(int i=0;i<nums.length;i++){
                tmp[i] = nums[i];
            }
            tmp[n-1] = 0;
        }else{
            tmp = new Integer[n];
            for(int i=0;i<nums.length;i++){
                tmp[i] = nums[i];
            }
        }

        Arrays.sort(tmp,Collections.reverseOrder());

        Integer[] diff = new Integer[n/2];

        for (int i = 0; i < n / 2; i++) diff[i] = tmp[i * 2] - tmp[i * 2 + 1];
        Arrays.sort(diff,Collections.reverseOrder());
        for (int i = 0; i < n / 2; i++) answer += (tmp[i * 2 + 1]);
        for (int i = 0; i < k; i++) answer += diff[i];

        return answer;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        int[] arr = new int[]{7, 6, 8, 9, 10};
        System.out.println(T.solution(arr,1));
    }
}
