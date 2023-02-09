package PracticeCode.Prac8;
import java.util.*;
public class Prob2 {
    class Info implements Comparable<Info>{
        char alpha;
        int cnt;

        public Info(char alpha,int cnt){
            this.alpha = alpha;
            this.cnt = cnt;
        }
        public int compareTo(Info o){
            return o.cnt - this.cnt;
        }
    }
    public String solution(String s) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        LinkedList<Character> list = new LinkedList<>();
        HashMap<Character,Integer> nH = new HashMap<>();
        for(char x : s.toCharArray()) nH.put(x,nH.getOrDefault(x,0) + 1);
        for(char x : nH.keySet()) pq.offer(new Info(x,nH.get(x)));
        while(pq.size() > 1){
            Info a = pq.poll();
            Info b = pq.poll();

            list.addLast(a.alpha);
            list.addLast(b.alpha);

            if(a.cnt > 1) pq.offer(new Info(a.alpha,a.cnt - 1));
            if(b.cnt > 1) pq.offer(new Info(b.alpha,b.cnt - 1));
        }
        String answer = "";
        list.addLast(pq.poll().alpha);
        for(char x : list){
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution("AAABBCDEFFG"));
        System.out.println(T.solution("ABCDEFGAAABDEFGFFGE"));
    }
}
