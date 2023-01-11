package Prac4;

import java.util.Arrays;
import java.util.Comparator;

/*
* 열매가 열리는 최단시간
* 현수는 화단에 꽃씨를 뿌려 꽃을 피게 하려고 합니다.
현수는 N개의 꽃씨 종류를 가지고 있습니다. 각 꽃씨는 종류별로 현수가 씨를 심은 기간과 심
어진 씨가 성장해서 꽃이 피는 기간이 이 있습니다.
만약 어떤 꽃씨가 심는기간이 2, 성장하는 기간이 3이라면 현수가 2일동안 꽃씨를 화단에 심
고, 3일동안 자란 다음에 꽃이 핍니다. 즉 5일 째에 꽃이 피는 것입니다.
현수는 하루에 하나의 꽃씨만 심을 수 있습니다.
매겨변수 plantTime에 각 꽃씨의 심는 기간이 주어지고, growTime에 꽃씨가 성장하는 기간이
주어지면 현수가 모든 꽃씨를 화단에 심고, 모든 꽃이 피기까지 걸리는 최단시간을 반환하는
프로그램을 작성하세요.
*
* 입출력 예
plantTime growTime answer
[1, 3, 2] [2, 3, 2] 8
[2, 1, 4, 3] [2, 5, 3, 1] 11
[1, 1, 1] [7, 3, 2] 8
[5, 7, 10, 15, 7, 3, 5] [6, 7, 2, 10, 15, 6, 7] 54
[1, 2, 3, 4, 5, 6, 7] [7, 5, 4, 3, 2, 1, 6] 29
* */

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
