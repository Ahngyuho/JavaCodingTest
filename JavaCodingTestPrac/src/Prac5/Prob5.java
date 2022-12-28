package Prac5;

import java.util.*;

public class Prob5 {
    int solution(int[][] times){
        int answer = 0;

        Arrays.sort(times,(a,b) -> a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);

        int et = 0;
        for(int[] x:times){
            System.out.println(x[0] + " " + x[1]);
            if(x[0] >= et){
                answer++;
                et=x[1];
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Prob5 T = new Prob5();
        System.out.println(T.solution(new int[][]{{1, 4}, {2, 3}, {3, 5}, {4, 6}, {5, 7}}));
    }
}
