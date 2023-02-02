package PracticeCode.Prac2;
import java.util.*;

public class Prob3{
    //2023 02 01
    public int solution(int[] nums,int m) {
        HashMap<Integer,Integer> nH = new HashMap<>();
        int answer = 0;
        int sum = 0;
        for(int x : nums){
            sum += x;
            if(sum == m) answer++;
            if(nH.containsKey(sum - m)) answer += nH.get(sum - m);
            nH.put(sum,nH.getOrDefault(sum,0) + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3},5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2},3));
        System.out.println(T.solution(new int[]{-1, 0, 1},0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1},0));
    }
}