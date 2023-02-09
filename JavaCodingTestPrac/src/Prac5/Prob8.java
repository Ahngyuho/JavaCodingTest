package Prac5;
import java.util.*;
public class Prob8 {
    //02 03
    public int solution1(int[][] nums) {
        int answer = 0;
        Arrays.sort(nums,(a,b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int n = nums.length;
        int maxd = nums[0][1];
        int j = 0;
        for(int i = maxd;i>=1;i--){
            for(;j<n;j++){
                if(nums[j][1] < i) break;
                pq.offer(nums[j][0]);
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }
        return answer;
    }
    //02 03
    public int solution(int[][] nums) {
        int answer = 0;
        Arrays.sort(nums,(a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        int n = nums.length;
        pq.offer(nums[0][0]);
        for(int i=1;i<n;i++){
            if(!pq.isEmpty() && pq.peek() < nums[i][0] && pq.size() == nums[i][1]){
                pq.poll();
            }
            pq.offer(nums[i][0]);
        }
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob8 T = new Prob8();
        System.out.println(T.solution1(new int[][]{{50, 2}, {20, 1}, {40, 2}, {60, 3}, {30, 3}, {30, 1}}));
        System.out.println(T.solution1(new int[][]{{50, 2}, {40, 2}, {20, 1}, {10, 1}}));
    }
}
