package Prac4;

import java.util.*;

public class Prob2 {
    int solution(int[][] meetings) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();

        for (int[] x : meetings) {
            list.add(new int[]{x[0],2});
            list.add(new int[]{x[1], 1});
        }

        //오름차순
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int max = Integer.MIN_VALUE;

        for (int[] x : list) {
            System.out.println(x[0] + " " + x[1]);
            if(x[1] == 2) {
                answer++;
                max = Math.max(answer, max);
            }
            else answer--;
        }

        return max;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution(new int[][]{{0, 10}, {12, 25}, {5, 15}}));
    }
}
