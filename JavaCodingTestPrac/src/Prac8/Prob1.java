package Prac8;

import java.util.*;

public class Prob1 {
    int solution(int[] nums){
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int x : nums){
            hs.add(x);
        }
        for (int i = 0; i < nums.length; i++) {
            if(!hs.contains(nums[i] - 1)){
                int cnt = 1;
                int tmp = nums[i];
                while(hs.contains(tmp)){
                    cnt++;
                    tmp++;
                }
                answer  = Math.max(answer,cnt);
            }
        }
        return --answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
    }
}
