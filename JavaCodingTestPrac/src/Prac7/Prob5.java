package Prac7;

import java.util.*;

public class Prob5 {
    int solution(int[] nums) {
        Queue<Integer> Q = new LinkedList<>();
        int[] ch;
        Q.offer(0);
        int L = 0;
        int n = nums.length;
        ch = new int[n];
        ch[0] = 1;

        while(!Q.isEmpty()){
            int len=Q.size();
            for(int i=0; i<len; i++){
                int x=Q.poll();
                for(int j=1; j<=nums[x]; j++){
                    if(x+j==n-1) return L+1;
                    if(x+j>=0 && x+j<n && ch[x+j]==0){
                        ch[x+j]=1;
                        Q.offer(x+j);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution(new int[]{2, 2, 0, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
    }
}
