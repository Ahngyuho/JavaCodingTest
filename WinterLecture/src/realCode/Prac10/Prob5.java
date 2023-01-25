package realCode.Prac10;

import java.util.*;

public class Prob5 {
    int solution(int[][] apples,int s,int k){
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] x : apples){
            map.put(x[0],x[1]);
        }
        map.put(s,map.getOrDefault(s,0));
        int[] maxL = new int[k+1];
        int[] maxR = new int[k+1];
        //i번 왼쪽으로 이동했을 때 얻을 수 있는 최대 사과 개수 이런 정의 정확하게...
        maxL[0] = map.getOrDefault(s,0);
        maxR[1] = map.getOrDefault(s, 0);
        answer = maxL[0];

        for(int i=1;i<=k;i++){
            if (s - i >= 0) {
                maxL[i] = maxL[i - 1] + map.getOrDefault(s - i, 0);
            } else maxL[i] = maxL[i - 1];

            maxR[i] = maxR[i - 1] + map.getOrDefault(s + i, 0);
        }

        return answer;
    }
}
