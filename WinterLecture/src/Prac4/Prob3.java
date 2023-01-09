package Prac4;

import java.util.Arrays;
import java.util.Comparator;

public class Prob3 {
    int solution(int[] platTime, int[] growTime) {
        int answer = 0;

        int[][] tmp = new int[platTime.length][platTime.length];

        for (int i = 0; i < platTime.length; i++) {
            tmp[i][0] = platTime[i];
            tmp[i][1] = growTime[i];
        }

        Arrays.sort(tmp,new Comparator<int []>(){
            @Override
            public int compare(int[] o1,int[] o2){
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }

                return o2[1] - o1[1];
            }
        });

        int pTime = 0;
        int gTime = 0;

        for (int i = 0; i < platTime.length; i++) {
            pTime += tmp[i][0];
            if(pTime + tmp[i][1] > gTime) gTime = pTime + tmp[i][1];
        }

        return gTime;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1,1,1}, new int[]{7,3,2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
