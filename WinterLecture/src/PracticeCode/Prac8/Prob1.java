package PracticeCode.Prac8;
import java.util.*;
public class Prob1 {
    //2023 02 08
    public int solution1(int[] nums) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int x : nums) hs.add(x);
        for(int x : hs){
            if(hs.contains(x - 1)) continue;
            int cnt = 0;
            while(hs.contains(x)){
                cnt++;
                x++;
            }
            answer = Math.max(cnt,answer);
        }
        return answer;
    }
    //2023 02 08
    public int solution(int[] nums) {
        TreeSet<Integer> hs = new TreeSet<>();
        HashMap<Integer,Integer> nH = new HashMap<>();
        for(int x : nums){
            hs.add(x);
            nH.put(x,nH.getOrDefault(x,0) + 1);
        }
        int answer = 1;
        int cnt = 1;
        for(int x : hs){
            if(nH.containsKey(x + 1)){
                cnt++;
                answer = Math.max(cnt,answer);
            }else cnt = 1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution1(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution1(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution1(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution1(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
