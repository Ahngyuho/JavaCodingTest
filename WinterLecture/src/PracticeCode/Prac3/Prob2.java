package PracticeCode.Prac3;

import java.util.*;

public class Prob2 {
    public int[] solution(int[] nums) {
        int[] answer;
        ArrayList<Integer> tmp = new ArrayList<>();
        HashMap<Integer,Integer> hM = new HashMap<>();
        Arrays.sort(nums);
        for(int x : nums) hM.put(x,hM.getOrDefault(x,0) + 1);
        for(int x : nums){
            if(hM.get(x) == 0) continue;
            tmp.add(x);
            hM.put(x,hM.get(x) - 1);
            hM.put(x*2,hM.get(x*2) - 1);
        }
        answer = new int[tmp.size()];
        for(int i=0;i<tmp.size();i++) answer[i] = tmp.get(i);
        return answer;
    }

    //01 28
    public int[] solution1(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> nH = new HashMap<>();
        for(int i=0;i<n;i++){
            nH.put(nums[i],nH.getOrDefault(nums[i],0) + 1);
        }
        Arrays.sort(nums);
        for(int x : nums){
            if(nH.get(x) > 0){
                res.add(x);
                if(nH.get(x*2) > 0) nH.put(x*2,nH.get(x*2) - 1);
            }
        }
        int[] answer = new int[res.size()];
        for(int i=0;i<res.size();i++) answer[i] = res.get(i);
        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        for(int x : T.solution1(new int[]{1, 10, 2, 3, 5, 6})){
            System.out.print(x + " ");
        }
        System.out.println();
        for(int x : T.solution1(new int[]{1, 1, 6, 2, 2, 7, 3, 14})){
            System.out.print(x + " ");
        }
        System.out.println();
        for(int x : T.solution1(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})){
            System.out.print(x + " ");
        }
    }
}
