package PracticeCode.Prac5;
import java.util.*;
public class Prob1 {
    public int solution1(int[] nums){
        int answer = 0;
        HashMap<Integer,Integer> sumH = new HashMap<>();
        int sum = 0;
        for(int x : nums){
            sum += x;
            if(sum % 2 == 1) answer++;
            if(sumH.containsKey(sum - x) && (sum-x) % 2 == 1) answer += sumH.get(sum - x);
            sumH.put(sum - x,sumH.getOrDefault(sum - x , 0) + 1);
        }
        return answer;
    }
    public int solution(int[] nums){
        int answer = 0;
        int[] nH = new int[2];
        int sum = 0;
        nH[0] = 1;
        for(int x : nums){
            System.out.println(x);
            sum += x;
            if(sum % 2 == 1) answer += nH[0];
            else answer += nH[1];
            System.out.println(nH[0] + " " + nH[1] + " " + answer);
            nH[sum % 2] += 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
//        System.out.println(T.solution(new int[]{1, 3, 5}));
//        System.out.println(T.solution(new int[]{2, 4, 6, 8, 10}));
//        System.out.println(T.solution(new int[]{1, 2, 6, 2, 4, 3, 5, 3, 5, 3, 6, 3, 5, 4, 2, 3, 5, 1, 4, 3, 6}));
        System.out.println(T.solution(new int[]{1,2,6,2,4,3}));
    }
}
