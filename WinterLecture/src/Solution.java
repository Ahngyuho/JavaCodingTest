import java.util.*;
class Solution {
    Stack<Integer> stack = new Stack<>();
    int len;

    List<List<Integer>> answer = new ArrayList<>();
    HashMap<Integer,Integer> nH = new HashMap<>();
    LinkedList<Integer> res = new LinkedList<>();
    public void DFS(int L,int[] nums){
        HashSet<Integer> ts = new HashSet<>();
        if(L == 3){
            System.out.println("seese");
            int sum = 0;
            for(int i=0;i<3;i++){
                int x = res.get(i);
                sum += x;
                if(nH.get(x) == 0) return;
            }
            if(sum != 0) return;
            for(int i=0;i<3;i++){
                int x = res.get(i);
                System.out.print(x + " ");
                nH.put(x,nH.get(x) - 1);
            }
            answer.add(res);
        }else{
            System.out.println(L);
            for(int x : nH.keySet()){
                if(nH.get(x) == 0) continue;
                res.add(x);
                DFS(L+1,nums);
                res.pollLast();
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        len = nums.length;
        for(int x : nums) nH.put(x,nH.getOrDefault(x,0)+1);
        DFS(0,nums);
        for(int i=0;i<answer.size();i++){
            for(int x : answer.get(i)) System.out.print(x + " ");
            System.out.println();
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}