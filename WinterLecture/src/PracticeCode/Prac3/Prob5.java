package PracticeCode.Prac3;
import java.util.*;
public class Prob5 {
    //01 28
    public int solution(int[] nums,int m) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] > m) right = mid - 1;
            else if(nums[mid] < m) left = mid + 1;
            else return mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution(new int[]{23, 87, 65, 12, 57, 32, 99, 81}, 32));
    }
}
