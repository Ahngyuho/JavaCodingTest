package PracticeCode.Prac5;
import java.util.*;
public class Prob1 {

    public int solution2(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> nH = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(nH.getOrDefault(sum,0) == 0) nH.put(sum,1);
            }
        }
        for (int x : nH.keySet()) {
            if((x % 2) == 1) answer++;
        }
        return answer;
    }
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

    public int solution5(int[][] relationships, int target, int limit) {
        int answer = 0;
        HashMap<Integer,ArrayList<Integer>> nH = new HashMap<>();
        for (int i = 0; i <= 100; i++) nH.put(i, new ArrayList<>());
        for(int[] x : relationships){
            nH.get(x[0]).add(x[1]);
            nH.get(x[1]).add(x[0]);
        }
        int L = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] ch = new boolean[101];
        ch[target] = true;
        for(int x : nH.get(target)) {
            ch[x] = true;
            answer += 5;
            q.add(x);
        }
        while(!q.isEmpty()){
            L++;
            int len = q.size();
            for(int i=0;i<len;i++){
                int tmp = q.poll();
                for(int x : nH.get(tmp)){
                    if(!ch[x]) {ch[x] = true;q.add(x);answer+=10;}
                }
            }
            if(L == limit) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution2(new int[]{1, 3, 5}));
//        System.out.println(T.solution(new int[]{2, 4, 6, 8, 10}));
        System.out.println(T.solution2(new int[]{1, 2, 6, 2, 4, 3, 5, 3, 5, 3, 6, 3, 5, 4, 2, 3, 5, 1, 4, 3, 6}));
//        System.out.println(T.solution(new int[]{1,2,6,2,4,3}));
    }
}
