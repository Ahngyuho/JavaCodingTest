package realCode.Prac11;

import java.util.*;

public class Prob4 {
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;
        HashMap<String,Integer> node = new HashMap<>();
        for(int i=0;i<n;i++)node.put(subjects[i],i);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(String x : course){
            int a = node.get(x.split(" ")[0]);
            int b = node.get(x.split(" ")[1]);
            graph.get(b).add(a);
            indegree[a]++;
        }
        ArrayList<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        while(!queue.isEmpty()){
            int pre = queue.poll();
            order.add(pre);
            for(int x : graph.get(pre)){
                indegree[x]--;
                if(indegree[x] == 0) queue.offer(x);
            }
        }
        String[] answer = new String[n];
        int idx = 0;
        for(int i=0;i<n;i++){
            answer[i] = subjects[order.get(i)];
            System.out.print(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution( new String[]{"english", "math", "physics", "art", "music"},new String[]{"art math", "physics art", "art music",
                "physics math", "english physics"}));
    }
}
