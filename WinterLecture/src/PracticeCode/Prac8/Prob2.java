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

        //        public int compareTo(Info o){
//            return o.cnt - this.cnt;
//        }
        @Override
        public int compareTo(Info ob) {
            if (this.cnt == ob.cnt) return this.alpha - ob.alpha;
            else return ob.cnt - this.cnt;
        }
    }

    public String solution2(String s){
        String answer = "";
        HashMap<Character,Integer> nH = new HashMap<>();
        PriorityQueue<Info> pq = new PriorityQueue<>();
        //문자열 안의 각 알파벳의 종류와 개수를 구하기위한 가장 간단한 코드라고 생각
        int[] alpa = new int[26];
        for(char x : s.toCharArray()) alpa[x - 65]++;
        for(int x : alpa) System.out.print(x + " ");
        for(char x : s.toCharArray()) nH.put(x,nH.getOrDefault(x,0) + 1);
//        for(char x : nH.keySet()) pq.offer(new Info(x,nH.get(x)));
//        for(char x : s.toCharArray()) pq.offer(new Info(x, alpa[x - 65]));
        for(int i=0;i<26;i++) if(alpa[i] > 0) pq.offer(new Info((char)(i+65), alpa[i]));
        while(pq.size() > 1){
            Info tmp1 = pq.poll();
            Info tmp2 = pq.poll();
            answer += tmp1.alpha;
            answer += tmp2.alpha;
            if(tmp1.cnt > 1) pq.add(new Info(tmp1.alpha,tmp1.cnt - 1));
            if(tmp2.cnt > 1) pq.add(new Info(tmp2.alpha,tmp2.cnt - 2));
        }
        if(pq.size() == 1) answer += pq.poll().alpha;
        return answer;
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
