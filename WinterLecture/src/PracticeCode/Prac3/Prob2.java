package PracticeCode.Prac3;

import java.util.*;

public class Prob2 {
    public int[] solution4(int[] nums){
        //배열에는 순수 자신의 원래 가지고 있던 값들에 * 2 가 추가된 값들이 들어있다.
        //정렬을 해준 후 해당 값이 map 에 존재하면 answer 에 추가
        //그리고 그 값에 * 2 를 한 수는 현 시점에 배열에 존재할 수 밖에 없다.
        //그래서 현재 x 와 x * 2 를 map 에서 -1 한후 다시 넣어준다.
        //map 에 value 가 0이라는 뜻은 * 2 가 된 값임을 확인하는 것이다.
        int[] answer = new int[nums.length / 2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        Arrays.sort(answer);
        int idx = 0;
        for(int x : nums){
            if(map.get(x) == 0) continue;
            answer[idx] = x;
            map.put(x,map.get(x) - 1);
            map.put(x * 2, map.get(x * 2) - 1);
        }
        return answer;
    }
    public int[] solution3(int[] nums){
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        for(int x : nums){
            if(map.getOrDefault(x * 2,0) == 0) continue;
            res.add(x);
            map.put(x * 2,map.get(x * 2) - 1);
            if(map.get(x) == 0) map.remove(x * 2);
        }
        int[] answer = new int[res.size()];
        for(int i=0;i<res.size();i++) answer[i] = res.get(i);
        Arrays.sort(answer);
        return answer;
    }
    public int[] solution2(int[] nums) {
        HashMap<Integer,Integer> hunsu = new HashMap<>();
        Arrays.sort(nums);
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int x : nums){
            if(!hunsu.containsKey(x)) {
                tmp.add(x);
                hunsu.put(x * 2,hunsu.getOrDefault(x * 2,0) + 1);
            }else {
                hunsu.put(x,hunsu.get(x) - 1);
                if(hunsu.get(x) == 0) hunsu.remove(x);
            }
        }
        int[] answer = new int[tmp.size()];
        for(int i=0;i<tmp.size();i++) answer[i] = tmp.get(i);
        return answer;
    }
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
        for(int x : T.solution3(new int[]{1, 10, 2, 3, 5, 6})){
            System.out.print(x + " ");
        }
        System.out.println();
        for(int x : T.solution3(new int[]{1, 1, 6, 2, 2, 7, 3, 14})){
            System.out.print(x + " ");
        }
        System.out.println();
        for(int x : T.solution3(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})){
            System.out.print(x + " ");
        }
    }
}
