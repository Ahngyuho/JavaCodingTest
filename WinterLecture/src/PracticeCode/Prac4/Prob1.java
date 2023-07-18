package PracticeCode.Prac4;
import java.util.*;

public class Prob1 {
    public int solution(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int answer = 0;
        int right=nums.length - 1;
        while (right >= left) {
            if(nums[right] + nums[left] > 5) {answer++;}
            else {answer++;left++;}
            right--;
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
