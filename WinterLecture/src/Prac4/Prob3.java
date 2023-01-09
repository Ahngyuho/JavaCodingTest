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
            pTime += platTime[i];
            if(pTime + growTime[i] > gTime) gTime = pTime + growTime[i];
        }

        return answer;
    }
}
