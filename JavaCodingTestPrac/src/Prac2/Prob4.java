package Prac2;
import java.util.*;
public class Prob4 {
    int solution1(int[] nums) {
        int answer = 0;
        int n = nums.length;
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i + 1 < n; i++) if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) peaks.add(i);
        for (int x : peaks) {
            int lx = x;
            int rx = x;
            int cnt = 1;
            while(lx - 1 >=0 && nums[lx] > nums[lx-1]) {
                lx--;
                cnt++;
            }
            while(rx + 1 < n && nums[rx] > nums[rx+1]){
                rx++;
                cnt++;
            }
            answer = Math.max(cnt, answer);
        }
        return answer;
    }
    int solution(int[] nums){
        int answer = 0;
        int n = nums.length;
        ArrayList<Integer> peek = new ArrayList<>();
        for(int i=1;i<n-1;i++) if(nums[i-1] < nums[i] && nums[i] > nums[i+1]) peek.add(i);
        for(int x : peek){
            int lt = x;
            int rt = x;
            int cnt = 1;
            while(lt - 1 >= 0 && nums[lt-1] < nums[lt]) {
                lt--;
                cnt++;
            }
            while(rt + 1 < n && nums[rt+1] < nums[rt]){
                rt++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        int[] arr = new int[]{1, 2, 1, 2, 3, 2, 1};
        System.out.println(T.solution1(arr));
        arr = new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1};
        System.out.println(T.solution1(arr));
    }
}
