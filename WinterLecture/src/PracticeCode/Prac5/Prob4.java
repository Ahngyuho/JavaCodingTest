package PracticeCode.Prac5;

import java.util.*;

public class Prob4 {
    public int solution(int[] cost,int m) {
        int left = 0;
        int answer = 0;
        int sum = 0;
        for(int right = 0;right < cost.length;right++){
            sum += cost[right];
            //left가 right를 한칸 앞지르는 순간이 있긴 하지만 한 순간일뿐 for문이 다시 위로 올라가면 right가 값이 하나 올라가 left와 같아진다
            //right 와 left 가 같아지는 순간은 해당 배열 인덱스 안에 값이 m 보다도 크기 때문이다. 그러면 left 가 right 보다 한칸 앞서지만 for문 위로 올라가면 right도 하나 증가해서
            //결국 같아지고 left 에 배열의 길이보다 더 긴 값이 넣어지는 경우는 없다고 본다.
            while(sum > m){
                sum -= cost[left];
                left++;
            }
            answer = Math.max(answer,right - left + 1);
        }
        return answer;
    }

    public int solution1(int[] cost, int m) {
        int answer = 0;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < cost.length; right++) {
            sum += cost[right];
            while(sum > m){
                sum -= cost[left];
                answer = Math.max(answer,right - left + 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution(new int[]{0, 150, 100, 0, 150, 0, 70, 140}, 350));
        System.out.println(T.solution(new int[]{100, 200, 300, 400, 500, 100}, 300));
    }
}
